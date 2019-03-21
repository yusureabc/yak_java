$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'yak/website/list',
        datatype: "json",
        colModel: [			
            { label: 'ID', name: 'id', index: 'id', width: 50, key: true },
            { label: '分类', name: 'categoryName', index: 'category_name', width: 80 },
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

var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "categoryId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    }
};
var ztree;

var vm = new Vue({
    el:'#rrapp',
    data:{
        showList: true,
        title: null,
        website: {
            categoryId: null,
            categoryName: null
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.website = {categoryName:null, categoryId:null};
            vm.getCategory();
        },
        getCategory: function() {
            // 加载分类树
            $.get( baseURL + "yak/category/list", function(r) {
                ztree = $.fn.zTree.init( $("#categoryTree"), setting, r.page.list );
                var node = ztree.getNodeByParam( "id", vm.website.categoryId );
                if ( node != null )
                {
                    ztree.selectNode( node );

                    vm.website.categoryName = node.name;
                }
            })
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

                vm.getCategory();
            });
        },
        categoryTree: function() {
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择分类",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#categoryLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    /* 选中之后回写页面展示 */
                    vm.website.categoryId = node[0].id;
                    vm.website.categoryName = node[0].name;

                    layer.close(index);
                }
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