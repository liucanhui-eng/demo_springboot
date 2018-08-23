package ${package};



public interface ${Entity}Service {
    //插入
    boolean register( ${Entity}  ${entity});
    //修改
    boolean update${Entity}( ${Entity}   ${entity});
    //删除by id
     boolean del${Entity}ById(String id);

    //查询所有
    List<${Entity}> queryAll${Entity}();


    //按条件查询
    List<${Entity}> query${Entity}ByExample(${Entity}  ${entity});


}
