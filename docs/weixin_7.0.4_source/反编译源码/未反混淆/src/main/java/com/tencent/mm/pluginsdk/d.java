package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.HashMap;

public final class d {
    private static HashMap<String, Integer> vam = null;

    public static int dgO() {
        return R.raw.app_attach_file_icon_unknow;
    }

    public static int ail(String str) {
        AppMethodBeat.i(114655);
        if (vam == null) {
            HashMap hashMap = new HashMap();
            vam = hashMap;
            hashMap.put("avi", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("m4v", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("vob", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("mpeg", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("mpe", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("asx", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("asf", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("f4v", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("flv", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("mkv", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("wmv", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("wm", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("3gp", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("mp4", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("rmvb", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("rm", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("ra", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("ram", Integer.valueOf(R.raw.app_attach_file_icon_video));
            vam.put("mp3pro", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("vqf", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("cd", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("md", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("mod", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("vorbis", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("au", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("amr", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("silk", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("wma", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("mmf", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("mid", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("midi", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("mp3", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("aac", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("ape", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("aiff", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("aif", Integer.valueOf(R.raw.app_attach_file_icon_music));
            vam.put("jfif", Integer.valueOf(R.drawable.avp));
            vam.put("tiff", Integer.valueOf(R.drawable.avp));
            vam.put("tif", Integer.valueOf(R.drawable.avp));
            vam.put("jpe", Integer.valueOf(R.drawable.avp));
            vam.put("dib", Integer.valueOf(R.drawable.avp));
            vam.put("jpeg", Integer.valueOf(R.drawable.avp));
            vam.put("jpg", Integer.valueOf(R.drawable.avp));
            vam.put("png", Integer.valueOf(R.drawable.avp));
            vam.put("bmp", Integer.valueOf(R.drawable.avp));
            vam.put("gif", Integer.valueOf(R.drawable.avp));
            vam.put("rar", Integer.valueOf(R.raw.app_attach_file_icon_rar));
            vam.put("zip", Integer.valueOf(R.raw.app_attach_file_icon_rar));
            vam.put("7z", Integer.valueOf(R.raw.app_attach_file_icon_rar));
            vam.put("iso", Integer.valueOf(R.raw.app_attach_file_icon_rar));
            vam.put("cab", Integer.valueOf(R.raw.app_attach_file_icon_rar));
            vam.put("doc", Integer.valueOf(R.raw.app_attach_file_icon_word));
            vam.put("docx", Integer.valueOf(R.raw.app_attach_file_icon_word));
            vam.put("ppt", Integer.valueOf(R.raw.app_attach_file_icon_ppt));
            vam.put("pptx", Integer.valueOf(R.raw.app_attach_file_icon_ppt));
            vam.put("xls", Integer.valueOf(R.raw.app_attach_file_icon_excel));
            vam.put("xlsx", Integer.valueOf(R.raw.app_attach_file_icon_excel));
            vam.put("txt", Integer.valueOf(R.raw.app_attach_file_icon_txt));
            vam.put("rtf", Integer.valueOf(R.raw.app_attach_file_icon_txt));
            vam.put("pdf", Integer.valueOf(R.raw.app_attach_file_icon_pdf));
        }
        Integer num = (Integer) vam.get(str);
        if (num == null) {
            AppMethodBeat.o(114655);
            return R.raw.app_attach_file_icon_unknow;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(114655);
        return intValue;
    }
}
