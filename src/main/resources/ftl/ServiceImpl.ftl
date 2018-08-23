
package ${package}
@Service
public class ${Entity}ServiceImpl implements ${Entity}Service {

    @Autowired
    ${Entity}Mapper ${entity}Mapper;

    @Override
    public boolean register(${Entity} ${entity}) {

        return ${entity}Mapper.insert(${entity}) == 1;
    }

    @Override
    public boolean update${Entity}(${Entity} ${entity}) {
        int i = ${entity}Mapper.updateByPrimaryKeySelective(${entity});
        return i == 1;
    }

    @Override
    public boolean del${Entity}ById(String id) {
        int i = 0;
        try {
            int key = Integer.valueOf(id);
            i = ${entity}Mapper.deleteByPrimaryKey(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i == 1;
    }

    @Override
    public List<${Entity}> queryAll${Entity}() {
    return ${entity}Mapper.queryAll();
    }

    @Override
    public List<${Entity}> query${Entity}ByExample(${Entity} ${entity}) {
        Map<String, Object> map = new HashMap<>();
        Class ${entity}Class = ${entity}.getClass();
        Field[] fields = ${entity}Class.getFields();
        for (Field field : fields) {
        if (field != null && field.toString() != "") {
        String mname = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
        Method method = null;
        try {
        method = ${entity}Class.getDeclaredMethod(mname);
        if (method != null) {
        map.put(field.getName(), method.invoke(${entity}));
        }
        } catch (Exception e) {
        e.printStackTrace();
        }

        }
        }

        return ${entity}Mapper.selectBySelective(map);
        }
        }
