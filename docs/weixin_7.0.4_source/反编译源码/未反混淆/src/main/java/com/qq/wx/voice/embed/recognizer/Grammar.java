package com.qq.wx.voice.embed.recognizer;

import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.xwalk.core.XWalkUpdater;

public class Grammar {
    public static String mData = null;
    public static String mDataPath = null;
    public static String mSo = null;
    private f a;
    private a b;
    private boolean c;
    private boolean d;
    private ArrayList e;

    public Grammar() {
        AppMethodBeat.i(123213);
        this.a = null;
        this.b = new a();
        this.c = false;
        this.d = false;
        this.e = null;
        this.a = new f();
        AppMethodBeat.o(123213);
    }

    private String a() {
        String str;
        int i = 0;
        AppMethodBeat.i(123217);
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            ((d) this.e.get(i2)).bCw = a(((d) this.e.get(i2)).userName);
            ((d) this.e.get(i2)).bCx = a(((d) this.e.get(i2)).bCu);
            ((d) this.e.get(i2)).bCy = a(((d) this.e.get(i2)).bCv);
        }
        StringBuffer stringBuffer = new StringBuffer("");
        while (i < this.e.size()) {
            str = ((d) this.e.get(i)).bCw;
            if (!str.isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                stringBuffer.append(str);
            }
            str = ((d) this.e.get(i)).bCx;
            if (!str.isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                stringBuffer.append(str);
            }
            str = ((d) this.e.get(i)).bCy;
            if (!str.isEmpty()) {
                if (stringBuffer.length() > 0) {
                    stringBuffer.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                stringBuffer.append(str);
            }
            i++;
        }
        str = stringBuffer.toString();
        AppMethodBeat.o(123217);
        return str;
    }

    private static String a(String str) {
        AppMethodBeat.i(123218);
        String replaceAll = new String(str).replaceAll("[^(a-zA-Z0-9\\u4e00-\\u9fa5)]", "").replaceAll(AppEventsConstants.EVENT_PARAM_VALUE_NO, "零").replaceAll("1", "一").replaceAll("2", "二").replaceAll(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "三").replaceAll("4", "四").replaceAll("5", "五").replaceAll("6", "六").replaceAll("7", "七").replaceAll("8", "八").replaceAll("9", "九");
        AppMethodBeat.o(123218);
        return replaceAll;
    }

    public int begin() {
        AppMethodBeat.i(123219);
        int begin = GrammarNative.begin();
        AppMethodBeat.o(123219);
        return begin;
    }

    public int end() {
        AppMethodBeat.i(123221);
        int end = GrammarNative.end();
        AppMethodBeat.o(123221);
        return end;
    }

    public int getResult(a aVar) {
        AppMethodBeat.i(123222);
        int result = GrammarNative.getResult(this);
        if (result < 0) {
            AppMethodBeat.o(123222);
            return result;
        }
        aVar.text = this.b.text;
        if (this.b.name == null) {
            aVar.name = null;
            AppMethodBeat.o(123222);
            return 0;
        }
        int i = 0;
        while (i < this.e.size()) {
            if (((d) this.e.get(i)).bCw.compareTo(this.b.name) == 0) {
                aVar.name = ((d) this.e.get(i)).userName;
                break;
            } else if (((d) this.e.get(i)).bCx.compareTo(this.b.name) == 0) {
                aVar.name = ((d) this.e.get(i)).userName;
                break;
            } else if (((d) this.e.get(i)).bCy.compareTo(this.b.name) == 0) {
                aVar.name = ((d) this.e.get(i)).userName;
                break;
            } else {
                i++;
            }
        }
        AppMethodBeat.o(123222);
        return 0;
    }

    public int init(ArrayList arrayList) {
        AppMethodBeat.i(123215);
        if (this.d) {
            AppMethodBeat.o(123215);
            return 0;
        } else if (arrayList == null) {
            AppMethodBeat.o(123215);
            return -303;
        } else {
            try {
                System.load(mDataPath + "/" + mSo);
                this.e = arrayList;
                String a = a();
                try {
                    if (GrammarNative.init(mDataPath.getBytes(), mData.getBytes(), a.toString().getBytes("GBK")) < 0) {
                        new StringBuilder(String.valueOf(mDataPath)).append(" ").append(mData).append(" ").append(a);
                        AppMethodBeat.o(123215);
                        return XWalkUpdater.ERROR_SET_VERNUM;
                    }
                    this.d = true;
                    AppMethodBeat.o(123215);
                    return 0;
                } catch (UnsupportedEncodingException e) {
                    new StringBuilder(String.valueOf(mDataPath)).append(" ").append(mData).append(" ").append(a);
                    AppMethodBeat.o(123215);
                    return XWalkUpdater.ERROR_SET_VERNUM;
                }
            } catch (Exception e2) {
                AppMethodBeat.o(123215);
                return -205;
            }
        }
    }

    public void onGetResult(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        AppMethodBeat.i(123223);
        if (bArr != null) {
            try {
                this.b.text = new String(bArr, "GBK");
            } catch (UnsupportedEncodingException e) {
                AppMethodBeat.o(123223);
                return;
            }
        }
        this.b.text = null;
        if (bArr3 != null) {
            this.b.name = new String(bArr3, "GBK");
            AppMethodBeat.o(123223);
            return;
        }
        this.b.name = null;
        AppMethodBeat.o(123223);
    }

    public int recognize(byte[] bArr, int i) {
        AppMethodBeat.i(123220);
        int recognize = GrammarNative.recognize(bArr, i);
        AppMethodBeat.o(123220);
        return recognize;
    }

    public int update(ArrayList arrayList) {
        AppMethodBeat.i(123216);
        if (arrayList == null) {
            AppMethodBeat.o(123216);
            return -303;
        }
        this.e = arrayList;
        try {
            if (GrammarNative.update(a().getBytes("GBK")) < 0) {
                AppMethodBeat.o(123216);
                return ZipJNI.UNZ_ERR_OPEN_WRITE;
            }
            AppMethodBeat.o(123216);
            return 0;
        } catch (UnsupportedEncodingException e) {
            AppMethodBeat.o(123216);
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
        AppMethodBeat.i(123214);
        if (this.c) {
            AppMethodBeat.o(123214);
            return 0;
        } else if (context == null || str == null || str2 == null || str3 == null) {
            AppMethodBeat.o(123214);
            return -303;
        } else {
            int e;
            if (VERSION.SDK_INT >= 24) {
                e = this.a.e("/vendor/lib/", str2, str3);
            } else if (str.compareTo("/system/lib") == 0 || str.compareTo("/system/lib/") == 0) {
                e = this.a.e(str, str2, str3);
                if (e >= 0) {
                    AppMethodBeat.o(123214);
                    return e;
                }
                mDataPath = this.a.b;
                mData = "libwxvoiceembed.bin";
                mSo = "libwxvoiceembed.so";
                this.c = true;
                AppMethodBeat.o(123214);
                return 0;
            }
            e = this.a.c(context, str, str2, str3);
            if (e >= 0) {
            }
        }
    }
}
