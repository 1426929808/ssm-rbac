# 依据权限生成菜单树
访问地址:/privileges/query?id={userId}得到用户的所有菜单项,具体的内容见menu.jsp,访问地址为
/test/menu .
> 注意:需要先登录之后才能请求到数据

# 树控件的使用
见tree.jsp页面(访问地址为/tree),树控件需要的数据格式如下
```json
[
    {
        "name": "借阅书籍",
        "checked": "true",
        "pId": 0,
        "id": "1",
        "open": "true"
    },
    {
        "name": "图书信息",
        "checked": "true",
        "pId": 0,
        "id": "2",
        "open": "true"
    }
]
```
json中各字段的含义如下:
- id表示节点id
- pId表示其父节点的id值
- name就是节点的文字描述
- checked表示是否选中
- open表示是否展开


# 参考资料
https://github.com/zTree/zTree_v3 中的demo/cn/excheck/checkbox_count.html这个案例可以看到