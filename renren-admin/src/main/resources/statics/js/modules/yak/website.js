$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'yak/website/list',
        datatype: "json",
        colModel: [			
			{ label: 'ID', name: 'id', index: 'id', width: 50, key: true },
			{ label: '分类ID', name: 'categoryId', index: 'category_id', width: 80 }, 			
			{ label: '网站名称', name: 'name', index: 'name', width: 80 }, 			
			{ label: '网址', name: 'url', index: 'url', width: 80 }, 			
			{ label: '分类图标', name: 'icon', index: 'icon', width: 80 }, 			
			{ label: '描述', name: 'description', index: 'description', width: 80 }, 			
			{ label: '遮罩描述', name: 'shade', index: 'shade', width: 80 }, 			
			{ label: '创建时间', name: 'createdAt', index: 'created_at', width: 80 }, 			
			{ label: '更新时间', name: 'updatedAt', index: 'updated_at', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		website: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.website = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.website.id == null ? "yak/website/save" : "yak/website/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.website),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "yak/website/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "yak/website/info/"+id, function(r){
                vm.website = r.website;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});