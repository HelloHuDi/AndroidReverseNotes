package com.tencent.liteav.basic.p1169f;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.p056d.C0252a;
import android.text.TextUtils;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.liteav.basic.f.b */
public class C45104b {
    /* renamed from: a */
    protected static final String f17759a = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/txrtmp/");
    /* renamed from: f */
    protected static C45104b f17760f;
    /* renamed from: g */
    private static Context f17761g = null;
    /* renamed from: b */
    SharedPreferences f17762b;
    /* renamed from: c */
    Editor f17763c;
    /* renamed from: d */
    String f17764d = "";
    /* renamed from: e */
    long f17765e = 0;
    /* renamed from: h */
    private boolean f17766h = false;
    /* renamed from: i */
    private boolean f17767i = false;
    /* renamed from: j */
    private C41681a f17768j = new C41681a();

    /* renamed from: com.tencent.liteav.basic.f.b$1 */
    class C177771 extends Thread {
        C177771() {
        }

        public void run() {
            AppMethodBeat.m2504i(66131);
            C45104b.m82756a(C45104b.this);
            AppMethodBeat.m2505o(66131);
        }
    }

    /* renamed from: com.tencent.liteav.basic.f.b$a */
    static class C41681a {
        /* renamed from: a */
        private int f16938a;
        /* renamed from: b */
        private String f16939b;
        /* renamed from: c */
        private int f16940c;
        /* renamed from: d */
        private int f16941d;
        /* renamed from: e */
        private int f16942e;
        /* renamed from: f */
        private int[] f16943f;
        /* renamed from: g */
        private int f16944g;
        /* renamed from: h */
        private String f16945h;
        /* renamed from: i */
        private int f16946i;
        /* renamed from: j */
        private int f16947j;
        /* renamed from: k */
        private int f16948k;
        /* renamed from: l */
        private int f16949l;
        /* renamed from: m */
        private int f16950m;
        /* renamed from: n */
        private int f16951n;
        /* renamed from: o */
        private JSONObject f16952o;
        /* renamed from: p */
        private int f16953p;

        private C41681a() {
            AppMethodBeat.m2504i(66130);
            this.f16938a = 2;
            this.f16939b = "";
            this.f16940c = 0;
            this.f16941d = 0;
            this.f16942e = 0;
            this.f16943f = null;
            this.f16944g = 0;
            this.f16945h = "";
            this.f16946i = 60;
            this.f16947j = 70;
            this.f16948k = 80;
            this.f16949l = 50;
            this.f16950m = 10;
            this.f16951n = 0;
            this.f16952o = new JSONObject();
            this.f16953p = -1;
            AppMethodBeat.m2505o(66130);
        }

        /* synthetic */ C41681a(C177771 c177771) {
            this();
        }
    }

    public C45104b() {
        AppMethodBeat.m2504i(66134);
        AppMethodBeat.m2505o(66134);
    }

    static {
        AppMethodBeat.m2504i(66173);
        AppMethodBeat.m2505o(66173);
    }

    /* renamed from: a */
    public static C45104b m82752a() {
        AppMethodBeat.m2504i(66135);
        if (f17760f == null) {
            synchronized (C45104b.class) {
                try {
                    if (f17760f == null) {
                        f17760f = new C45104b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(66135);
                    }
                }
            }
        }
        C45104b c45104b = f17760f;
        AppMethodBeat.m2505o(66135);
        return c45104b;
    }

    /* renamed from: a */
    public void mo72875a(Context context) {
        AppMethodBeat.m2504i(66136);
        if (f17761g == null) {
            f17761g = context.getApplicationContext();
        }
        AppMethodBeat.m2505o(66136);
    }

