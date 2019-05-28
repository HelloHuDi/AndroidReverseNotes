package com.p123qq.p803wx.voice.embed.recognizer;

import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.xwalk.core.XWalkUpdater;

/* renamed from: com.qq.wx.voice.embed.recognizer.Grammar */
public class Grammar {
    public static String mData = null;
    public static String mDataPath = null;
    public static String mSo = null;
    /* renamed from: a */
    private C41656f f14676a;
    /* renamed from: b */
    private C25590a f14677b;
    /* renamed from: c */
    private boolean f14678c;
    /* renamed from: d */
    private boolean f14679d;
    /* renamed from: e */
    private ArrayList f14680e;

    public Grammar() {
        AppMethodBeat.m2504i(123213);
        this.f14676a = null;
        this.f14677b = new C25590a();
        this.f14678c = false;
        this.f14679d = false;
        this.f14680e = null;
        this.f14676a = new C41656f();
        AppMethodBeat.m2505o(123213);
    }

    /* renamed from: a */
    private String m52242a() {
        String str;
        int i = 0;
        AppMethodBeat.m2504i(123217);
        for (int i2 = 0; i2 < this.f14680e.size(); i2++) {
            ((C17717d) this.f14680e.get(i2)).bCw = Grammar.m52243a(((C17717d) this.f14680e.get(i2)).userName);
            ((C17717d) this.f14680e.get(i2)).bCx = Grammar.m52243a(((C17717d) this.f14680e.get(i2)).bCu);
            ((C17717d) this.f14680e.get(i2)).bCy = Grammar.m52243a(((C17717d) this.f14680e.get(i2)).bCv);
        }
        StringBuffer stringBuffer = new StringBuffer("");
        while (i < this.f14680e.size()) {
            str = ((C17717d) this.f14680e.get(i)).bCw;
            if (!str.isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                stringBuffer.append(str);
            }
            str = ((C17717d) this.f14680e.get(i)).bCx;
            if (!str.isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                stringBuffer.append(str);
            }
            str = ((C17717d) this.f14680e.get(i)).bCy;
            if (!str.isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                stringBuffer.append(str);
            }
            i++;
        }
        str = stringBuffer.toString();
        AppMethodBeat.m2505o(123217);
        return str;
    }

    /* renamed from: a */
    private static String m52243a(String str) {
        AppMethodBeat.m2504i(123218);
        String replaceAll = new String(str).replaceAll("[^(a-zA-Z0-9\\u4e00-\\u9fa5)]", "").replaceAll(AppEventsConstants.EVENT_PARAM_VALUE_NO, "零").replaceAll("1", "一").replaceAll("2", "二").replaceAll(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "三").replaceAll("4", "四").replaceAll("5", "五").replaceAll("6", "六").replaceAll("7", "七").replaceAll("8", "八").replaceAll("9", "九");
        AppMethodBeat.m2505o(123218);
        return replaceAll;
    }

    public int begin() {
        AppMethodBeat.m2504i(123219);
        int begin = GrammarNative.begin();
        AppMethodBeat.m2505o(123219);
        return begin;
    }

    public int end() {
        AppMethodBeat.m2504i(123221);
        int end = GrammarNative.end();
        AppMethodBeat.m2505o(123221);
        return end;
    }

    public int getResult(C25590a c25590a) {
        AppMethodBeat.m2504i(123222);
        int result = GrammarNative.getResult(this);
        if (result < 0) {
            AppMethodBeat.m2505o(123222);
            return result;
        }
        c25590a.text = this.f14677b.text;
        if (this.f14677b.name == null) {
            c25590a.name = null;
            AppMethodBeat.m2505o(123222);
            return 0;
        }
        int i = 0;
        while (i < this.f14680e.size()) {
            if (((C17717d) this.f14680e.get(i)).bCw.compareTo(this.f14677b.name) == 0) {
                c25590a.name = ((C17717d) this.f14680e.get(i)).userName;
                break;
            } else if (((C17717d) this.f14680e.get(i)).bCx.compareTo(this.f14677b.name) == 0) {
                c25590a.name = ((C17717d) this.f14680e.get(i)).userName;
                break;
            } else if (((C17717d) this.f14680e.get(i)).bCy.compareTo(this.f14677b.name) == 0) {
                c25590a.name = ((C17717d) this.f14680e.get(i)).userName;
                break;
            } else {
                i++;
            }
        }
        AppMethodBeat.m2505o(123222);
        return 0;
    }

