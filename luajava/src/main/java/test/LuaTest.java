package test;

import org.junit.Test;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class LuaTest {
    public static void main(String[] args) throws Exception {

//        String often="\"often\"";
//        String def="\"default\"";
//        String none="\"none\"";
//        String rare="\"rare\"";
//
//        HashMap<String, Object> map_inner1 = new LinkedHashMap<>();
//        map_inner1.put("alternatehunt", often);
//        map_inner1.put("angrybees", def);
//        map_inner1.put("antliontribute", none);
//
//        HashMap<String, Object> map = new LinkedHashMap<>();
//        map.put("hideminimap", false);
//        map.put("id", "\"CUSTOM_PRESET_4\"");
//        map.put("overrides", map_inner1);
//
//        System.out.println(map);

        load2();
    }

    @Test
    public void test(){
        Globals globals = JsePlatform.standardGlobals();
        LuaValue luaValue = globals.get("dofile").call(LuaValue.valueOf("lua/hello.lua"));

    }

    private static void load2() throws Exception{
        Globals globals = JsePlatform.standardGlobals();
        LuaValue luaValue = globals.get("dofile").call(LuaValue.valueOf("lua/leveldataoverride-master.lua"));
        System.out.println(luaValue.type() == LuaValue.TTABLE);
        System.out.println(luaValue);
        System.out.println(luaValue.get("id"));

        System.out.println(luaValue.type());

        Object[] coerce = (Object[]) coerce(luaValue);
        for (Object o : coerce) {
            System.out.println(o);
        }

    }
    public static Object coerce(LuaValue value) {
        switch ( value.type() ) {
            case LuaValue.TTABLE: {
                int n = value.length();
                Object a = Array.newInstance(Object.class, n);
                for ( int i=0; i<n; i++ )
                    Array.set(a, i, LuaTest.coerce(value.get(i+1)));
                return a;
            }
            case LuaValue.TUSERDATA:
                return value.touserdata();
            case LuaValue.TNIL:
                return null;
            default:
                return null;
        }

    }

}
