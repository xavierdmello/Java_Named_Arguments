/**
 * Pass variables into methods based off name, not position. Inspired by Python's '**kwargs' magic variable.
 * 'KW' == 'Keyword'
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
    public static Map<String, Object> kw(Object[] kwargs) {
        // Make sure the vararg alternates between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("Key '" + kwargs[kwargs.length - 1] + "' has no matching value.");
        }

        Map<String, Object> kwmap = new HashMap<>();
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
    public static Map<String, String> kwString(Object[] kwargs) {
        // Make sure the vararg alternates between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("Key '" + kwargs[kwargs.length - 1] + "' has no matching value.");
        }

        Map<String, String> kwmap = new HashMap<>();
        for (int i = 0; i < kwargs.length; i = i + 2) {
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
    public static Map<String, Double> kwDouble(Object[] kwargs) {
        // Make sure the vararg alternates between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("Key '" + kwargs[kwargs.length - 1] + "' has no matching value.");
        }

        Map<String, Double> kwmap = new HashMap<>();
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
    public static Map<String, Integer> kwInteger(Object[] kwargs) {
        // Make sure the vararg alternates between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("Key '" + kwargs[kwargs.length - 1] + "' has no matching value.");
        }

        Map<String, Integer> kwmap = new HashMap<>();
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
    public static Map<String, Boolean> kwBoolean(Object[] kwargs) {
        // Make sure the vararg alternates between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("Key '" + kwargs[kwargs.length - 1] + "' has no matching value.");
        }

        Map<String, Boolean> kwmap = new HashMap<>();
        for (int i = 0; i < kwargs.length; i = i + 2) {
            if (!(kwargs[i+1] instanceof Boolean)) {
                throw new IllegalArgumentException("Value '" + kwargs[i+1] + "' of type " + kwargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Boolean");
            }
            kwmap.put((String) kwargs[i], (Boolean) kwargs[i + 1]);
        }
        return kwmap;
    } // end kwBool()
} // end class KWArgs