    /* renamed from: b */
    public String mo72879b() {
        AppMethodBeat.m2504i(66137);
        m82770k();
        if (this.f17768j.f16939b.isEmpty()) {
            m82757a("{\n        \"InfoList\": [\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 90,\n            \"MachineType\": \"MI 4W\",\n            \"md5_key\": \"e43363560876ce9ba9c7d8d1c5473668\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 94,\n            \"MachineType\": \"MI 5\",\n            \"md5_key\": \"57decee684de4f0ac337360b52c47655\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -6.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 96,\n            \"MachineType\": \"PLK-AL10\",\n            \"md5_key\": \"c4ae280bc5d5d3a1be3196292e96e328\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 97,\n            \"MachineType\": \"SM-G9350\",\n            \"md5_key\": \"3dc192f7e46e8ccc45e971047961c1fd\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 98,\n            \"MachineType\": \"MX4 Pro\",\n            \"md5_key\": \"c23b08889a7ad00afab83c260f7903b6\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 99,\n            \"MachineType\": \"A31\",\n            \"md5_key\": \"55451ea2d068723f3ba30d02428e69e5\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 118,\n            \"MachineType\": \"MI 4LTE\",\n            \"md5_key\": \"c58632578fc64d083ba71b3f883146bb\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 132,\n            \"MachineType\": \"OPPO R9tm\",\n            \"md5_key\": \"70c243658d28a97654b9a407e4403180\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 156,\n            \"MachineType\": \"Mi-4c\",\n            \"md5_key\": \"698d31d03e6acfe579032a12666a1458\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 166,\n            \"MachineType\": \"OPPO A33\",\n            \"md5_key\": \"466f3005f8b4f255939599dafbefba09\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 174,\n            \"MachineType\": \"OPPO A33m\",\n            \"md5_key\": \"0530eae7d07dc856d5972638467f37ba\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 191,\n            \"MachineType\": \"m1\",\n            \"md5_key\": \"b5d823597aa082daae5b1cf0184dca06\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 213,\n            \"MachineType\": \"vivo X6Plus D\",\n            \"md5_key\": \"3e8a43390c1841605c7e587c9fa0f1e1\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 226,\n            \"MachineType\": \"vivo X5Pro V\",\n            \"md5_key\": \"568018be9bd51f0f537e6f0e989d67b6\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 251,\n            \"MachineType\": \"vivo X5pro L\",\n            \"md5_key\": \"a3b82f4384857dad8dfe4be1a71a3a31\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 256,\n            \"MachineType\": \"EVA-DL00\",\n            \"md5_key\": \"8aa4062a630189844d7daa8be8a1644a\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 257,\n            \"MachineType\": \"EVA-TL00\",\n            \"md5_key\": \"576fe7aa4930dac2425ad47a82a9c883\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 260,\n            \"MachineType\": \"EVA-CL00\",\n            \"md5_key\": \"f63015e8faa7a8b8499ae8f51e187768\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 270,\n            \"MachineType\": \"EVA-AL10\",\n            \"md5_key\": \"c1ae1134125099a417313f349481e694\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 307,\n            \"MachineType\": \"SM-N9108V\",\n            \"md5_key\": \"2bf7165fa173fa12466c1c70160bc18a\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 500,\n            \"MachineType\": \"MI 5s Plus\",\n            \"md5_key\": \"863aaa3e10c4e1897969950f728c9bbc\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncloseOpensl y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1078,\n            \"MachineType\": \"PRO 7-H\",\n            \"md5_key\": \"23ff66146b45b78ae6578c0968508710\"\n          },\n          {\n            \"Factory\": \"alps\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 989,\n            \"MachineType\": \"M10\",\n            \"md5_key\": \"0604dd00fc144e313cb2cc94b48722bb\"\n          },\n          {\n            \"Factory\": \"GiONEE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 388,\n            \"MachineType\": \"F103\",\n            \"md5_key\": \"e06bf201ec1f11e149686ad0540a3460\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 394,\n            \"MachineType\": \"OPPO A33t\",\n            \"md5_key\": \"2a0411d3c106c6169542f55287a3ca9d\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -6.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 400,\n            \"MachineType\": \"OPPO R7\",\n            \"md5_key\": \"6a5b2be93fd857d0472182066a0ef087\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 401,\n            \"MachineType\": \"OPPO R9m\",\n            \"md5_key\": \"781dc5b4b13ef84f8ac33396809c1d9d\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 406,\n            \"MachineType\": \"HUAWEI MT7-CL00\",\n            \"md5_key\": \"41eb9058d2367904900278a3b77f5395\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 407,\n            \"MachineType\": \"HUAWEI MT7-TL00\",\n            \"md5_key\": \"e75375384498a9b333851732ef4d7035\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 421,\n            \"MachineType\": \"HUAWEI NXT-AL10\",\n            \"md5_key\": \"a8c21bfa2a81c196bcaa5b83855bfcfa\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 473,\n            \"MachineType\": \"SM-N9200\",\n            \"md5_key\": \"d31204d78652f954e55ffee292279583\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 481,\n            \"MachineType\": \"MI 4C\",\n            \"md5_key\": \"e62c462c90b0e426b5f4be16d6c21d4b\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 485,\n            \"MachineType\": \"Redmi Note 3\",\n            \"md5_key\": \"581952ddbe916b4726d03df052552459\"\n          },\n          {\n            \"Factory\": \"DOOV\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 518,\n            \"MachineType\": \"DOOV L5M\",\n            \"md5_key\": \"04e5d391666a13befed38dcd4573e350\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 530,\n            \"MachineType\": \"MI 3\",\n            \"md5_key\": \"5b7bf4b1a97b8a6ff87c7725de30e462\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 554,\n            \"MachineType\": \"MX6\",\n            \"md5_key\": \"c59fc0c02f647bf80b7f91c872fbbb4d\"\n          },\n          {\n            \"Factory\": \"LENOVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1041,\n            \"MachineType\": \"Lenovo K900\",\n            \"md5_key\": \"978d7f3ada45996f493764a77f803898\"\n          },\n          {\n            \"Factory\": \"M5\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 985,\n            \"MachineType\": \"X5 R1\",\n            \"md5_key\": \"caca14d06ac9598d20dc8af9e4af8911\"\n          },\n          {\n            \"Factory\": \"ZTE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 983,\n            \"MachineType\": \"ZTE N928Dt\",\n            \"md5_key\": \"f0660a29ebbb6640ddd4ce4bba707c37\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nplayRec {\\r\\ndelay 426\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 778,\n            \"MachineType\": \"OPPO R9s\",\n            \"md5_key\": \"8fb34c90f2e3c03e7ed68720e0d7610b\"\n          },\n          {\n            \"Factory\": \"JTY\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 986,\n            \"MachineType\": \"KT096H\",\n            \"md5_key\": \"9bffd716a48917dd4ced4860d2133d4b\"\n          },\n          {\n            \"Factory\": \"TCL\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 984,\n            \"MachineType\": \"TCL P501M\",\n            \"md5_key\": \"1fb4400a5ce9568c55c6ebf119b78d1c\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1050,\n            \"MachineType\": \"STF-AL00\",\n            \"md5_key\": \"ae1206b419afa5cf3e1a025db57ef7e7\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 857,\n            \"MachineType\": \"EVA-AL00\",\n            \"md5_key\": \"d2dc48d21f2fc41b07475f122d2e39c5\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 798,\n            \"MachineType\": \"OPPO R9km\",\n            \"md5_key\": \"bf4b8158c3f22d28828bb395fba49c0a\"\n          },\n          {\n            \"Factory\": \"Haier\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 990,\n            \"MachineType\": \"HT-L700T\",\n            \"md5_key\": \"65c289177604574aa7a217010fb04f9b\"\n          },\n          {\n            \"Factory\": \"Lenovo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 988,\n            \"MachineType\": \"Lenovo A916\",\n            \"md5_key\": \"8197afa18c5cd0d89646e4c5ac739654\"\n          },\n          {\n            \"Factory\": \"alps\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nplay {\\r\\nhw_sr 44100\\r\\nhw_ch 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 998,\n            \"MachineType\": \"em_ts809_p3mme\",\n            \"md5_key\": \"aedf50d4241527d69f41ae34a330c0a8\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nplayRec {\\r\\ndelay 372\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 999,\n            \"MachineType\": \"vivo X5Pro D\",\n            \"md5_key\": \"7cd73ff7316fdacac6b7389bef283b6f\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 858,\n            \"MachineType\": \"OPPO A59s\",\n            \"md5_key\": \"ce46718589f015d1a292f3fbcec9360f\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 884,\n            \"MachineType\": \"Nexus 5\",\n            \"md5_key\": \"d68d63b1e1efec657993818211c03467\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 971,\n            \"MachineType\": \"Nexus 5X\",\n            \"md5_key\": \"c892a2543c6b23a2aaab723d285732e2\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\nhevc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.6\\r\\n}\\r\\n}\\r\\nhevc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.6\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 975,\n            \"MachineType\": \"MI 6\",\n            \"md5_key\": \"dba18ff0b8d708a68e7ada721d721807\"\n          },\n          {\n            \"Factory\": \"koobee\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 20.0\\r\\npreAGCvvolmax 30.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 991,\n            \"MachineType\": \"koobee M9 Plus\",\n            \"md5_key\": \"15fa08fbbdb67c5fd9276c861a778b39\"\n          },\n          {\n            \"Factory\": \"\\u8054\\u60f3\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 992,\n            \"MachineType\": \"S6000\",\n            \"md5_key\": \"3c0884f02ff862a7805474bb7e0bd3bb\"\n          },\n          {\n            \"Factory\": \"DOOV\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1045,\n            \"MachineType\": \"DOOV L5\",\n            \"md5_key\": \"556aea5b19ac3c0c5a4c87ada0540388\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncloseOpensl y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1079,\n            \"MachineType\": \"PRO 7 Plus\",\n            \"md5_key\": \"d4fab47612ffb1fd34f89133ffe7794f\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -12.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1075,\n            \"MachineType\": \"vivo Xplay6\",\n            \"md5_key\": \"486041f66af4d08cc2e8df99da0f8158\"\n          },\n          {\n            \"Factory\": \"HTC\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nmode 0\\r\\ncap {\\r\\nsource 0\\r\\n}\\r\\nplay {\\r\\nstreamtype 3\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1047,\n            \"MachineType\": \"HTC S720e\",\n            \"md5_key\": \"d07e3f0674c92110b81b814f373289ed\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1049,\n            \"MachineType\": \"A33w\",\n            \"md5_key\": \"8c669095b373fd395259dee82f530a26\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1051,\n            \"MachineType\": \"STF-AL10\",\n            \"md5_key\": \"8b991b849cd2596caf89d4305c4a824b\"\n          },\n          {\n            \"Factory\": \"unknown\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nmode 0\\r\\ncap {\\r\\nsource 0\\r\\n}\\r\\nplay {\\r\\nstreamtype 3\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1073,\n            \"MachineType\": \"msm8909\",\n            \"md5_key\": \"f3126b20df3ff988139c1155a4907df5\"\n          }        ]\n    }", this.f17768j);
        }
        String a = this.f17768j.f16939b;
        AppMethodBeat.m2505o(66137);
        return a;
    }

