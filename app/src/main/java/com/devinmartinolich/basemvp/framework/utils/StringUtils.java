package com.devinmartinolich.basemvp.framework.utils;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

/**
 * Name : StringUtils
 * Created by devin on 1/24/18.
 * Modified by
 * Purpose : Contains utility methods to perform common manipulation of strings
 */
public class StringUtils
{
    public static final String EMPTY = "";

    /**
     * Name : isTrimmedEmpty
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : To check that given string is null or empty after trimming
     *
     * @param aString String to check
     * @return true if String is empty even if it is padded with white space
     */
    public static boolean isTrimmedEmpty(String aString)
    {
        return aString == null || aString.trim().length() == 0;
    }

    /**
     * Name : isValidEmail
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : To check if its a valid email id or not.
     *
     * @param email email address to validate
     * @return true if valid email else false
     */
    public static boolean isValidEmail(String email)
    {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * Name : validatePattern
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : This method is used to validate pattern
     *
     * @param asPattern : string pattern which we need to map.
     * @param asTarget  : string to compare with map pattern.
     * @return : return true if pattern matches otherwise it will return false.
     */
    public final static boolean validatePattern(String asPattern, String asTarget)
    {
        Pattern pattern = Pattern.compile(asPattern);
        return pattern.matcher(asTarget).matches();
    }

    /**
     * Name : isEquals
     * Created by devin on 1/24/18.
     * Modified by
     * Purpose : This method will compare two strings contents equality with case.
     *
     * @param s  : string 1 which we need to check.
     * @param s1 :  string 2 which we need to check.
     * @return : true if same else false.
     */
    public static boolean isEquals(String s, String s1)
    {
        return s.equals(s1);
    }
}