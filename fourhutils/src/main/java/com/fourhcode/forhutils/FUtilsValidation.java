package com.fourhcode.forhutils;

import android.content.Context;
import android.util.Log;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Muhammad on 19/09/2016.
 */
public class FUtilsValidation {

    public static boolean isEmail(String value) {
        return Patterns.EMAIL_ADDRESS.matcher(value).matches();

    }


    public static boolean isPhone(String value) {
        return Patterns.PHONE.matcher(value).matches();
    }

    public static boolean isNumber(String value) {
        return value.matches("[0-9]+");
    }

    public static boolean isIntegerValueZero(int value) {
        return value == 0;
    }

    public static boolean isStringValueZero(String value) {
        return value.equals("0");
    }

    public static boolean isArabic(String value) {
        for (int i = 0; i < value.length(); ) {
            int c = value.codePointAt(i);
            if (c >= 0x0600 && c <= 0x06E0)
                return true;
            i += Character.charCount(c);
        }
        return false;
    }

    public static boolean isDateValid(String dateToValidate, String dateFormat) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        simpleDateFormat.setLenient(false);

        try {
            Date date = simpleDateFormat.parse(dateToValidate);
            Log.d("Valid Date", date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }


    public static boolean isEmpty(String text) {
        return text.trim().isEmpty();
    }

    public static boolean isEmpty(EditText editText) {
        return editText.getText().toString().trim().isEmpty();
    }


    public static boolean isLengthCorrect(String text, int min, int max) {
        return text.length() >= min && text.length() <= max;
    }

    public static boolean isEmpty(EditText editText, String error) {
        if (editText.getText().toString().trim().isEmpty()) {
            editText.setError(error);
            return true;
        } else {
            return false;
        }
    }



    public static boolean isValidEmail(EditText emailEditText, String error) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailEditText.getText().toString()).matches()) {
            return true;
        } else {
            emailEditText.setError(error);
            return false;
        }

    }

    public static boolean isValidEmail(EditText emailEditText, String errorIfEmpry, String errorIfNotValid) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailEditText.getText().toString()).matches()) {
            return true;
        } else if (emailEditText.getText().toString().trim().isEmpty()) {
            emailEditText.setError(errorIfEmpry);
            return false;
        } else {
            emailEditText.setError(errorIfNotValid);
            return false;
        }

    }


    public static boolean isPasswordEqual(EditText passwordEditText, EditText repeatedPasswordEditText, String error) {
        String passowrd1 = passwordEditText.getText().toString();
        String password2 = repeatedPasswordEditText.getText().toString();
        if (passowrd1.equals(password2)) {
            return true;
        } else {
            passwordEditText.setError(error);
            repeatedPasswordEditText.setError(error);
            return false;
        }

    }


    public static boolean isSpinnerFirstItemSelected(Spinner spinner, String error, Context context) {
        if (spinner.getSelectedItemPosition() == 0) {
            Toast.makeText(context, error, Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return false;
        }

    }

    public static void reset(EditText editText) {
        editText.setError(null);
    }

    public static String value(EditText editText) {
        return editText.getText().toString();
    }


}
