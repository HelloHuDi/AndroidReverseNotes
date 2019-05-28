package com.tencent.p177mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import java.util.HashMap;

/* renamed from: com.tencent.mm.pluginsdk.d */
public final class C30034d {
    private static HashMap<String, Integer> vam = null;

    public static int dgO() {
        return C1318a.app_attach_file_icon_unknow;
    }

    public static int ail(String str) {
        AppMethodBeat.m2504i(114655);
        if (vam == null) {
            HashMap hashMap = new HashMap();
            vam = hashMap;
            hashMap.put("avi", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("m4v", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("vob", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("mpeg", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("mpe", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("asx", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("asf", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("f4v", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("flv", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("mkv", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("wmv", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("wm", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("3gp", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("mp4", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("rmvb", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("rm", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("ra", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("ram", Integer.valueOf(C1318a.app_attach_file_icon_video));
            vam.put("mp3pro", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("vqf", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("cd", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("md", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("mod", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("vorbis", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("au", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("amr", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("silk", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("wma", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("mmf", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("mid", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("midi", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("mp3", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("aac", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("ape", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("aiff", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("aif", Integer.valueOf(C1318a.app_attach_file_icon_music));
            vam.put("jfif", Integer.valueOf(C25738R.drawable.avp));
            vam.put("tiff", Integer.valueOf(C25738R.drawable.avp));
            vam.put("tif", Integer.valueOf(C25738R.drawable.avp));
            vam.put("jpe", Integer.valueOf(C25738R.drawable.avp));
            vam.put("dib", Integer.valueOf(C25738R.drawable.avp));
            vam.put("jpeg", Integer.valueOf(C25738R.drawable.avp));
            vam.put("jpg", Integer.valueOf(C25738R.drawable.avp));
            vam.put("png", Integer.valueOf(C25738R.drawable.avp));
            vam.put("bmp", Integer.valueOf(C25738R.drawable.avp));
            vam.put("gif", Integer.valueOf(C25738R.drawable.avp));
            vam.put("rar", Integer.valueOf(C1318a.app_attach_file_icon_rar));
            vam.put("zip", Integer.valueOf(C1318a.app_attach_file_icon_rar));
            vam.put("7z", Integer.valueOf(C1318a.app_attach_file_icon_rar));
            vam.put("iso", Integer.valueOf(C1318a.app_attach_file_icon_rar));
            vam.put("cab", Integer.valueOf(C1318a.app_attach_file_icon_rar));
            vam.put("doc", Integer.valueOf(C1318a.app_attach_file_icon_word));
            vam.put("docx", Integer.valueOf(C1318a.app_attach_file_icon_word));
            vam.put("ppt", Integer.valueOf(C1318a.app_attach_file_icon_ppt));
            vam.put("pptx", Integer.valueOf(C1318a.app_attach_file_icon_ppt));
            vam.put("xls", Integer.valueOf(C1318a.app_attach_file_icon_excel));
            vam.put("xlsx", Integer.valueOf(C1318a.app_attach_file_icon_excel));
            vam.put("txt", Integer.valueOf(C1318a.app_attach_file_icon_txt));
            vam.put("rtf", Integer.valueOf(C1318a.app_attach_file_icon_txt));
            vam.put("pdf", Integer.valueOf(C1318a.app_attach_file_icon_pdf));
        }
        Integer num = (Integer) vam.get(str);
        if (num == null) {
            AppMethodBeat.m2505o(114655);
            return C1318a.app_attach_file_icon_unknow;
        }
        int intValue = num.intValue();
        AppMethodBeat.m2505o(114655);
        return intValue;
    }
}