    public int init(ArrayList arrayList) {
        AppMethodBeat.m2504i(123215);
        if (this.f14679d) {
            AppMethodBeat.m2505o(123215);
            return 0;
        } else if (arrayList == null) {
            AppMethodBeat.m2505o(123215);
            return -303;
        } else {
            try {
                System.load(mDataPath + "/" + mSo);
                this.f14680e = arrayList;
                String a = m52242a();
                try {
                    if (GrammarNative.init(mDataPath.getBytes(), mData.getBytes(), a.toString().getBytes("GBK")) < 0) {
                        new StringBuilder(String.valueOf(mDataPath)).append(" ").append(mData).append(" ").append(a);
                        AppMethodBeat.m2505o(123215);
                        return XWalkUpdater.ERROR_SET_VERNUM;
                    }
                    this.f14679d = true;
                    AppMethodBeat.m2505o(123215);
                    return 0;
                } catch (UnsupportedEncodingException e) {
                    new StringBuilder(String.valueOf(mDataPath)).append(" ").append(mData).append(" ").append(a);
                    AppMethodBeat.m2505o(123215);
                    return XWalkUpdater.ERROR_SET_VERNUM;
                }
            } catch (Exception e2) {
                AppMethodBeat.m2505o(123215);
                return -205;
            }
        }
    }

    public void onGetResult(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        AppMethodBeat.m2504i(123223);
        if (bArr != null) {
            try {
                this.f14677b.text = new String(bArr, "GBK");
            } catch (UnsupportedEncodingException e) {
                AppMethodBeat.m2505o(123223);
                return;
            }
        }
        this.f14677b.text = null;
        if (bArr3 != null) {
            this.f14677b.name = new String(bArr3, "GBK");
            AppMethodBeat.m2505o(123223);
            return;
        }
        this.f14677b.name = null;
        AppMethodBeat.m2505o(123223);
    }

    public int recognize(byte[] bArr, int i) {
        AppMethodBeat.m2504i(123220);
        int recognize = GrammarNative.recognize(bArr, i);
        AppMethodBeat.m2505o(123220);
        return recognize;
    }

    public int update(ArrayList arrayList) {
        AppMethodBeat.m2504i(123216);
        if (arrayList == null) {
            AppMethodBeat.m2505o(123216);
            return -303;
        }
        this.f14680e = arrayList;
        try {
            if (GrammarNative.update(m52242a().getBytes("GBK")) < 0) {
                AppMethodBeat.m2505o(123216);
                return ZipJNI.UNZ_ERR_OPEN_WRITE;
            }
            AppMethodBeat.m2505o(123216);
            return 0;
        } catch (UnsupportedEncodingException e) {
            AppMethodBeat.m2505o(123216);
            return ZipJNI.UNZ_ERR_OPEN_WRITE;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Missing block: B:11:0x002c, code skipped:
            if (r1 < 0) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int checkFiles(Context context, String str, String str2, String str3) {
        AppMethodBeat.m2504i(123214);
        if (this.f14678c) {
            AppMethodBeat.m2505o(123214);
            return 0;
        } else if (context == null || str == null || str2 == null || str3 == null) {
            AppMethodBeat.m2505o(123214);
            return -303;
        } else {
            int e;
            if (VERSION.SDK_INT >= 24) {
                e = this.f14676a.mo67128e("/vendor/lib/", str2, str3);
            } else if (str.compareTo("/system/lib") == 0 || str.compareTo("/system/lib/") == 0) {
                e = this.f14676a.mo67128e(str, str2, str3);
                if (e >= 0) {
                    AppMethodBeat.m2505o(123214);
                    return e;
                }
                mDataPath = this.f14676a.f16882b;
                mData = "libwxvoiceembed.bin";
                mSo = "libwxvoiceembed.so";
                this.f14678c = true;
                AppMethodBeat.m2505o(123214);
                return 0;
            }
            e = this.f14676a.mo67127c(context, str, str2, str3);
            if (e >= 0) {
            }
        }
    }
}
