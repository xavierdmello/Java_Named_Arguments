package kwargs;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Pass variables into methods based off name, not position. Inspired by Python's '**kwargs' magic variable.
 * 'KW' == 'Keyword'
 * 4/14/2022 Added support for default value arguments.
 */
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
     * @param defaultargs Optional default values of kwargs in aforementioned kwargs format.
     * @return Map of String to Object, such that each even index vararg 'i' corresponds to vararg 'i+1'.
     * @throws NoSuchElementException If arguments are not in key, value format
     * @throws IllegalArgumentException If key in key-value pair is not String
     */
    public static Map<String, Object> kw(Object[] kwargs, Object... defaultargs) {
        // Make sure the kwargs and defaultargs alternate between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("KWargs are not in key, value format.");
        }
        if (defaultargs.length % 2 != 0) {
            throw new NoSuchElementException("Default arguments are not in key, value format.");
        }

        // Set any default arguments in keyword map
        Map<String, Object> kwmap = new HashMap<>();
        for (int i = 0; i < defaultargs.length; i = i + 2) {
            if (!(defaultargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key in default arguments must be of type String, not '" + defaultargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) defaultargs[i], defaultargs[i + 1]);
        }

        // Set keyword arguments in keyword map. Will overwrite any default arguments that were just set.
        for (int i = 0; i < kwargs.length; i = i + 2) {
            if (!(kwargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key must be of type String, not '" + kwargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) kwargs[i], kwargs[i + 1]);
        }
        return kwmap;
    } // end kw()

    /**
     * Wraps Object vararg into Map, emulating Python's '**kwargs' magic variable. Static.
     *
     * @param kwargs Object vararg, where args alternate between String (keyword) and String (value).
     * @param defaultargs Optional default values of kwargs in aforementioned kwargs format.
     * @return Map of String to String, such that each even index vararg 'i' corresponds to vararg 'i+1'.
     * @throws NoSuchElementException If arguments are not in key, value format
     * @throws IllegalArgumentException If value in key-value pair is not String
     * @throws IllegalArgumentException If key in key-value pair is not String
     */
    public static Map<String, String> kwString(Object[] kwargs, Object... defaultargs) {
        // Make sure the kwargs and defaultargs alternate between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("KWargs are not in key, value format.");
        }
        if (defaultargs.length % 2 != 0) {
            throw new NoSuchElementException("Default arguments are not in key, value format.");
        }

        // Set any default arguments in keyword map
        Map<String, String> kwmap = new HashMap<>();
        for (int i = 0; i < defaultargs.length; i = i + 2) {
            if (!(defaultargs[i+1] instanceof String)) {
                throw new IllegalArgumentException("Default argument with value '" + defaultargs[i+1] + "' of type " + defaultargs[i+1].getClass().getSimpleName() + " not allowed in kwargs of type String.");
            }
            if (!(defaultargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key in default arguments must be of type String, not '" + defaultargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) defaultargs[i], (String) defaultargs[i + 1]);
        }

        // Set keyword arguments in keyword map. Will overwrite any default arguments that were just set.
        for (int i = 0; i < kwargs.length; i = i + 2) {
            if (!(kwargs[i+1] instanceof String)) {
                throw new IllegalArgumentException("Value '" + kwargs[i+1] + "' of type " + kwargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type String.");
            }
            if (!(kwargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key must be of type String, not '" + kwargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) kwargs[i], (String) kwargs[i + 1]);
        }
        return kwmap;
    } // end kwString()

    /**
     * Wraps Object vararg into Map, emulating Python's '**kwargs' magic variable. Static.
     *
     * @param kwargs Object vararg, where args alternate between String (keyword) and Double (value).
     * @param defaultargs Optional default values of kwargs in aforementioned kwargs format.
     * @return Map of String to Double, such that each even index vararg 'i' corresponds to vararg 'i+1'.
     * @throws NoSuchElementException If arguments are not in key, value format
     * @throws IllegalArgumentException If value in key-value pair is not Double
     * @throws IllegalArgumentException If key in key-value pair is not String
     */
    public static Map<String, Double> kwDouble(Object[] kwargs, Object... defaultargs) {
        // Make sure the kwargs and defaultargs alternate between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("KWargs are not in key, value format.");
        }
        if (defaultargs.length % 2 != 0) {
            throw new NoSuchElementException("Default arguments are not in key, value format.");
        }

        // Set any default arguments in keyword map
        Map<String, Double> kwmap = new HashMap<>();
        for (int i = 0; i < defaultargs.length; i = i + 2) {
            if (!(defaultargs[i+1] instanceof Double)) {
                throw new IllegalArgumentException("Default argument with value '" + defaultargs[i+1] + "' of type " + defaultargs[i+1].getClass().getSimpleName() + " not allowed in kwargs of type Double");
            }
            if (!(defaultargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key in default arguments must be of type String, not '" + defaultargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) defaultargs[i], (Double) defaultargs[i + 1]);
        }

        // Set keyword arguments in keyword map. Will overwrite any default arguments that were just set.
        for (int i = 0; i < kwargs.length; i = i + 2) {
            if (!(kwargs[i+1] instanceof Double)) {
                throw new IllegalArgumentException("Value '" + kwargs[i+1] + "' of type " + kwargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Double");
            }
            if (!(kwargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key must be of type String, not '" + kwargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) kwargs[i], (Double) kwargs[i + 1]);
        }
        return kwmap;
    } // end kwDouble()

    /**
     * Wraps Object vararg into Map, emulating Python's '**kwargs' magic variable. Static.
     *
     * @param kwargs Object vararg, where args alternate between String (keyword) and Integer (value).
     * @param defaultargs Optional default values of kwargs in aforementioned kwargs format.
     * @return Map of String to Integer, such that each even index vararg 'i' corresponds to vararg 'i+1'.
     * @throws NoSuchElementException If arguments are not in key, value format
     * @throws IllegalArgumentException If value in key-value pair is not Integer
     * @throws IllegalArgumentException If key in key-value pair is not String
     */
    public static Map<String, Integer> kwInteger(Object[] kwargs, Object... defaultargs) {
        // Make sure the kwargs and defaultargs alternate between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("KWargs are not in key, value format.");
        }
        if (defaultargs.length % 2 != 0) {
            throw new NoSuchElementException("Default arguments are not in key, value format.");
        }

        // Set any default arguments in keyword map
        Map<String, Integer> kwmap = new HashMap<>();
        for (int i = 0; i < defaultargs.length; i = i + 2) {
            if (!(defaultargs[i+1] instanceof Integer)) {
                throw new IllegalArgumentException("Default argument with value '" + defaultargs[i+1] + "' of type " + defaultargs[i+1].getClass().getSimpleName() + " not allowed in kwargs of type Integer");
            }
            if (!(defaultargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key in default arguments must be of type String, not '" + defaultargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) defaultargs[i], (Integer) defaultargs[i + 1]);
        }

        // Set keyword arguments in keyword map. Will overwrite any default arguments that were just set.
        for (int i = 0; i < kwargs.length; i = i + 2) {
            if (!(kwargs[i+1] instanceof Integer)) {
                throw new IllegalArgumentException("Value '" + kwargs[i+1] + "' of type " + kwargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Integer");
            }
            if (!(kwargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key must be of type String, not '" + kwargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) kwargs[i], (Integer) kwargs[i + 1]);
        }
        return kwmap;
    } // end kwInteger()

    /**
     * Wraps Object vararg into Map, emulating Python's '**kwargs' magic variable. Static.
     *
     * @param kwargs Object vararg, where args alternate between String (keyword) and Boolean (value).
     * @param defaultargs Optional default values of kwargs in aforementioned kwargs format.
     * @return Map of String to Boolean, such that each even index vararg 'i' corresponds to vararg 'i+1'.
     * @throws NoSuchElementException If arguments are not in key, value format
     * @throws IllegalArgumentException If value in key-value pair is not Boolean
     * @throws IllegalArgumentException If key in key-value pair is not String
     */
    public static Map<String, Boolean> kwBoolean(Object[] kwargs, Object... defaultargs) {
        // Make sure the kwargs and defaultargs alternate between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("KWargs are not in key, value format.");
        }
        if (defaultargs.length % 2 != 0) {
            throw new NoSuchElementException("Default arguments are not in key, value format.");
        }

        // Set any default arguments in keyword map
        Map<String, Boolean> kwmap = new HashMap<>();
        for (int i = 0; i < defaultargs.length; i = i + 2) {
            if (!(defaultargs[i+1] instanceof Boolean)) {
                throw new IllegalArgumentException("Default argument with value '" + defaultargs[i+1] + "' of type " + defaultargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Boolean");
            }
            if (!(defaultargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key in default arguments must be of type String, not '" + defaultargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) defaultargs[i], (Boolean) defaultargs[i + 1]);
        }

        // Set keyword arguments in keyword map. Will overwrite any default arguments that were just set.
        for (int i = 0; i < kwargs.length; i = i + 2) {
            if (!(kwargs[i+1] instanceof Boolean)) {
                throw new IllegalArgumentException("Value '" + kwargs[i+1] + "' of type " + kwargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Boolean");
            }
            if (!(kwargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key must be of type String, not '" + kwargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) kwargs[i], (Boolean) kwargs[i + 1]);
        }
        return kwmap;
    } // end kwBool()

    /**
     * Wraps Object vararg into Map, emulating Python's '**kwargs' magic variable. Static.
     *
     * @param kwargs Object vararg, where args alternate between String (keyword) and Character (value).
     * @param defaultargs Optional default values of kwargs in aforementioned kwargs format.
     * @return Map of String to Character, such that each even index vararg 'i' corresponds to vararg 'i+1'.
     * @throws NoSuchElementException If arguments are not in key, value format
     * @throws IllegalArgumentException If value in key-value pair is not Character
     * @throws IllegalArgumentException If key in key-value pair is not String
     */
    public static Map<String, Character> kwCharacter(Object[] kwargs, Object... defaultargs) {
        // Make sure the kwargs and defaultargs alternate between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("KWargs are not in key, value format.");
        }
        if (defaultargs.length % 2 != 0) {
            throw new NoSuchElementException("Default arguments are not in key, value format.");
        }

        // Set any default arguments in keyword map
        Map<String, Character> kwmap = new HashMap<>();
        for (int i = 0; i < defaultargs.length; i = i + 2) {
            if (!(defaultargs[i+1] instanceof Character)) {
                throw new IllegalArgumentException("Default argument with value '" + defaultargs[i+1] + "' of type " + defaultargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Character");
            }
            if (!(defaultargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key in default arguments must be of type String, not '" + defaultargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) defaultargs[i], (Character) defaultargs[i + 1]);
        }

        // Set keyword arguments in keyword map. Will overwrite any default arguments that were just set.
        for (int i = 0; i < kwargs.length; i = i + 2) {
            if (!(kwargs[i+1] instanceof Character)) {
                throw new IllegalArgumentException("Value '" + kwargs[i+1] + "' of type " + kwargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Character");
            }
            if (!(kwargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key must be of type String, not '" + kwargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) kwargs[i], (Character) kwargs[i + 1]);
        }
        return kwmap;
    } // end kwCharacter()

    /**
     * Wraps Object vararg into Map, emulating Python's '**kwargs' magic variable. Static.
     *
     * @param kwargs Object vararg, where args alternate between String (keyword) and Byte (value).
     * @param defaultargs Optional default values of kwargs in aforementioned kwargs format.
     * @return Map of String to Byte, such that each even index vararg 'i' corresponds to vararg 'i+1'.
     * @throws NoSuchElementException If arguments are not in key, value format
     * @throws IllegalArgumentException If value in key-value pair is not Byte
     * @throws IllegalArgumentException If key in key-value pair is not String
     */
    public static Map<String, Byte> kwByte(Object[] kwargs, Object... defaultargs) {
        // Make sure the kwargs and defaultargs alternate between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("KWargs are not in key, value format.");
        }
        if (defaultargs.length % 2 != 0) {
            throw new NoSuchElementException("Default arguments are not in key, value format.");
        }

        // Set any default arguments in keyword map
        Map<String, Byte> kwmap = new HashMap<>();
        for (int i = 0; i < defaultargs.length; i = i + 2) {
            if (!(defaultargs[i+1] instanceof Byte)) {
                throw new IllegalArgumentException("Default argument with value '" + defaultargs[i+1] + "' of type " + defaultargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Byte");
            }
            if (!(defaultargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key in default arguments must be of type String, not '" + defaultargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) defaultargs[i], (Byte) defaultargs[i + 1]);
        }

        // Set keyword arguments in keyword map. Will overwrite any default arguments that were just set.
        for (int i = 0; i < kwargs.length; i = i + 2) {
            if (!(kwargs[i+1] instanceof Byte)) {
                throw new IllegalArgumentException("Value '" + kwargs[i+1] + "' of type " + kwargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Byte");
            }
            if (!(kwargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key must be of type String, not '" + kwargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) kwargs[i], (Byte) kwargs[i + 1]);
        }
        return kwmap;
    } // end kwByte()

    /**
     * Wraps Object vararg into Map, emulating Python's '**kwargs' magic variable. Static.
     *
     * @param kwargs Object vararg, where args alternate between String (keyword) and Short (value).
     * @param defaultargs Optional default values of kwargs in aforementioned kwargs format.
     * @return Map of String to Short, such that each even index vararg 'i' corresponds to vararg 'i+1'.
     * @throws NoSuchElementException If arguments are not in key, value format
     * @throws IllegalArgumentException If value in key-value pair is not Short
     * @throws IllegalArgumentException If key in key-value pair is not String
     */
    public static Map<String, Short> kwShort(Object[] kwargs, Object... defaultargs) {
        // Make sure the kwargs and defaultargs alternate between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("KWargs are not in key, value format.");
        }
        if (defaultargs.length % 2 != 0) {
            throw new NoSuchElementException("Default arguments are not in key, value format.");
        }

        // Set any default arguments in keyword map
        Map<String, Short> kwmap = new HashMap<>();
        for (int i = 0; i < defaultargs.length; i = i + 2) {
            if (!(defaultargs[i+1] instanceof Short)) {
                throw new IllegalArgumentException("Default argument with value '" + defaultargs[i+1] + "' of type " + defaultargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Short");
            }
            if (!(defaultargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key in default arguments must be of type String, not '" + defaultargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) defaultargs[i], (Short) defaultargs[i + 1]);
        }

        // Set keyword arguments in keyword map. Will overwrite any default arguments that were just set.
        for (int i = 0; i < kwargs.length; i = i + 2) {
            if (!(kwargs[i+1] instanceof Short)) {
                throw new IllegalArgumentException("Value '" + kwargs[i+1] + "' of type " + kwargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Short");
            }
            if (!(kwargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key must be of type String, not '" + kwargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) kwargs[i], (Short) kwargs[i + 1]);
        }
        return kwmap;
    } // end kwShort()

    /**
     * Wraps Object vararg into Map, emulating Python's '**kwargs' magic variable. Static.
     *
     * @param kwargs Object vararg, where args alternate between String (keyword) and Long (value).
     * @param defaultargs Optional default values of kwargs in aforementioned kwargs format.
     * @return Map of String to Long, such that each even index vararg 'i' corresponds to vararg 'i+1'.
     * @throws NoSuchElementException If arguments are not in key, value format
     * @throws IllegalArgumentException If value in key-value pair is not Long
     * @throws IllegalArgumentException If key in key-value pair is not String
     */
    public static Map<String, Long> kwLong(Object[] kwargs, Object... defaultargs) {
        // Make sure the kwargs and defaultargs alternate between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("KWargs are not in key, value format.");
        }
        if (defaultargs.length % 2 != 0) {
            throw new NoSuchElementException("Default arguments are not in key, value format.");
        }

        // Set any default arguments in keyword map
        Map<String, Long> kwmap = new HashMap<>();
        for (int i = 0; i < defaultargs.length; i = i + 2) {
            if (!(defaultargs[i+1] instanceof Long)) {
                throw new IllegalArgumentException("Default argument with value '" + defaultargs[i+1] + "' of type " + defaultargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Long");
            }
            if (!(defaultargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key in default arguments must be of type String, not '" + defaultargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) defaultargs[i], (Long) defaultargs[i + 1]);
        }

        // Set keyword arguments in keyword map. Will overwrite any default arguments that were just set.
        for (int i = 0; i < kwargs.length; i = i + 2) {
            if (!(kwargs[i+1] instanceof Long)) {
                throw new IllegalArgumentException("Value '" + kwargs[i+1] + "' of type " + kwargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Long");
            }
            if (!(kwargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key must be of type String, not '" + kwargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) kwargs[i], (Long) kwargs[i + 1]);
        }
        return kwmap;
    } // end kwLong()

    /**
     * Wraps Object vararg into Map, emulating Python's '**kwargs' magic variable. Static.
     *
     * @param kwargs Object vararg, where args alternate between String (keyword) and Float (value).
     * @param defaultargs Optional default values of kwargs in aforementioned kwargs format.
     * @return Map of String to Float, such that each even index vararg 'i' corresponds to vararg 'i+1'.
     * @throws NoSuchElementException If arguments are not in key, value format
     * @throws IllegalArgumentException If value in key-value pair is not Float
     * @throws IllegalArgumentException If key in key-value pair is not String
     */
    public static Map<String, Float> kwFloat(Object[] kwargs, Object... defaultargs) {
        // Make sure the kwargs and defaultargs alternate between key,value,key,value,etc.
        if (kwargs.length % 2 != 0) {
            throw new NoSuchElementException("KWargs are not in key, value format.");
        }
        if (defaultargs.length % 2 != 0) {
            throw new NoSuchElementException("Default arguments are not in key, value format.");
        }

        // Set any default arguments in keyword map
        Map<String, Float> kwmap = new HashMap<>();
        for (int i = 0; i < defaultargs.length; i = i + 2) {
            if (!(defaultargs[i+1] instanceof Float)) {
                throw new IllegalArgumentException("Default argument with value '" + defaultargs[i+1] + "' of type " + defaultargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Float");
            }
            if (!(defaultargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key in default arguments must be of type String, not '" + defaultargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) defaultargs[i], (Float) defaultargs[i + 1]);
        }

        // Set keyword arguments in keyword map. Will overwrite any default arguments that were just set.
        for (int i = 0; i < kwargs.length; i = i + 2) {
            if (!(kwargs[i+1] instanceof Float)) {
                throw new IllegalArgumentException("Value '" + kwargs[i+1] + "' of type " + kwargs[i+1].getClass().getSimpleName()+ " not allowed in kwargs of type Float");
            }
            if (!(kwargs[i] instanceof String)) {
                throw new IllegalArgumentException("Key must be of type String, not '" + kwargs[i].getClass().getSimpleName() + "'.");
            }
            kwmap.put((String) kwargs[i], (Float) kwargs[i + 1]);
        }
        return kwmap;
    } // end kwFloat()
} // end class KWArgs