    /* renamed from: c */
    public int mo72880c() {
        AppMethodBeat.m2504i(66138);
        m82770k();
        int b = this.f17768j.f16938a;
        AppMethodBeat.m2505o(66138);
        return b;
    }

    /* renamed from: d */
    public int mo72881d() {
        AppMethodBeat.m2504i(66139);
        m82770k();
        int c = this.f17768j.f16940c;
        AppMethodBeat.m2505o(66139);
        return c;
    }

    /* renamed from: e */
    public int mo72882e() {
        AppMethodBeat.m2504i(66140);
        m82770k();
        int d = this.f17768j.f16951n;
        AppMethodBeat.m2505o(66140);
        return d;
    }

    /* renamed from: f */
    public int mo72883f() {
        AppMethodBeat.m2504i(66141);
        m82770k();
        int e = this.f17768j.f16950m;
        AppMethodBeat.m2505o(66141);
        return e;
    }

    /* renamed from: a */
    public boolean mo72876a(float f, float f2, float f3) {
        boolean z;
        AppMethodBeat.m2504i(66142);
        m82770k();
        if (f2 >= ((float) this.f17768j.f16948k) || f3 <= ((float) this.f17768j.f16949l) || (f >= ((float) this.f17768j.f16946i) && f3 <= ((float) this.f17768j.f16947j))) {
            z = true;
        } else {
            z = false;
        }
        AppMethodBeat.m2505o(66142);
        return z;
    }

    /* renamed from: g */
    public boolean mo72884g() {
        AppMethodBeat.m2504i(66143);
        m82770k();
        if (this.f17768j.f16941d == 1) {
            AppMethodBeat.m2505o(66143);
            return true;
        }
        AppMethodBeat.m2505o(66143);
        return false;
    }

