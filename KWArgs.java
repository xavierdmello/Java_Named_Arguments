/**
 * Pass variables into methods based off name, not position. Inspired by Python's '**kwargs' magic variable.
 * 'KW' == 'Keyword'
 * 4/14/2022 Added support for default value arguments.
 */

package kwargs;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class KWArgs {
    // Example
    public static void main(String[] args) {
        isInRange("num", 6, "min", 2, "max", 7);
    } // end main()

    // Example
    private static void isInRange(Object... objs) {
        Map<String, Integer> kwmap = kwInteger(objs);
        int max = kwmap.get("max");
        int min = kwmap.get("min");
        int num = kwmap.get("num");

        if (num < max && num > min) {
            System.out.println(num + " is in between " + min + " and " + max + ".");
        } else {
            System.out.println(num + " is NOT in between " + min + " and " + max + ".");
        }
    } // end isInRange()

    /**
     * Wraps Object vararg into Map, emulating Python's '**kwargs' magic variable. Dynamic.
     *
     * @param kwargs Object vararg, where args alternate between String (keyword) and Object (value).
     * @return Map of String to Object, such that each even index vararg 'i' corresponds to vararg 'i+1'.
     * @throws NoSuchElementException on improper varargs input.
     */
    public static Map<String, Object> kw(Object[] kwargs, Object... defaultargs) {
        // Make sure the kwargs and defaultargs alternate between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("Key '" + kwargs[kwargs.length - 1] + "' has no matching value.");
        }
        if (defaultargs.length % 2 != 0) {
            throw new NoSuchElementException("Default argument with key '" + defaultargs[defaultargs.length - 1] + "' has no matching value.");
        }

        // Set any default arguments in keyword map
        Map<String, Object> kwmap = new HashMap<>();
        for (int i = 0; i < defaultargs.length; i = i + 2) {
            kwmap.put((String) defaultargs[i], defaultargs[i + 1]);
        }

        // Set keyword arguments in keyword map. Will overwrite any default arguments that were just set.
        for (int i = 0; i < kwargs.length; i = i + 2) {
            kwmap.put((String) kwargs[i], kwargs[i + 1]);
        }
        return kwmap;
    } // end kw()

    /**
     * Wraps Object vararg into Map, emulating Python's '**kwargs' magic variable. Static.
     *
     * @param kwargs Object vararg, where args alternate between String (keyword) and String (value).
     * @return Map of String to String, such that each even index vararg 'i' corresponds to vararg 'i+1'.
     * @throws NoSuchElementException on improper varargs input.
     */
    public static Map<String, String> kwString(Object[] kwargs, Object... defaultargs) {
        // Make sure the kwargs and defaultargs alternate between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("Key '" + kwargs[kwargs.length - 1] + "' has no matching value.");
        }
        if (defaultargs.length % 2 != 0) {
            throw new NoSuchElementException("Default argument with key '" + defaultargs[defaultargs.length - 1] + "' has no matching value.");
        }

        // Set any default arguments in keyword map
        Map<String, String> kwmap = new HashMap<>();
        for (int i = 0; i < defaultargs.length; i = i + 2) {
            if (!(defaultargs[i+1] instanceof String)) {
                throw new IllegalArgumentException("Default argument with value '" + defaultargs[i+1] + "' of type " + defaultargs[i+1].getClass().getSimpleName() + " not allowed in kwargs of type String");
            }
            kwmap.put((String) defaultargs[i], (String) defaultargs[i + 1]);
        }

        // Set keyword arguments in keyword map. Will overwrite any default arguments that were just set.
        for (int i = 0; i < kwargs.length; i = i + 2) {
            if (!(kwargs[i+1] instanceof String)) {
                throw new IllegalArgumentException("Value '" + kwargs[i+1] + "' of type " + kwargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type String");
            }
            kwmap.put((String) kwargs[i], (String) kwargs[i + 1]);
        }
        return kwmap;
    } // end kwString()

    /**
     * Wraps Object vararg into Map, emulating Python's '**kwargs' magic variable. Static.
     *
     * @param kwargs Object vararg, where args alternate between String (keyword) and Double (value).
     * @return Map of String to Double, such that each even index vararg 'i' corresponds to vararg 'i+1'.
     * @throws NoSuchElementException on improper varargs input.
     */
    public static Map<String, Double> kwDouble(Object[] kwargs, Object... defaultargs) {
        // Make sure the kwargs and defaultargs alternate between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("Key '" + kwargs[kwargs.length - 1] + "' has no matching value.");
        }
        if (defaultargs.length % 2 != 0) {
            throw new NoSuchElementException("Default argument with key '" + defaultargs[defaultargs.length - 1] + "' has no matching value.");
        }

        // Set any default arguments in keyword map
        Map<String, Double> kwmap = new HashMap<>();
        for (int i = 0; i < defaultargs.length; i = i + 2) {
            if (!(defaultargs[i+1] instanceof Double)) {
                throw new IllegalArgumentException("Default argument with value '" + defaultargs[i+1] + "' of type " + defaultargs[i+1].getClass().getSimpleName() + " not allowed in kwargs of type Double");
            }
            kwmap.put((String) defaultargs[i], (Double) defaultargs[i + 1]);
        }

        // Set keyword arguments in keyword map. Will overwrite any default arguments that were just set.
        for (int i = 0; i < kwargs.length; i = i + 2) {
            if (!(kwargs[i+1] instanceof Double)) {
                throw new IllegalArgumentException("Value '" + kwargs[i+1] + "' of type " + kwargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Double");
            }
            kwmap.put((String) kwargs[i], (Double) kwargs[i + 1]);
        }
        return kwmap;
    } // end kwDouble()

    /**
     * Wraps Object vararg into Map, emulating Python's '**kwargs' magic variable. Static.
     *
     * @param kwargs Object vararg, where args alternate between String (keyword) and Integer (value).
     * @return Map of String to Integer, such that each even index vararg 'i' corresponds to vararg 'i+1'.
     * @throws NoSuchElementException on improper varargs input.
     */
    public static Map<String, Integer> kwInteger(Object[] kwargs, Object... defaultargs) {
        // Make sure the kwargs and defaultargs alternate between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("Key '" + kwargs[kwargs.length - 1] + "' has no matching value.");
        }
        if (defaultargs.length % 2 != 0) {
            throw new NoSuchElementException("Default argument with key '" + defaultargs[defaultargs.length - 1] + "' has no matching value.");
        }

        // Set any default arguments in keyword map
        Map<String, Integer> kwmap = new HashMap<>();
        for (int i = 0; i < defaultargs.length; i = i + 2) {
            if (!(defaultargs[i+1] instanceof Integer)) {
                throw new IllegalArgumentException("Default argument with value '" + defaultargs[i+1] + "' of type " + defaultargs[i+1].getClass().getSimpleName() + " not allowed in kwargs of type Integer");
            }
            kwmap.put((String) defaultargs[i], (Integer) defaultargs[i + 1]);
        }

        // Set keyword arguments in keyword map. Will overwrite any default arguments that were just set.
        for (int i = 0; i < kwargs.length; i = i + 2) {
            if (!(kwargs[i+1] instanceof Integer)) {
                throw new IllegalArgumentException("Value '" + kwargs[i+1] + "' of type " + kwargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Integer");
            }
            kwmap.put((String) kwargs[i], (Integer) kwargs[i + 1]);
        }
        return kwmap;
    } // end kwInt()

    /**
     * Wraps Object vararg into Map, emulating Python's '**kwargs' magic variable. Static.
     *
     * @param kwargs Object vararg, where args alternate between String (keyword) and Boolean (value).
     * @return Map of String to Boolean, such that each even index vararg 'i' corresponds to vararg 'i+1'.
     * @throws NoSuchElementException on improper varargs input.
     */
    public static Map<String, Boolean> kwBoolean(Object[] kwargs, Object... defaultargs) {
        // Make sure the kwargs and defaultargs alternate between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("Key '" + kwargs[kwargs.length - 1] + "' has no matching value.");
        }
        if (defaultargs.length % 2 != 0) {
            throw new NoSuchElementException("Default argument with key '" + defaultargs[defaultargs.length - 1] + "' has no matching value.");
        }

        // Set any default arguments in keyword map
        Map<String, Boolean> kwmap = new HashMap<>();
        for (int i = 0; i < defaultargs.length; i = i + 2) {
            if (!(defaultargs[i+1] instanceof Boolean)) {
                throw new IllegalArgumentException("Default argument with value '" + defaultargs[i+1] + "' of type " + defaultargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Boolean");
            }
            kwmap.put((String) defaultargs[i], (Boolean) defaultargs[i + 1]);
        }

        // Set keyword arguments in keyword map. Will overwrite any default arguments that were just set.
        for (int i = 0; i < kwargs.length; i = i + 2) {
            if (!(kwargs[i+1] instanceof Boolean)) {
                throw new IllegalArgumentException("Value '" + kwargs[i+1] + "' of type " + kwargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Boolean");
            }
            kwmap.put((String) kwargs[i], (Boolean) kwargs[i + 1]);
        }
        return kwmap;
    } // end kwBool()
} // end class KWArgs
