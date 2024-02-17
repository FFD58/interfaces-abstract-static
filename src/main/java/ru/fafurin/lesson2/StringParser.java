package ru.fafurin.lesson2;

public class StringParser {

    public String trimStringByTwoTags(String source, String startTag, String endTag) {
        int charNumber = endTag.equals("}") ? 2 : 4;
        int start = source.indexOf(startTag) + startTag.length() + 3;
        int end = source.indexOf(endTag) - charNumber;
        String result = source.substring(start, end);
        if (result.contains("\",")) return trimStringAfterDoubleQuotationMark(result);
        return result;
    }

    public String trimStringByTag(String str, String tag) {
        int start = str.indexOf(tag) + tag.length() + 3;
        int end = str.indexOf("\",", start);
        str = str.substring(start, end);
        if (str.contains("\",")) return trimStringAfterDoubleQuotationMark(str);
        else return str;
    }

    public String trimStringAfterDoubleQuotationMark(String str) {
        return str.replace(str.substring(str.indexOf("\"")), "");
    }

    public String parseDate(String str) {
        //  "2012-09-14T07:00:00Z"
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.delete(str.indexOf("T"), stringBuilder.length());
        //  "2012-09-14"
        stringBuilder.insert(stringBuilder.length(), stringBuilder.substring(0, 4));
        //  "2012-09-142012"
        stringBuilder.delete(0, 4);
        //  "-09-142012"
        stringBuilder.insert(0, stringBuilder.substring(4, 6));
        // "14-09-142012"
        stringBuilder.delete(6, 8);
        // "14-09-2012"
        return stringBuilder.toString().replace("-", ".");
    }

}