    /* renamed from: h */
    public int mo72885h() {
        int i;
        AppMethodBeat.m2504i(66144);
        m82770k();
        if (this.f17768j.f16943f != null) {
            i = this.f17768j.f16943f[0];
            int[] m = this.f17768j.f16943f;
            int length = m.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = m[i2];
                if (i <= i3) {
                    i3 = i;
                }
                i2++;
                i = i3;
            }
        } else {
            i = 0;
        }
        AppMethodBeat.m2505o(66144);
        return i;
    }

    /* renamed from: i */
    public int mo72886i() {
        int i;
        AppMethodBeat.m2504i(66145);
        m82770k();
        if (this.f17768j.f16943f != null) {
            i = this.f17768j.f16943f[0];
            int[] m = this.f17768j.f16943f;
            int length = m.length;
            int i2 = 0;
            while (i2 < length) {
                int i3 = m[i2];
                if (i >= i3) {
                    i3 = i;
                }
                i2++;
                i = i3;
            }
        } else {
            i = 0;
        }
        AppMethodBeat.m2505o(66145);
        return i;
    }

    /* renamed from: a */
    public long mo72874a(String str, String str2) {
        AppMethodBeat.m2504i(66146);
        m82770k();
        long a = m82750a(TXCCommonUtil.getAppID(), str, str2);
        if (a == -1) {
            a = m82750a("Global", str, str2);
        }
        AppMethodBeat.m2505o(66146);
        return a;
    }

    /* renamed from: b */
    public float mo72878b(String str, String str2) {
        AppMethodBeat.m2504i(66147);
        m82770k();
        float b = m82760b(TXCCommonUtil.getAppID(), str, str2);
        if (((double) b) == -1.0d) {
            b = m82760b("Global", str, str2);
        }
        AppMethodBeat.m2505o(66147);
        return b;
    }

    /* renamed from: a */
    private long m82750a(String str, String str2, String str3) {
        long j = -1;
        AppMethodBeat.m2504i(66148);
        if (!(TextUtils.isEmpty(str) || this.f17768j.f16952o == null)) {
            JSONObject optJSONObject = this.f17768j.f16952o.optJSONObject(str);
            if (optJSONObject != null) {
                optJSONObject = optJSONObject.optJSONObject(str2);
                if (optJSONObject != null) {
                    j = optJSONObject.optLong(str3, -1);
                }
            }
        }
        AppMethodBeat.m2505o(66148);
        return j;
    }

    /* renamed from: b */
    private float m82760b(String str, String str2, String str3) {
        AppMethodBeat.m2504i(66149);
        float f = -1.0f;
        if (!(TextUtils.isEmpty(str) || this.f17768j.f16952o == null)) {
            JSONObject optJSONObject = this.f17768j.f16952o.optJSONObject(str);
            if (optJSONObject != null) {
                optJSONObject = optJSONObject.optJSONObject(str2);
                if (optJSONObject != null) {
                    f = (float) optJSONObject.optDouble(str3, -1.0d);
                }
            }
        }
        AppMethodBeat.m2505o(66149);
        return f;
    }

    /* renamed from: a */
    public boolean mo72877a(String str) {
        AppMethodBeat.m2504i(66150);
        m82770k();
        if (this.f17768j.f16952o != null) {
            JSONObject optJSONObject = this.f17768j.f16952o.optJSONObject("Global");
            if (optJSONObject != null) {
                optJSONObject = optJSONObject.optJSONObject("DNSWhiteList");
                if (optJSONObject != null) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("InfoList");
                    if (optJSONArray != null) {
                        int i = 0;
                        while (i < optJSONArray.length()) {
                            try {
                                if (str.contains(optJSONArray.getString(i))) {
                                    AppMethodBeat.m2505o(66150);
                                    return true;
                                }
                                i++;
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(66150);
        return false;
    }

    /* renamed from: k */
    private void m82770k() {
        AppMethodBeat.m2504i(66151);
        m82771l();
        mo72887j();
        AppMethodBeat.m2505o(66151);
    }

    /* renamed from: l */
    private synchronized void m82771l() {
        AppMethodBeat.m2504i(66152);
        if (m82773n()) {
            m82763b(true);
            if (!m82775p()) {
                m82776q();
            }
            TXCLog.m15677i("CloudConfig", "load config(system aec):" + this.f17768j.f16941d + "," + this.f17768j.f16942e + "," + this.f17768j.f16944g + "," + this.f17768j.f16945h + ", model = " + Build.MODEL + ", manufacturer = " + Build.MANUFACTURER + "， board = " + Build.BOARD);
        }
        AppMethodBeat.m2505o(66152);
    }

    /* renamed from: a */
    private void m82755a(C41681a c41681a) {
        AppMethodBeat.m2504i(66153);
        if (this.f17763c == null && f17761g != null) {
            SharedPreferences sharedPreferences = f17761g.getSharedPreferences("cloud_config", 0);
            if (sharedPreferences != null) {
                this.f17763c = sharedPreferences.edit();
            }
        }
        if (this.f17763c != null) {
            this.f17763c.putLong("expired_time", this.f17765e);
            this.f17763c.putInt("hw_config", c41681a.f16938a);
            this.f17763c.putInt("ExposureCompensation", c41681a.f16940c);
            this.f17763c.putInt("UGCSWMuxerConfig", c41681a.f16951n);
            this.f17763c.putInt("CPU", c41681a.f16946i);
            this.f17763c.putInt("FPS", c41681a.f16947j);
            this.f17763c.putInt("CPU_MAX", c41681a.f16948k);
            this.f17763c.putInt("FPS_MIN", c41681a.f16949l);
            this.f17763c.putInt("CheckCount", c41681a.f16950m);
            this.f17763c.putString("trae_config", c41681a.f16939b);
            if (c41681a.f16952o != null) {
                this.f17763c.putString("AppIDConfig", c41681a.f16952o.toString());
            }
            String str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
            if (c41681a.f16943f != null) {
                str = c41681a.f16943f[0];
                for (int i = 1; i < c41681a.f16943f.length; i++) {
                    str = (str + "|") + c41681a.f16943f[i];
                }
            }
            if (c41681a.f16945h == null) {
                c41681a.f16945h = "";
            }
            this.f17763c.putString("system_aec_config", c41681a.f16941d + "," + c41681a.f16942e + "," + str + "," + c41681a.f16944g + "," + c41681a.f16945h);
            this.f17763c.commit();
        }
        AppMethodBeat.m2505o(66153);
    }

    /* renamed from: j */
    public void mo72887j() {
        AppMethodBeat.m2504i(66154);
        if (m82772m()) {
            m82759a(true);
            new C177771().start();
        }
        AppMethodBeat.m2505o(66154);
    }

    /* renamed from: m */
    private synchronized boolean m82772m() {
        boolean z;
        AppMethodBeat.m2504i(66155);
        if (this.f17766h || this.f17765e > System.currentTimeMillis()) {
            z = false;
            AppMethodBeat.m2505o(66155);
        } else {
            z = true;
            AppMethodBeat.m2505o(66155);
        }
        return z;
    }

    /* renamed from: n */
    private synchronized boolean m82773n() {
        boolean z;
        if (this.f17767i) {
            z = false;
        } else {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private synchronized void m82759a(boolean z) {
        this.f17766h = z;
    }

    /* renamed from: b */
    private synchronized void m82763b(boolean z) {
        this.f17767i = z;
    }

    /* renamed from: a */
    private synchronized void m82754a(int i) {
        AppMethodBeat.m2504i(66156);
        if (i <= 0) {
            i = 1;
        }
        this.f17765e = System.currentTimeMillis() + ((long) ((((i * 24) * 60) * 60) * 1000));
        AppMethodBeat.m2505o(66156);
    }

    /* renamed from: o */
    private void m82774o() {
        AppMethodBeat.m2504i(66157);
        try {
            TXCLog.m15679w("CloudConfig", "update server config ");
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://dldir1.qq.com/hudongzhibo/liteavsvrcfg/serverconfig_en.zip").openConnection();
            if (!this.f17764d.isEmpty()) {
                httpURLConnection.addRequestProperty("If-Modified-Since", this.f17764d);
            }
            String headerField = httpURLConnection.getHeaderField("Last-Modified");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                if (!(headerField == null || headerField.isEmpty())) {
                    this.f17764d = headerField;
                    if (this.f17763c != null) {
                        this.f17763c.putString("last_modify", this.f17764d);
                    }
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        File file;
                        byte[] a = C37355a.m62787a(byteArrayOutputStream.toByteArray(), C37355a.m62786a(Base64.decode("MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBAOnmX5h7KCQsoIQ+2ot1dIayWsmA3LU7p0kl1t5T2cbosedcsSGT+YM5bFiVBeAYbAM10WSvzZ2+oexMW7B2RcYZ1qulSR4eNXk74biDy2DmQqXK3qt1ZP4DnpiR+UXVKt6rqdtpDqRk4VGUw33/w3mMOyzkSjueewYB32n/l2JPAgMBAAECgYEA5rzfcyGTQNRRaQREPa0ZzcLmcr/Pem2lojBU3jBjtqhYz/8Nsi0yyHP+YQhpql8NNsGBlk0jjsi/HcdZ8CNMwbRfPYoe9mICe/iKMJ5P3+DtcH7AtE0ckHg01rY8pbqV9EAICijU1BwgbZh9M715HLSCeKwSWBWmpq1aQ/8l7PkCQQD5GFqrmGtMJOfTxaqS5hCHg+VsYpPsb566DEZQIJBWMP7eE58H1rphWMMSQ36c1V/iZuauYO0gYC1UlMfYHsRVAkEA8GIwlFXPG+LnkPENHo2pKORCnY7wo63hjyeQRipHhY7yUJjaPA50wDI7XCGOrJryBCVTOVszEUz4ocHQ0mOQEwJBAOnCPySVTuwQHjaQYzikCpMB5gVGpUbWoQA7kKiVRp58MFG73BwBGLtODxJOoL0RSIAwzP6MGzusxh1/2eMpTFkCQQCk5tboi0z+llPArHwRf6CRurSwHUSbJEddywg/+fUCfCNigtkC5e/VgSATfbnAUrK/gVNsP1HzBlhxruGv0jkdAkEAjNSVhjcoLg1JodbhBmD16vsAUzJpDR6EZIeiXj4pN+hKiDq9+aHEtMxtjFXiqbdKkrUjrzfZKrzQm0wy950BUw==".getBytes("UTF-8"), 2)));
                        synchronized (C45104b.class) {
                            file = new File(f17759a, "serverconfig_dec.zip");
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            fileOutputStream.write(a);
                            fileOutputStream.close();
                        }
                        m82761b(C45104b.m82753a(file));
                        AppMethodBeat.m2505o(66157);
                        return;
                    }
                }
            }
            if (responseCode == 304) {
                m82759a(false);
                TXCLog.m15675d("CloudConfig", new StringBuilder("fetch config Not-Modified-Since ").append(this.f17764d).toString() == null ? "" : this.f17764d);
            }
            AppMethodBeat.m2505o(66157);
        } catch (Exception e) {
            TXCLog.m15676e("CloudConfig", "fetch config catch exception ".concat(String.valueOf(e)));
            m82759a(false);
            AppMethodBeat.m2505o(66157);
        } catch (Throwable th) {
            while (true) {
                AppMethodBeat.m2505o(66157);
            }
        }
    }

    /* renamed from: a */
    private static String m82753a(File file) {
        String byteArrayOutputStream;
        AppMethodBeat.m2504i(66158);
        synchronized (C45104b.class) {
            try {
                ZipFile zipFile = new ZipFile(file);
                Enumeration entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                    if (!zipEntry.isDirectory()) {
                        InputStream inputStream = zipFile.getInputStream(zipEntry);
                        byte[] bArr = new byte[1048576];
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            byteArrayOutputStream2.write(bArr, 0, read);
                        }
                        inputStream.close();
                        byteArrayOutputStream = byteArrayOutputStream2.toString();
                    }
                }
                byteArrayOutputStream = "";
                AppMethodBeat.m2505o(66158);
                return byteArrayOutputStream;
            } finally {
                AppMethodBeat.m2505o(66158);
            }
        }
        return byteArrayOutputStream;
    }

    /* renamed from: b */
    private void m82761b(String str) {
        AppMethodBeat.m2504i(66159);
        m82759a(false);
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i = 1;
            if (jSONObject.has("UpdateFrequency")) {
                i = jSONObject.getInt("UpdateFrequency");
            }
            m82754a(i);
            C41681a a = m82751a(jSONObject);
            if (a != null) {
                this.f17768j = a;
                m82755a(a);
            }
            AppMethodBeat.m2505o(66159);
        } catch (JSONException e) {
            TXCLog.m15679w("CloudConfig", "parseRespon catch ecxeption".concat(String.valueOf(e)));
            AppMethodBeat.m2505o(66159);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x012c A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m82758a(JSONObject jSONObject, C41681a c41681a) {
        int i;
        Exception e;
        String str = null;
        AppMethodBeat.m2504i(66160);
        c41681a.f16941d = 0;
        c41681a.f16942e = 0;
        c41681a.f16943f = null;
        c41681a.f16944g = 0;
        c41681a.f16945h = "";
        if (jSONObject.has("SystemAECConfig")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("SystemAECConfig");
            if (jSONObject2.has("InfoList")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("InfoList");
                String str2 = null;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                    if (jSONObject3 != null && jSONObject3.getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER)) {
                        int i3;
                        JSONArray optJSONArray = jSONObject3.optJSONArray("WhiteList");
                        if (optJSONArray != null) {
                            for (i3 = 0; i3 < optJSONArray.length(); i3++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                                if (optJSONObject != null) {
                                    String optString = optJSONObject.optString(C0252a.TAG_MODEL);
                                    if (optString != null && Build.MODEL.equals(optString)) {
                                        i3 = 1;
                                        break;
                                    }
                                }
                            }
                        }
                        i3 = 0;
                        JSONArray optJSONArray2 = jSONObject3.optJSONArray("BlackList");
                        if (optJSONArray2 != null) {
                            for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i4);
                                if (optJSONObject2 != null) {
                                    String optString2 = optJSONObject2.optString(C0252a.TAG_MODEL);
                                    if (optString2 != null && Build.MODEL.equals(optString2)) {
                                        i = 1;
                                        break;
                                    }
                                }
                            }
                        }
                        i = 0;
                        if (i3 != 0) {
                            String optString3;
                            try {
                                c41681a.f16941d = jSONObject3.optInt("SystemAEC", 0);
                                c41681a.f16942e = jSONObject3.optInt("AGC", 0);
                                optString3 = jSONObject3.optString("SampleRate", "");
                                try {
                                    if (!optString3.isEmpty()) {
                                        String[] split = optString3.split("\\|");
                                        c41681a.f16943f = new int[split.length];
                                        for (int i5 = 0; i5 < split.length; i5++) {
                                            c41681a.f16943f[i5] = Integer.valueOf(split[i5].trim()).intValue();
                                        }
                                    }
                                    c41681a.f16944g = jSONObject3.optInt("HWAACCodec", 0);
                                    c41681a.f16945h = jSONObject3.optString(C0252a.TAG_SCENE_TYPE, "");
                                    str2 = optString3;
                                } catch (Exception e2) {
                                    e = e2;
                                    TXCLog.m15676e("CloudConfig", "parseSysAECConfig Exception: " + e.getMessage());
                                    str2 = optString3;
                                    if (i == 0) {
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                optString3 = str2;
                            }
                        }
                        if (i == 0) {
                            c41681a.f16941d = 0;
                            c41681a.f16942e = 0;
                            c41681a.f16943f = null;
                            c41681a.f16944g = 0;
                            c41681a.f16945h = "";
                        }
                    }
                }
                str = str2;
            }
        }
        TXCLog.m15677i("CloudConfig", "system aec config1:" + c41681a.f16941d + "," + c41681a.f16942e + "," + str + "," + c41681a.f16944g + "," + c41681a.f16945h + ", model = " + Build.MODEL + ", manufacturer = " + Build.MANUFACTURER + "， board = " + Build.BOARD);
        AppMethodBeat.m2505o(66160);
    }

    /* renamed from: b */
    private void m82762b(JSONObject jSONObject, C41681a c41681a) {
        AppMethodBeat.m2504i(66161);
        if (jSONObject.has("TraeConfig")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("TraeConfig");
            if (jSONObject2.has("InfoList")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("InfoList");
                int i = 0;
                while (i < jSONArray.length()) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    if (jSONObject3 == null || !jSONObject3.getString("MachineType").equals(Build.MODEL)) {
                        i++;
                    } else {
                        c41681a.f16939b = jSONObject3.getString("ConfigValue");
                        TXCLog.m15675d("CloudConfig", "parseTRAEConfig get TRAE config: " + c41681a.f16939b);
                        AppMethodBeat.m2505o(66161);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(66161);
    }

    /* renamed from: c */
    private void m82764c(JSONObject jSONObject, C41681a c41681a) {
        AppMethodBeat.m2504i(66162);
        if (jSONObject.has("WeiXinConfig")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("WeiXinConfig");
            if (jSONObject2.has("InfoList")) {
                JSONArray jSONArray = jSONObject2.getJSONArray("InfoList");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    if (jSONObject3 != null) {
                        String string = jSONObject3.getString("Manufacture");
                        String string2 = jSONObject3.getString(C0252a.TAG_MODEL);
                        if (string.equals(Build.MANUFACTURER) && string2.equals(Build.MODEL)) {
                            c41681a.f16953p = Integer.parseInt(jSONObject3.getString("SampleRate"));
                            TXCLog.m15675d("CloudConfig", "parseWeiXinConfig get WeiXin config: record sample rate = " + c41681a.f16953p);
                            AppMethodBeat.m2505o(66162);
                            return;
                        }
                    }
                }
            }
        }
        AppMethodBeat.m2505o(66162);
    }

    /* renamed from: d */
    private void m82765d(JSONObject jSONObject, C41681a c41681a) {
        AppMethodBeat.m2504i(66163);
        c41681a.f16946i = 60;
        c41681a.f16947j = 70;
        c41681a.f16948k = 80;
        c41681a.f16949l = 50;
        c41681a.f16950m = 10;
        if (jSONObject.has("HWWhiteList")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("HWWhiteList");
            if (jSONObject2.has("SWToHWThreshold")) {
                jSONObject2 = jSONObject2.getJSONObject("SWToHWThreshold");
                if (jSONObject2.has("CPU")) {
                    c41681a.f16946i = jSONObject2.getInt("CPU");
                    TXCLog.m15675d("CloudConfig", "parseAutoSWHWConfig get SWToHWThreshold.CPU:" + c41681a.f16946i);
                }
                if (jSONObject2.has("FPS")) {
                    c41681a.f16947j = jSONObject2.getInt("FPS");
                    TXCLog.m15675d("CloudConfig", "parseAutoSWHWConfig get SWToHWThreshold.FPS:" + c41681a.f16947j);
                }
                if (jSONObject2.has("CPU_MAX")) {
                    c41681a.f16948k = jSONObject2.getInt("CPU_MAX");
                    TXCLog.m15675d("CloudConfig", "parseAutoSWHWConfig get SWToHWThreshold.CPU:" + c41681a.f16948k);
                }
                if (jSONObject2.has("FPS_MIN")) {
                    c41681a.f16949l = jSONObject2.getInt("FPS_MIN");
                    TXCLog.m15675d("CloudConfig", "parseAutoSWHWConfig get SWToHWThreshold.FPS:" + c41681a.f16949l);
                }
                if (jSONObject2.has("CheckCount")) {
                    c41681a.f16950m = jSONObject2.getInt("CheckCount");
                    TXCLog.m15675d("CloudConfig", "parseAutoSWHWConfig get SWToHWThreshold.CheckCount:" + c41681a.f16950m);
                }
            }
        }
        AppMethodBeat.m2505o(66163);
    }

    /* renamed from: e */
    private void m82766e(JSONObject jSONObject, C41681a c41681a) {
        AppMethodBeat.m2504i(66164);
        if (jSONObject.has("ExposureWhiteConfig")) {
            JSONArray jSONArray = jSONObject.getJSONObject("ExposureWhiteConfig").getJSONArray("InfoList");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                if (jSONObject2.getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER) && jSONObject2.getString(C0252a.TAG_MODEL).equalsIgnoreCase(Build.MODEL)) {
                    c41681a.f16940c = jSONObject2.getInt("ExposureCompensation");
                    TXCLog.m15675d("CloudConfig", "parseExposureConfig get exposure config: " + c41681a.f16940c);
                    break;
                }
            }
            if (f17761g != null) {
                f17761g.sendBroadcast(new Intent("com.tencent.liteav.basic.serverconfig.get"));
            }
        }
        AppMethodBeat.m2505o(66164);
    }

    /* renamed from: f */
    private void m82767f(JSONObject jSONObject, C41681a c41681a) {
        AppMethodBeat.m2504i(66165);
        if (jSONObject.has("HWBlackConfig")) {
            JSONObject jSONObject2 = jSONObject.getJSONObject("HWBlackConfig");
            int i = 16;
            if (jSONObject2.has("HWMiniSupportAPI")) {
                i = jSONObject2.getInt("HWMiniSupportAPI");
            }
            if (VERSION.SDK_INT < i) {
                c41681a.f16938a = 0;
                AppMethodBeat.m2505o(66165);
                return;
            }
            JSONArray jSONArray = jSONObject2.getJSONArray("InfoList");
            i = 0;
            while (i < jSONArray.length()) {
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                if (!jSONObject3.getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER) || !jSONObject3.getString(C0252a.TAG_MODEL).equalsIgnoreCase(Build.MODEL)) {
                    i++;
                } else if (jSONObject3.has(Scopes.PROFILE)) {
                    c41681a.f16938a = 1;
                    TXCLog.m15675d("CloudConfig", "parseHWBlackConfig get HWBlack config: " + c41681a.f16938a);
                    AppMethodBeat.m2505o(66165);
                    return;
                } else {
                    c41681a.f16938a = 0;
                    TXCLog.m15675d("CloudConfig", "parseHWBlackConfig get HWBlack config: " + c41681a.f16938a);
                    AppMethodBeat.m2505o(66165);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(66165);
    }

    /* renamed from: a */
    private void m82757a(String str, C41681a c41681a) {
        AppMethodBeat.m2504i(66166);
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("InfoList")) {
                JSONArray jSONArray = jSONObject.getJSONArray("InfoList");
                int i = 0;
                while (i < jSONArray.length()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2 == null || !jSONObject2.getString("MachineType").equals(Build.MODEL)) {
                        i++;
                    } else {
                        c41681a.f16939b = jSONObject2.getString("ConfigValue");
                        AppMethodBeat.m2505o(66166);
                        return;
                    }
                }
            }
            AppMethodBeat.m2505o(66166);
        } catch (JSONException e) {
            TXCLog.m15679w("CloudConfig", "parseTraeLocalConfig catch ecxeption".concat(String.valueOf(e)));
            AppMethodBeat.m2505o(66166);
        }
    }

    /* renamed from: g */
    private void m82768g(JSONObject jSONObject, C41681a c41681a) {
        AppMethodBeat.m2504i(66167);
        if (jSONObject.has("UGCSWMuxerConfig")) {
            JSONArray jSONArray = jSONObject.getJSONObject("UGCSWMuxerConfig").getJSONArray("InfoList");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.getJSONObject(i).getString("Manufacture").equalsIgnoreCase(Build.MANUFACTURER)) {
                    c41681a.f16951n = 1;
                    AppMethodBeat.m2505o(66167);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(66167);
    }

    /* renamed from: h */
    private void m82769h(JSONObject jSONObject, C41681a c41681a) {
        AppMethodBeat.m2504i(66168);
        if (jSONObject.has("AppIDConfig")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("AppIDConfig");
            if (optJSONObject != null) {
                c41681a.f16952o = optJSONObject;
                TXCLog.m15679w("CloudConfig", "parse global config : " + c41681a.f16952o);
            }
        }
        AppMethodBeat.m2505o(66168);
    }

    /* renamed from: p */
    private boolean m82775p() {
        AppMethodBeat.m2504i(66169);
        if (f17761g == null) {
            AppMethodBeat.m2505o(66169);
            return false;
        }
        this.f17762b = f17761g.getSharedPreferences("cloud_config", 0);
        if (this.f17762b == null || !this.f17762b.contains("expired_time")) {
            AppMethodBeat.m2505o(66169);
            return false;
        }
        TXCLog.m15679w("CloudConfig", "loadLocalFileConfig ");
        this.f17763c = this.f17762b.edit();
        try {
            this.f17764d = this.f17762b.getString("last_modify", "");
            this.f17765e = this.f17762b.getLong("expired_time", System.currentTimeMillis());
            this.f17768j.f16938a = this.f17762b.getInt("hw_config", 2);
            this.f17768j.f16940c = this.f17762b.getInt("ExposureCompensation", 0);
            this.f17768j.f16951n = this.f17762b.getInt("UGCSWMuxerConfig", 0);
            this.f17768j.f16946i = this.f17762b.getInt("CPU", 60);
            this.f17768j.f16947j = this.f17762b.getInt("FPS", 70);
            this.f17768j.f16948k = this.f17762b.getInt("CPU_MAX", 80);
            this.f17768j.f16949l = this.f17762b.getInt("FPS_MIN", 50);
            this.f17768j.f16950m = this.f17762b.getInt("CheckCount", 10);
            this.f17768j.f16939b = this.f17762b.getString("trae_config", "");
            String string = this.f17762b.getString("system_aec_config", "");
            String string2 = this.f17762b.getString("AppIDConfig", "");
            if (!TextUtils.isEmpty(string2)) {
                this.f17768j.f16952o = new JSONObject(string2);
            }
            TXCLog.m15677i("CloudConfig", "system aec config:".concat(String.valueOf(string)));
            if (!string.isEmpty()) {
                String[] split = string.split(",");
                if (split != null && split.length >= 5) {
                    this.f17768j.f16941d = Integer.valueOf(split[0]).intValue();
                    this.f17768j.f16942e = Integer.valueOf(split[1]).intValue();
                    String[] split2 = split[2].split("\\|");
                    if (split2 != null) {
                        this.f17768j.f16943f = new int[split2.length];
                        for (int i = 0; i < split2.length; i++) {
                            this.f17768j.f16943f[i] = Integer.valueOf(split2[i].trim()).intValue();
                        }
                    }
                    this.f17768j.f16944g = Integer.valueOf(split[3]).intValue();
                    this.f17768j.f16945h = split[4];
                }
            }
            AppMethodBeat.m2505o(66169);
            return true;
        } catch (Exception e) {
            this.f17763c.clear();
            this.f17763c.commit();
            TXCLog.m15675d("CloudConfig", "loadLocalFileConfig catch exception ".concat(String.valueOf(e)));
            AppMethodBeat.m2505o(66169);
            return false;
        }
    }

    /* renamed from: q */
    private void m82776q() {
        AppMethodBeat.m2504i(66170);
        try {
            TXCLog.m15679w("CloudConfig", "loadDefaultConfig ");
            C41681a a = m82751a(new JSONObject("{\n    \"version\": 3,\n    \"UpdateFrequency\": 1,\n    \"AppIDConfig\": {\n        \"Global\": {\n           \"DataReport\": {\n               \"UserPortrait\": 0\n           },\n           \"Audio\": {\n               \"RTC_JitterCycle\" : 240,\n               \"LIVE_JitterCycle\": 500,\n               \"LoadingThreshold\": 800,\n               \"SmoothModeAdjust\": 300,\n               \"SmoothAdjust\": 10,\n               \"RtcPlayHungryTimeThreshold\": 60,\n               \"SmoothSpeed\": 1.2\n           },\n           \"Network\": {\n               \"EnableRouteOptimize\": 0,\n               \"RouteSamplingMaxCount\": 0,\n               \"QualityDataCacheCount\": 0,\n               \"AccRetryCountWithoutSecret\": 0\n           },\n           \"QUICMode\": {\n               \"Live\": 0,\n               \"LinkMain\": 0,\n               \"LinkSub\": 0,\n               \"RTC\": 0,\n               \"AVRoom\": 0\n           }\n       }\n    },\n    \"PlayModeConfig\": {\n        \"SmoothModeOffset\": 0\n    },\n    \"UGCSWMuxerConfig\": {\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"HUAWEI\"\n            }\n        ]\n    },\n    \"HWBlackConfig\": {\n        \"HWMiniSupportAPI\": 17,\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"P6-U06\"\n            },\n            {\n                \"Manufacture\": \"Samsung\",\n                \"Model\": \"SCH-I939(S3)\"\n            },\n            {\n                \"Manufacture\": \"VIVO\",\n                \"Model\": \"vivo X5Pro D\"\n            },\n            {\n                \"Manufacture\": \"金立\",\n                \"Model\": \"GN9006\"\n            },\n            {\n                \"Manufacture\": \"Samsung\",\n                \"Model\": \"A7000\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"HUAWEI NXT-AL10\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"HUAWEI MHA-AL00\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"EVA-AL00\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"EVA-AL10\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"MHA-L29\",\n\t\t\t\t\"Profile\": \"baseline\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"MHA-L00\",\n\t\t\t\t\"Profile\": \"baseline\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"MHA-TL00\",\n\t\t\t\t\"Profile\": \"baseline\"\n            },\n             {\n                 \"Manufacture\": \"HUAWEI\",\n                 \"Model\": \"HUAWEI GRA-UL00\"\n             }\n        ]\n    },\n    \"ExposureWhiteConfig\": {\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"Meizu\",\n                \"Model\": \"MX4 Pro\",\n                \"ExposureCompensation\": 1\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"Model\": \"MI 3\",\n                \"ExposureCompensation\": 30\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"Model\": \"MI 3C\",\n                \"ExposureCompensation\": 30\n            }\n        ]\n    },\n    \"SystemAECConfig\": {\n        \"__comment__\":\"SceneType(开启系统aec的场景，1为连麦，2为通话)\",\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"vivo\",\n                \"WhiteList\": [{\"Model\":\"vivo X9\"},{\"Model\":\"vivo Y67A\"}],\n                \"BlackList\": [],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"vivo\",\n                \"WhiteList\": [{\"Model\":\"vivo X9Plus\"},{\"Model\":\"vivo X7Plus\"},{\"Model\":\"vivo X7\"}],\n                \"BlackList\": [{\"Model\":\"vivo Y51A\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"WhiteList\": [{\"Model\":\"VTR-TL00\"},{\"Model\":\"HUAWEI GRA-UL00\"},{\"Model\":\"HUAWEI NXT-AL10\"},{\"Model\":\"PLK-AL10\"},{\"Model\":\"PLK-UL00\"},{\"Model\":\"EVA-AL10\"},{\"Model\":\"HUAWEI MT7-TL10\"}],\n                \"BlackList\": [{\"Model\":\"MHA-AL00\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"WhiteList\": [{\"Model\":\"Redmi Note 2\"},{\"Model\":\"Redmi Note 4\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"WhiteList\": [{\"Model\":\"Redmi Note 3\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"WhiteList\": [{\"Model\":\"MI 4\"},{\"Model\":\"MI 3C\"},{\"Model\":\"Mi-4c\"}],\n                \"BlackList\": [{\"Model\":\"MI 6\"},{\"Model\":\"Redmi 4A\"},{\"Model\":\"MI 5X\"},{\"Model\":\"MI 5\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Google\",\n                \"WhiteList\": [{\"Model\":\"Pixel XL\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"samsung\",\n                \"WhiteList\": [{\"Model\":\"SM-G9350\"},{\"Model\":\"SM-G9500\"},{\"Model\":\"SM-G950U\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                 \"Manufacture\": \"LeMobile\",\n                 \"WhiteList\": [{\"Model\":\"X620\"}],\n                 \"SystemAEC\": 1,\n                 \"AGC\": 0,\n                 \"SampleRate\": \"48000|16000\",\n                 \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n             {\n                  \"Manufacture\": \"asus\",\n                  \"WhiteList\": [{\"Model\":\"ASUS_Z00ADB\"}],\n                  \"SystemAEC\": 1,\n                  \"AGC\": 0,\n                  \"SampleRate\": \"48000|16000\",\n                  \"HWAACCodec\": 1,\n                 \"SceneType\": \"1|2\"\n             }\n        ]\n    },\n    \"HWWhiteList\": {\n        \"SWToHWThreshold\": {\n            \"CPU_MAX\": 80,\n            \"FPS_MIN\": 50,\n            \"CPU\": 20,\n            \"FPS\": 70,\n            \"CheckCount\": 10,\n            \"__comment__\": \"软编根据性能切硬编的阈值，avgTotalCPU >= CPU_MAX || avgFPS <= FPS_MIN || (avgAppCPU >= CPU && avgFPS <= FPS) 性能指标满足上述条件则切硬编。CheckCount表示需要做X次有效性能数据采集。\"\n\t\t}\n    },\n    \"TraeConfig\": {\n        \"InfoList\": [\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"EVA-AL00\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"EVA-AL10\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"EVA-CL00\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"EVA-DL00\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"EVA-TL00\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"HUAWEI MT7-CL00\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"HUAWEI MT7-TL00\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"HUAWEI MT7-TL10\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"HUAWEI NXT-AL10\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"MachineType\": \"PLK-AL10\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"JTY\",\n            \"MachineType\": \"KT096H\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"LENOVO\",\n            \"MachineType\": \"Lenovo K900\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"MachineType\": \"Nexus 5\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"MachineType\": \"Nexus 5X\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"M5\",\n            \"MachineType\": \"X5 R1\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"MachineType\": \"MX4 Pro\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"MachineType\": \"A31\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"MachineType\": \"OPPO A33\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"MachineType\": \"OPPO A59s\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"MachineType\": \"OPPO R7\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"MachineType\": \"OPPO R9km\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"MachineType\": \"OPPO R9m\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"MachineType\": \"OPPO R9s\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\naec {\\r\\nUseHQAEC y\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"MachineType\": \"OPPO R9tm\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"MachineType\": \"SM-G9350\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nloopback y\\r\\nloop {\\r\\ngap 4\\r\\nbufnum 2\\r\\nvolume 2.0\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"MachineType\": \"SM-N9108V\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"MachineType\": \"SM-N9200\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"TCL\",\n            \"MachineType\": \"TCL P501M\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"MachineType\": \"MI 3\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"MachineType\": \"MI 4LTE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"MachineType\": \"MI 4W\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"MachineType\": \"MI 5\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nloopback y\\r\\nloop {\\r\\ngap 4\\r\\nbufnum 2\\r\\nvolume 0.25\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"MachineType\": \"MI 5s\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nloopback y\\r\\nloop {\\r\\ngap 4\\r\\nbufnum 2\\r\\n}\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"MachineType\": \"MI 5s Plus\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nloopback y\\r\\nloop {\\r\\ngap 4\\r\\nbufnum 2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"MachineType\": \"MI NOTE LTE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"MachineType\": \"Redmi Note 3\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\"\n          },\n          {\n            \"Factory\": \"ZTE\",\n            \"MachineType\": \"ZTE N928Dt\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\"\n          }\n        ]\n    }\n}"));
            if (a != null) {
                this.f17768j = a;
            }
            AppMethodBeat.m2505o(66170);
        } catch (JSONException e) {
            TXCLog.m15679w("CloudConfig", "loadDefaultConfig catch exception ".concat(String.valueOf(e)));
            this.f17768j = new C41681a();
            AppMethodBeat.m2505o(66170);
        }
    }

    /* renamed from: a */
    private C41681a m82751a(JSONObject jSONObject) {
        AppMethodBeat.m2504i(66171);
        if (jSONObject == null) {
            AppMethodBeat.m2505o(66171);
            return null;
        }
        C41681a c41681a = new C41681a();
        try {
            m82767f(jSONObject, c41681a);
            m82766e(jSONObject, c41681a);
            m82765d(jSONObject, c41681a);
            m82758a(jSONObject, c41681a);
            m82762b(jSONObject, c41681a);
            m82764c(jSONObject, c41681a);
            m82768g(jSONObject, c41681a);
            m82769h(jSONObject, c41681a);
        } catch (JSONException e) {
            TXCLog.m15679w("CloudConfig", "parse config catch exception " + e.toString());
            c41681a = null;
        }
        AppMethodBeat.m2505o(66171);
        return c41681a;
    }
}
