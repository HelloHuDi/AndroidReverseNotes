package com.tencent.xweb.xwalk;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.xweb.C16403w;
import com.tencent.xweb.C31139d;
import com.tencent.xweb.C31139d.C31140a;
import com.tencent.xweb.C31146m;
import com.tencent.xweb.C41128i;
import com.tencent.xweb.C41128i.C36587a;
import com.tencent.xweb.C44572a;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.C44570d;
import com.tencent.xweb.p1115c.C31138d;
import com.tencent.xweb.p1115c.C44581k;
import com.tencent.xweb.util.C41130a;
import com.tencent.xweb.util.C41131b;
import com.tencent.xweb.util.C6037d;
import com.tencent.xweb.xwalk.p686a.C24550c;
import com.tencent.xweb.xwalk.p686a.C36602e;
import com.tencent.xweb.xwalk.p686a.C36603f;
import com.tencent.xweb.xwalk.p686a.C36603f.C36604a;
import com.tencent.xweb.xwalk.p686a.C6051d;
import com.tencent.xweb.xwalk.p687b.C41136c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.UpdateConfig;

/* renamed from: com.tencent.xweb.xwalk.c */
public final class C31513c implements C31138d {
    Context AMr;
    WebView ARb;
    ScrollView ARc = null;
    TextView ARd = null;
    TextView ARe = null;
    TextView ARf = null;
    Button ARg = null;
    View ARh;
    boolean ARi = false;
    String ARj = "tools";

    /* renamed from: com.tencent.xweb.xwalk.c$23 */
    class C606223 implements OnLongClickListener {
        C606223() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(85144);
            C31513c.this.dVF();
            AppMethodBeat.m2505o(85144);
            return true;
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$24 */
    class C606324 implements OnClickListener {
        C606324() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85145);
            C31146m.dTZ().mo50905a("tools", C44570d.WV_KIND_X5);
            C31146m.dTZ().mo50905a("toolsmp", C44570d.WV_KIND_X5);
            C31146m.dTZ().mo50905a("appbrand", C44570d.WV_KIND_X5);
            C31146m.dTZ().mo50905a("support", C44570d.WV_KIND_X5);
            C31146m.dTZ().mo50905a("mm", C44570d.WV_KIND_X5);
            if (WebView.getInstalledTbsCoreVersion(C31513c.this.AMr) <= 0) {
                C31513c.this.mo51453cs("已切换x5，但是x5未ready，点任意位置重启进程生效\n", true);
                AppMethodBeat.m2505o(85145);
                return;
            }
            C31513c.this.mo51454ct("已使用x5，点任意位置重启进程生效\n", true);
            AppMethodBeat.m2505o(85145);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$26 */
    class C606426 implements OnClickListener {
        C606426() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85147);
            XWalkEnvironment.setGrayValueForTest(0);
            XWalkEnvironment.setTestDownLoadUrl(C31513c.this.AMr, "");
            C31146m.dTZ().mo50905a("tools", C44570d.WV_KIND_NONE);
            C31146m.dTZ().mo50905a("toolsmp", C44570d.WV_KIND_NONE);
            C31146m.dTZ().mo50905a("appbrand", C44570d.WV_KIND_NONE);
            C31146m.dTZ().mo50905a("support", C44570d.WV_KIND_NONE);
            C31146m.dTZ().mo50905a("mm", C44570d.WV_KIND_NONE);
            C31513c.this.mo51454ct("已使用AUTO，点任意位置重启进程生效\n", true);
            AppMethodBeat.m2505o(85147);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$27 */
    class C606527 implements OnClickListener {
        C606527() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85148);
            LinearLayout linearLayout = (LinearLayout) C31513c.this.ARh.findViewById(2131823212);
            if (linearLayout.getVisibility() == 8) {
                linearLayout.setVisibility(0);
                ((Button) view).setText("隐藏高级设置");
                AppMethodBeat.m2505o(85148);
                return;
            }
            linearLayout.setVisibility(8);
            ((Button) view).setText("高级设置");
            AppMethodBeat.m2505o(85148);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$39 */
    class C606639 implements OnCancelListener {
        C606639() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(85167);
            C31513c.this.aAe();
            AppMethodBeat.m2505o(85167);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$30 */
    class C1641330 implements OnLongClickListener {

        /* renamed from: com.tencent.xweb.xwalk.c$30$2 */
        class C164142 implements DialogInterface.OnClickListener {
            C164142() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(85151);
                C31513c.m51004b(C31513c.this, Environment.getExternalStorageDirectory() + "/xweb_dump");
                AppMethodBeat.m2505o(85151);
            }
        }

        /* renamed from: com.tencent.xweb.xwalk.c$30$1 */
        class C164151 implements DialogInterface.OnClickListener {
            C164151() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C1641330() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(85152);
            new Builder(C31513c.this.AMr).setTitle("提示").setMessage("清空保存页面文件").setPositiveButton("确定", new C164142()).setNegativeButton("取消", new C164151()).show();
            AppMethodBeat.m2505o(85152);
            return false;
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$6 */
    class C164166 implements OnClickListener {
        C164166() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85127);
            ((TextView) C31513c.this.ARh.findViewById(2131823250)).setText(C31513c.this.mo51461rC(true) + IOUtils.LINE_SEPARATOR_UNIX + XWalkInitializer.getXWalkInitializeLog());
            AppMethodBeat.m2505o(85127);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$9 */
    class C164189 implements OnClickListener {
        C164189() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85130);
            C31513c.this.dVH();
            AppMethodBeat.m2505o(85130);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$b */
    class C16419b extends C46946n {
        boolean ARG = false;
        private ProgressDialog ARs;

        /* renamed from: com.tencent.xweb.xwalk.c$b$1 */
        class C164201 implements OnCancelListener {
            C164201() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(85176);
                C31513c.this.aAe();
                AppMethodBeat.m2505o(85176);
            }
        }

        public C16419b(Context context) {
            super(context);
        }

        public final void onXWalkUpdateProgress(int i) {
            AppMethodBeat.m2504i(85177);
            super.onXWalkUpdateProgress(i);
            if (this.ARG) {
                AppMethodBeat.m2505o(85177);
                return;
            }
            try {
                avt("正在下载runtime");
                if (this.ARs != null) {
                    this.ARs.setProgress(i);
                }
                AppMethodBeat.m2505o(85177);
            } catch (Exception e) {
                Log.m81049i("WebDebugPage", "may run in background failed to load alert:" + e.getMessage());
                AppMethodBeat.m2505o(85177);
            }
        }

        public final void onXWalkUpdateFailed(int i) {
            AppMethodBeat.m2504i(85178);
            super.onXWalkUpdateFailed(i);
            try {
                this.ARs.setCancelable(true);
                this.ARs.setCanceledOnTouchOutside(true);
                avt("更新失败, error code = :".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(85178);
            } catch (Exception e) {
                Log.m81049i("WebDebugPage", "may run in background failed to load alert:" + e.getMessage());
                AppMethodBeat.m2505o(85178);
            }
        }

        public final void onXWalkUpdateCancelled() {
            AppMethodBeat.m2504i(85179);
            super.onXWalkUpdateCancelled();
            try {
                this.ARs.setCancelable(true);
                this.ARs.setCanceledOnTouchOutside(true);
                avt("更新失败, 更新被取消");
                AppMethodBeat.m2505o(85179);
            } catch (Exception e) {
                Log.m81049i("WebDebugPage", "may run in background failed to load alert:" + e.getMessage());
                AppMethodBeat.m2505o(85179);
            }
        }

        public final void onXWalkUpdateCompleted() {
            AppMethodBeat.m2504i(85180);
            super.onXWalkUpdateCompleted();
            try {
                avt("更新完成，点任意位置重启进程生效");
                this.ARs.setCancelable(true);
                this.ARs.setCanceledOnTouchOutside(true);
                this.ARs.setProgress(100);
                this.ARG = true;
                AppMethodBeat.m2505o(85180);
            } catch (Exception e) {
                Log.m81049i("WebDebugPage", "may run in background failed to load alert:" + e.getMessage());
                AppMethodBeat.m2505o(85180);
            }
        }

        private void avt(String str) {
            AppMethodBeat.m2504i(85181);
            if (this.ARs == null) {
                this.ARs = new ProgressDialog(this.mContext);
                this.ARs.setProgressStyle(1);
                this.ARs.setMessage(str);
                this.ARs.setOnCancelListener(new C164201());
                this.ARs.setCancelable(false);
                this.ARs.show();
            }
            this.ARs.setMessage(str);
            AppMethodBeat.m2505o(85181);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$13 */
    class C2455713 implements OnClickListener {
        C2455713() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85134);
            C36603f c36603f = new C36603f();
            HashMap hashMap = new HashMap();
            hashMap.put("UpdaterCheckType", "1");
            c36603f.mo30119a(C31513c.this.AMr, hashMap);
            Toast.makeText(C31513c.this.AMr, "开始检测插件更新", 0).show();
            AppMethodBeat.m2505o(85134);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$37 */
    class C2456037 implements DialogInterface.OnClickListener {
        C2456037() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$42 */
    class C2456142 implements OnCheckedChangeListener {
        C2456142() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(85170);
            C31146m dTZ = C31146m.dTZ();
            if (z != dTZ.AMu) {
                dTZ.AMu = z;
                dTZ.AMr.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowVersion", dTZ.AMu).commit();
            }
            if (z) {
                C31513c.this.dVD();
                C31513c.this.ARe.setVisibility(0);
                AppMethodBeat.m2505o(85170);
                return;
            }
            if (C31513c.this.ARe != null) {
                C31513c.this.ARe.setVisibility(8);
            }
            AppMethodBeat.m2505o(85170);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$45 */
    class C2456445 implements OnItemSelectedListener {
        C2456445() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            int i2 = 1;
            AppMethodBeat.m2504i(85173);
            String[] stringArray = C31513c.this.AMr.getResources().getStringArray(C25738R.array.f12642ax);
            C31513c.this.ARj = stringArray[i];
            C31513c c31513c = C31513c.this;
            c31513c.ARi = true;
            if (c31513c.ARj.equals("all")) {
                String[] stringArray2 = c31513c.AMr.getResources().getStringArray(C25738R.array.f12641aw);
                C44570d avg = C31146m.dTZ().avg(stringArray2[0]);
                while (i2 < stringArray2.length) {
                    if (C31146m.dTZ().avg(stringArray2[i2]) != avg) {
                        ((RadioButton) c31513c.ARh.findViewById(2131823216)).setChecked(false);
                        ((RadioButton) c31513c.ARh.findViewById(2131823217)).setChecked(false);
                        ((RadioButton) c31513c.ARh.findViewById(2131823219)).setChecked(false);
                        ((RadioButton) c31513c.ARh.findViewById(2131823218)).setChecked(false);
                        break;
                    }
                    i2++;
                }
                c31513c.mo51460l(avg);
            } else {
                c31513c.mo51460l(C31146m.dTZ().avg(c31513c.ARj));
            }
            c31513c.ARi = false;
            AppMethodBeat.m2505o(85173);
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$12 */
    class C3115712 implements OnClickListener {
        C3115712() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85133);
            C31513c.this.dVC();
            AppMethodBeat.m2505o(85133);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$18 */
    class C3115818 implements OnClickListener {
        C3115818() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85139);
            C31513c c31513c = C31513c.this;
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory == null) {
                c31513c.mo51453cs("请确认应用权限，在权限管理打开应用的读写存储权限", true);
                AppMethodBeat.m2505o(85139);
            } else if (externalStorageDirectory.listFiles() == null) {
                c31513c.mo51453cs("请确认应用权限，在权限管理打开应用的读写存储权限", true);
                AppMethodBeat.m2505o(85139);
            } else {
                String str = externalStorageDirectory.getPath() + "/apkxwebtest/xweb_filereader.zip";
                if (new File(str).exists()) {
                    new C3152533(str).execute(new Void[0]);
                    AppMethodBeat.m2505o(85139);
                    return;
                }
                c31513c.mo51453cs("文件不存在 /apkxwebtest/xweb_filereader.zip", true);
                AppMethodBeat.m2505o(85139);
            }
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$32 */
    class C3116132 implements DialogInterface.OnClickListener {
        C3116132() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(85158);
            C31513c.this.aAe();
            AppMethodBeat.m2505o(85158);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$38 */
    class C3116338 implements DialogInterface.OnClickListener {
        final /* synthetic */ String ARB;
        final /* synthetic */ String ARy;

        C3116338(String str, String str2) {
            this.ARB = str;
            this.ARy = str2;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(85166);
            C31513c c31513c = C31513c.this;
            String str = this.ARB;
            String str2 = this.ARy;
            C41142o.m71574iK(str, str2);
            String[] split = str2.split("\\.");
            if (split.length == 2) {
                c31513c.ARb.loadUrl("file://" + split[0] + "/main.html");
            }
            c31513c.ARh.setVisibility(8);
            AppMethodBeat.m2505o(85166);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$5 */
    class C311645 implements OnClickListener {
        C311645() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85126);
            XWalkEnvironment.clearAllVersion(C31513c.this.AMr);
            AppMethodBeat.m2505o(85126);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$7 */
    class C311657 implements OnClickListener {
        C311657() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85128);
            C31513c.this.mo51462rD(true);
            AppMethodBeat.m2505o(85128);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$a */
    static class C31166a extends UpdateConfig {
        String ARF;

        public C31166a(String str, String str2) {
            int i = 100000;
            int availableVersion = XWalkEnvironment.getAvailableVersion();
            if (availableVersion >= 100000) {
                i = availableVersion + 1;
            }
            this(i);
            AppMethodBeat.m2504i(85175);
            this.ARF = str;
            this.isMatchMd5 = false;
            this.isPatchUpdate = false;
            this.versionDetail = "local:".concat(String.valueOf(str2));
            AppMethodBeat.m2505o(85175);
        }

        public final boolean checkValid() {
            return true;
        }

        private C31166a(int i) {
            super(null, false, i);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$1 */
    class C315141 implements OnClickListener {

        /* renamed from: com.tencent.xweb.xwalk.c$1$1 */
        class C311561 implements DialogInterface.OnClickListener {
            C311561() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: com.tencent.xweb.xwalk.c$1$2 */
        class C315152 implements DialogInterface.OnClickListener {
            C315152() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(85121);
                C31513c c31513c = C31513c.this;
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH_mm_ss");
                String str = Environment.getExternalStorageDirectory().getPath() + "/xweb_dump/" + simpleDateFormat.format(date);
                c31513c.ARb.savePage(str + "/main.html", str + "/resource", 1);
                new Thread(new C3153640(str)).start();
                AppMethodBeat.m2505o(85121);
            }
        }

        C315141() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85122);
            new Builder(C31513c.this.AMr).setTitle("保存页面").setMessage("确定保存页面？").setPositiveButton("确定", new C315152()).setNegativeButton("取消", new C311561()).show();
            AppMethodBeat.m2505o(85122);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$22 */
    class C3151722 implements OnClickListener {
        C3151722() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85143);
            XWalkEnvironment.setGrayValueForTest(1);
            if (XWalkEnvironment.hasAvailableVersion()) {
                C31146m.dTZ().mo50905a("tools", C44570d.WV_KIND_CW);
                C31146m.dTZ().mo50905a("toolsmp", C44570d.WV_KIND_CW);
                C31146m.dTZ().mo50905a("appbrand", C44570d.WV_KIND_CW);
                C31146m.dTZ().mo50905a("support", C44570d.WV_KIND_CW);
                C31146m.dTZ().mo50905a("mm", C44570d.WV_KIND_CW);
                C31513c.this.mo51454ct("已使用XWeb，点任意位置重启进程生效\n", true);
                AppMethodBeat.m2505o(85143);
            } else if (XWalkEnvironment.isIaDevice()) {
                C31513c.this.avh("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml&check_xwalk_update");
                AppMethodBeat.m2505o(85143);
            } else {
                C31513c.this.avh("http://debugxweb.qq.com/?set_web_config=WV_KIND_CW&set_appbrand_config=WV_KIND_CW&set_config_url=https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml&check_xwalk_update");
                AppMethodBeat.m2505o(85143);
            }
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$25 */
    class C3151825 implements OnClickListener {
        C3151825() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85146);
            C31146m.dTZ().mo50905a("tools", C44570d.WV_KIND_SYS);
            C31146m.dTZ().mo50905a("toolsmp", C44570d.WV_KIND_SYS);
            C31146m.dTZ().mo50905a("appbrand", C44570d.WV_KIND_SYS);
            C31146m.dTZ().mo50905a("support", C44570d.WV_KIND_SYS);
            C31146m.dTZ().mo50905a("mm", C44570d.WV_KIND_SYS);
            C31513c.this.mo51454ct("已使用system，点任意位置重启进程生效\n", true);
            AppMethodBeat.m2505o(85146);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$28 */
    class C3151928 implements OnClickListener {
        C3151928() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85149);
            boolean z = !C31146m.dTZ().AMw;
            C31146m.dTZ().mo50909rx(z);
            if (z) {
                C31513c.this.dVB();
                C31513c.this.ARg.setVisibility(0);
                AppMethodBeat.m2505o(85149);
                return;
            }
            if (C31513c.this.ARg != null) {
                C31513c.this.ARg.setVisibility(8);
            }
            AppMethodBeat.m2505o(85149);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$2 */
    class C315202 implements RadioGroup.OnCheckedChangeListener {
        C315202() {
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            AppMethodBeat.m2504i(85123);
            C36587a c36587a = C36587a.RT_TYPE_AUTO;
            if (i == 2131823221) {
                c36587a = C36587a.RT_TYPE_AUTO;
            } else if (i == 2131823223) {
                c36587a = C36587a.RT_TYPE_SYS;
            } else if (i == 2131823224) {
                c36587a = C36587a.RT_TYPE_X5;
            } else if (i == 2131823222) {
                c36587a = C36587a.RT_TYPE_NATIVE_SCRIPT;
            } else if (i == 2131823225) {
                c36587a = C36587a.RT_TYPE_MMV8;
            }
            C31146m.dTZ().mo50904a(c36587a);
            Log.m81045d("WebDebugPage", "v8 type change to=".concat(String.valueOf(c36587a)));
            AppMethodBeat.m2505o(85123);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$15 */
    class C3152115 implements OnClickListener {
        C3152115() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85136);
            for (C24550c SD : C36602e.dVQ()) {
                SD.mo41307SD(-1);
            }
            String pluginBaseDir = XWalkEnvironment.getPluginBaseDir();
            if (pluginBaseDir.isEmpty()) {
                AppMethodBeat.m2505o(85136);
                return;
            }
            C41131b.avl(pluginBaseDir);
            C31513c.this.aAe();
            AppMethodBeat.m2505o(85136);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$17 */
    class C3152217 implements OnClickListener {
        C3152217() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85138);
            C31513c.m51002a(C31513c.this, XWalkEnvironment.XWALK_PLUGIN_NAME_FILE_READER);
            AppMethodBeat.m2505o(85138);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$29 */
    class C3152429 implements OnClickListener {
        C3152429() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85150);
            C31513c c31513c = C31513c.this;
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory == null) {
                c31513c.mo51453cs("请确认应用权限，在权限管理打开应用的读写存储权限", true);
                AppMethodBeat.m2505o(85150);
            } else if (externalStorageDirectory.listFiles() == null) {
                c31513c.mo51453cs("请确认应用权限，在权限管理打开应用的读写存储权限", true);
                AppMethodBeat.m2505o(85150);
            } else {
                String str = externalStorageDirectory.getPath() + "/xweb_dump";
                try {
                    File[] listFiles = new File(str).listFiles();
                    if (listFiles == null || listFiles.length == 0) {
                        c31513c.mo51453cs("web_dump目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
                        AppMethodBeat.m2505o(85150);
                        return;
                    }
                    for (int i = 0; i < listFiles.length; i++) {
                        if (listFiles[i].getName().endsWith(".zip")) {
                            String absolutePath = listFiles[i].getAbsolutePath();
                            new Builder(c31513c.AMr).setTitle("提示").setMessage("确定加载:" + listFiles[i].getName() + "?").setPositiveButton("确定", new C3116338(str, absolutePath)).setNegativeButton("取消", new C2456037()).show();
                            AppMethodBeat.m2505o(85150);
                            return;
                        }
                    }
                    c31513c.mo51453cs("web_dump目录下没有.zip文件", true);
                    AppMethodBeat.m2505o(85150);
                } catch (Exception e) {
                    c31513c.mo51453cs("没有找到web_dump目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
                    AppMethodBeat.m2505o(85150);
                }
            }
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$33 */
    class C3152533 extends AsyncTask<Void, Void, Boolean> {
        final /* synthetic */ String ARw;
        private ProgressDialog nBv = null;

        /* renamed from: com.tencent.xweb.xwalk.c$33$1 */
        class C311621 implements DialogInterface.OnClickListener {
            C311621() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(85159);
                C3152533.this.nBv.hide();
                AppMethodBeat.m2505o(85159);
            }
        }

        /* renamed from: com.tencent.xweb.xwalk.c$33$2 */
        class C315262 implements DialogInterface.OnClickListener {
            C315262() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(85160);
                C31513c.this.aAe();
                AppMethodBeat.m2505o(85160);
            }
        }

        C3152533(String str) {
            this.ARw = str;
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ void onPostExecute(Object obj) {
            AppMethodBeat.m2504i(85162);
            if (((Boolean) obj).booleanValue()) {
                C31513c.m51003a(C31513c.this, "", C31140a.XWEB);
                this.nBv.setMessage("安装完成，默认开启，请重启进程");
                this.nBv.getButton(-1).setVisibility(0);
                AppMethodBeat.m2505o(85162);
                return;
            }
            this.nBv.setMessage("安装失败");
            this.nBv.getButton(-2).setVisibility(0);
            AppMethodBeat.m2505o(85162);
        }

        /* Access modifiers changed, original: protected|final */
        public final void onPreExecute() {
            AppMethodBeat.m2504i(85161);
            this.nBv = new ProgressDialog(C31513c.this.AMr);
            this.nBv.setProgressStyle(0);
            this.nBv.setMessage("安装中");
            this.nBv.setCancelable(false);
            this.nBv.setCanceledOnTouchOutside(false);
            this.nBv.setButton(-2, "取消", new C311621());
            this.nBv.setButton(-1, "重启", new C315262());
            this.nBv.show();
            this.nBv.getButton(-2).setVisibility(8);
            this.nBv.getButton(-1).setVisibility(8);
            AppMethodBeat.m2505o(85161);
        }

        /* Access modifiers changed, original: protected|final|synthetic */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            AppMethodBeat.m2504i(85163);
            Boolean valueOf = Boolean.valueOf(C31513c.avs(this.ARw));
            AppMethodBeat.m2505o(85163);
            return valueOf;
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$35 */
    class C3152735 implements DialogInterface.OnClickListener {
        C3152735() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$16 */
    class C3152916 implements OnClickListener {
        C3152916() {
        }

        public final void onClick(View view) {
            int i = 100000;
            AppMethodBeat.m2504i(85137);
            C31513c c31513c = C31513c.this;
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory == null) {
                c31513c.mo51453cs("请确认应用权限，在权限管理打开应用的读写存储权限", true);
                AppMethodBeat.m2505o(85137);
            } else if (externalStorageDirectory.listFiles() == null) {
                c31513c.mo51453cs("请确认应用权限，在权限管理打开应用的读写存储权限", true);
                AppMethodBeat.m2505o(85137);
            } else {
                C24550c avu = C36602e.avu(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO);
                if (avu == null) {
                    c31513c.mo51453cs("插件未准备好", true);
                    AppMethodBeat.m2505o(85137);
                    return;
                }
                if (avu.ASG >= 100000) {
                    i = avu.ASG + 1;
                }
                File file = new File(externalStorageDirectory.getPath() + "/apkxwebtest/xweb_fullscreen_video.js");
                externalStorageDirectory = new File(avu.mo13331aM(i, false));
                if (externalStorageDirectory.exists()) {
                    externalStorageDirectory.delete();
                }
                if (C41131b.m71563m(file, externalStorageDirectory)) {
                    avu.mo41307SD(i);
                    new Builder(c31513c.AMr).setMessage("加载成功，请重启进程").setCancelable(false).setPositiveButton("确定", new C3116132()).create().show();
                    AppMethodBeat.m2505o(85137);
                    return;
                }
                c31513c.mo51453cs("加载失败，请检查文件是否存在", true);
                AppMethodBeat.m2505o(85137);
            }
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$34 */
    class C3153034 implements OnClickListener {
        C3153034() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85164);
            C31513c.this.ARh.setVisibility(8);
            AppMethodBeat.m2505o(85164);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$46 */
    class C3153246 implements RadioGroup.OnCheckedChangeListener {
        C3153246() {
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i) {
            AppMethodBeat.m2504i(85174);
            if (C31513c.this.ARi) {
                AppMethodBeat.m2505o(85174);
                return;
            }
            C44570d c44570d = C44570d.WV_KIND_NONE;
            if (i == 2131823216) {
                c44570d = C44570d.WV_KIND_NONE;
            } else if (i == 2131823217) {
                c44570d = C44570d.WV_KIND_CW;
            } else if (i == 2131823219) {
                c44570d = C44570d.WV_KIND_X5;
            } else if (i == 2131823218) {
                c44570d = C44570d.WV_KIND_SYS;
            }
            if (C31513c.this.ARj.equals("all")) {
                String[] stringArray = C31513c.this.AMr.getResources().getStringArray(C25738R.array.f12641aw);
                for (int i2 = 0; i2 < stringArray.length; i2++) {
                    C31146m.dTZ().mo50905a(stringArray[i2], c44570d);
                    Log.m81045d("WebDebugPage", "webview " + stringArray[i2] + " change to=" + c44570d);
                }
                AppMethodBeat.m2505o(85174);
                return;
            }
            C31146m.dTZ().mo50905a(C31513c.this.ARj, c44570d);
            Log.m81045d("WebDebugPage", "webview change to=".concat(String.valueOf(c44570d)));
            AppMethodBeat.m2505o(85174);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$14 */
    class C3153314 implements OnClickListener {
        C3153314() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85135);
            C31513c.m51002a(C31513c.this, XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO);
            AppMethodBeat.m2505o(85135);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$3 */
    class C315353 implements OnClickListener {
        C315353() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(85124);
            C31513c.this.ARh.setVisibility(8);
            C31513c.this.aAe();
            AppMethodBeat.m2505o(85124);
        }
    }

    /* renamed from: com.tencent.xweb.xwalk.c$40 */
    class C3153640 implements Runnable {
        final /* synthetic */ String ARC;

        C3153640(String str) {
            this.ARC = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(85168);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            C41142o.m71573a(new File[]{new File(this.ARC)}, this.ARC + ".zip");
            AppMethodBeat.m2505o(85168);
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m51004b(C31513c c31513c, String str) {
        AppMethodBeat.m2504i(85207);
        c31513c.avr(str);
        AppMethodBeat.m2505o(85207);
    }

    public C31513c(WebView webView) {
        AppMethodBeat.m2504i(85182);
        this.AMr = webView.getContext();
        this.ARb = webView;
        dVD();
        dVB();
        AppMethodBeat.m2505o(85182);
    }

    public final void dUl() {
        AppMethodBeat.m2504i(85183);
        if (C31146m.dTZ().AMt) {
            mo51451a(C31146m.dTZ().AMt, null, false);
        }
        AppMethodBeat.m2505o(85183);
    }

    /* JADX WARNING: Removed duplicated region for block: B:96:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x024b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean avh(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(85184);
        if (str == null) {
            AppMethodBeat.m2505o(85184);
            return false;
        }
        boolean z2;
        if (str.contains("debugmm.qq.com") || str.contains("debugxweb.qq.com")) {
            Uri parse = Uri.parse(str);
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames != null && queryParameterNames.size() > 0) {
                String queryParameter;
                int i;
                boolean i2;
                int lastIndexOf;
                z2 = false;
                for (String queryParameter2 : queryParameterNames) {
                    if (queryParameter2 != null) {
                        switch (queryParameter2.hashCode()) {
                            case -1767214708:
                                if (queryParameter2.equals("encrpt_url")) {
                                    i2 = 4;
                                    break;
                                }
                            case -873960692:
                                if (queryParameter2.equals("ticket")) {
                                    i2 = 2;
                                    break;
                                }
                            case -677737752:
                                if (queryParameter2.equals("forcex5")) {
                                    i2 = 0;
                                    break;
                                }
                            case -82035977:
                                if (queryParameter2.equals("inspector")) {
                                    i2 = true;
                                    break;
                                }
                            case 624401059:
                                if (queryParameter2.equals("show_x5_ver")) {
                                    i2 = 3;
                                    break;
                                }
                            default:
                                i2 = -1;
                                break;
                        }
                        switch (i2) {
                            case 0:
                                if (parse.getBooleanQueryParameter("forcex5", false)) {
                                    C31146m.dTZ().mo50905a("tools", C44570d.WV_KIND_X5);
                                    C31146m.dTZ().mo50905a("appbrand", C44570d.WV_KIND_X5);
                                    C31146m.dTZ().mo50905a("support", C44570d.WV_KIND_X5);
                                    C31146m.dTZ().mo50905a("mm", C44570d.WV_KIND_X5);
                                    C31146m.dTZ().mo50905a("toolsmp", C44570d.WV_KIND_X5);
                                    C31146m.dTZ().mo50904a(C36587a.RT_TYPE_X5);
                                    mo51454ct("force use x5 switch is on ", true);
                                } else {
                                    C31146m.dTZ().mo50905a("tools", C44570d.WV_KIND_NONE);
                                    C31146m.dTZ().mo50905a("appbrand", C44570d.WV_KIND_NONE);
                                    C31146m.dTZ().mo50905a("support", C44570d.WV_KIND_NONE);
                                    C31146m.dTZ().mo50905a("mm", C44570d.WV_KIND_NONE);
                                    C31146m.dTZ().mo50905a("toolsmp", C44570d.WV_KIND_NONE);
                                    C31146m.dTZ().mo50904a(C36587a.RT_TYPE_AUTO);
                                    mo51454ct("force use x5 switch is off ", true);
                                }
                                AppMethodBeat.m2505o(85184);
                                return true;
                            case 1:
                                i2 = parse.getBooleanQueryParameter("inspector", false);
                                C31146m.dTZ().mo50908rw(i2);
                                mo51451a(i2, null, true);
                                AppMethodBeat.m2505o(85184);
                                return true;
                            case 2:
                                queryParameter2 = parse.getQueryParameter("ticket");
                                String uri = parse.toString();
                                if (TextUtils.isEmpty(uri) || TextUtils.isEmpty(queryParameter2)) {
                                    i2 = false;
                                } else {
                                    uri = uri.trim();
                                    lastIndexOf = uri.lastIndexOf("ticket");
                                    if (lastIndexOf < 0 || lastIndexOf >= uri.length()) {
                                        i2 = false;
                                    } else {
                                        i2 = queryParameter2.equalsIgnoreCase(C31513c.aaV((uri.substring(0, lastIndexOf) + "@check_permission@" + new SimpleDateFormat("yyyyMMdd").format(new Date())).toLowerCase()));
                                    }
                                }
                                if (!i2) {
                                    mo51453cs("权限校验失败", true);
                                    Log.m81046e("WebDebugPage", "checkTempPerssion failed");
                                    z2 = i2;
                                    break;
                                }
                                Log.m81049i("WebDebugPage", "checkTempPerssion suc");
                                z2 = i2;
                                break;
                                break;
                            case 3:
                                i2 = parse.getBooleanQueryParameter("show_x5_ver", false);
                                C31146m dTZ = C31146m.dTZ();
                                if (i2 != dTZ.AMv) {
                                    dTZ.AMv = i2;
                                    dTZ.AMr.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowX5Version", dTZ.AMv).commit();
                                }
                                if (i2) {
                                    mo51453cs("开启显示x5内核信息", true);
                                } else {
                                    mo51453cs("关闭显示x5内核信息", true);
                                }
                                AppMethodBeat.m2505o(85184);
                                return true;
                            case 4:
                                try {
                                    queryParameter2 = C41130a.m71557a(parse.getQueryParameter("encrpt_url"), C41130a.avj("b01d4598de5875eb9b86abdef32b811e9c55edcfb1673b5617cc0a6ab7dceaff"));
                                    if (TextUtils.isEmpty(queryParameter2)) {
                                        mo51453cs("解密失败", true);
                                        AppMethodBeat.m2505o(85184);
                                        return true;
                                    }
                                    avh(queryParameter2);
                                    AppMethodBeat.m2505o(85184);
                                    return true;
                                } catch (Throwable th) {
                                    mo51453cs("解密失败", true);
                                }
                            default:
                                break;
                        }
                    }
                }
                if (str.contains("public.debugxweb.qq.com")) {
                    int i3;
                    boolean z3;
                    int i4 = (C31146m.dTZ().AMr.getSharedPreferences("wcwebview", 4).getBoolean("m_bEnableLocalDebug", false) || z2) ? true : 0;
                    if (str.contains("debugxweb.qq.com") || z2) {
                        Uri parse2 = Uri.parse(str);
                        queryParameterNames = parse2.getQueryParameterNames();
                        if (queryParameterNames == null || queryParameterNames.size() == 0) {
                            if (i4 != 0) {
                                dVF();
                            }
                            AppMethodBeat.m2505o(85184);
                            return true;
                        }
                        i3 = 0;
                        lastIndexOf = 0;
                        for (String queryParameter22 : queryParameterNames) {
                            if (queryParameter22 != null) {
                                switch (queryParameter22.hashCode()) {
                                    case -1258153200:
                                        if (queryParameter22.equals("clear_cache")) {
                                            i2 = 6;
                                            break;
                                        }
                                    case -844092179:
                                        if (queryParameter22.equals("fix_dex")) {
                                            i2 = 8;
                                            break;
                                        }
                                    case -604633792:
                                        if (queryParameter22.equals("kill_all")) {
                                            i2 = 3;
                                            break;
                                        }
                                    case -82035977:
                                        if (queryParameter22.equals("inspector")) {
                                            i2 = 0;
                                            break;
                                        }
                                    case 176290201:
                                        if (queryParameter22.equals("clear_old_ver")) {
                                            i2 = 7;
                                            break;
                                        }
                                    case 184008721:
                                        if (queryParameter22.equals("save_page")) {
                                            i2 = 5;
                                            break;
                                        }
                                    case 386281809:
                                        if (queryParameter22.equals("set_grayvalue")) {
                                            i2 = 2;
                                            break;
                                        }
                                    case 724449292:
                                        if (queryParameter22.equals("use_testconfig")) {
                                            i2 = true;
                                            break;
                                        }
                                    case 971862549:
                                        if (queryParameter22.equals("ignore_crashwatch")) {
                                            i2 = 4;
                                            break;
                                        }
                                    default:
                                        i2 = -1;
                                        break;
                                }
                                switch (i2) {
                                    case 0:
                                        i2 = parse2.getBooleanQueryParameter("inspector", false);
                                        C31146m.dTZ().mo50908rw(i2);
                                        mo51451a(i2, null, true);
                                        lastIndexOf = true;
                                        break;
                                    case 1:
                                        i2 = parse2.getBooleanQueryParameter("use_testconfig", false);
                                        C31146m.dTZ().mo50910ry(i2);
                                        if (i2) {
                                            mo51453cs("使用测试config", true);
                                        } else {
                                            mo51453cs("使用正式config", true);
                                        }
                                        lastIndexOf = true;
                                        break;
                                    case 2:
                                        try {
                                            i2 = Integer.parseInt(parse2.getQueryParameter("set_grayvalue"));
                                            XWalkEnvironment.setGrayValueForTest(i2);
                                            mo51453cs("灰度值设为" + (i2 % Downloads.MIN_WAIT_FOR_NETWORK), true);
                                            lastIndexOf = true;
                                            break;
                                        } catch (Exception e) {
                                            mo51453cs("灰度值设置失败，参数解析错误", true);
                                            lastIndexOf = true;
                                            break;
                                        }
                                    case 3:
                                        i3 = true;
                                        lastIndexOf = true;
                                        break;
                                    case 4:
                                        i2 = parse2.getBooleanQueryParameter("ignore_crashwatch", false);
                                        C31146m dTZ2 = C31146m.dTZ();
                                        dTZ2.AMz = i2;
                                        dTZ2.AMr.getSharedPreferences("wcwebview", 0).edit().putBoolean("ignore_crashwatch", i2).commit();
                                        mo51453cs("忽略crash检测设为 = ".concat(String.valueOf(i2)), true);
                                        break;
                                    case 5:
                                        i2 = !C31146m.dTZ().AMw;
                                        C31146m.dTZ().mo50909rx(i2);
                                        if (!i2) {
                                            if (this.ARg == null) {
                                                break;
                                            }
                                            this.ARg.setVisibility(8);
                                            break;
                                        }
                                        dVB();
                                        this.ARg.setVisibility(0);
                                        break;
                                    case 6:
                                        C16403w.clearAllWebViewCache(XWalkEnvironment.getApplicationContext(), true);
                                        mo51453cs("网页cache已经清理:", true);
                                        break;
                                    case 7:
                                        C46946n.m89791E(XWalkEnvironment.getApplicationContext(), true);
                                        mo51453cs("旧版本已经清理", true);
                                        break;
                                    case 8:
                                        C46946n.dVL();
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        i2 = lastIndexOf;
                    } else {
                        i3 = 0;
                        i2 = false;
                    }
                    if (i4 != 0) {
                        if (m51005cr(str, z2) || i2) {
                            z = true;
                        }
                        z3 = z;
                    } else {
                        z3 = i2;
                    }
                    if (i3 != 0) {
                        aAe();
                    }
                    AppMethodBeat.m2505o(85184);
                    return z3;
                }
                Uri parse3 = Uri.parse(str);
                queryParameterNames = parse3.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String queryParameter222 : queryParameterNames) {
                        if (queryParameter222 != null) {
                            switch (queryParameter222.hashCode()) {
                                case -1157057597:
                                    if (queryParameter222.equals("enable_local_debug")) {
                                        i2 = 0;
                                        break;
                                    }
                                default:
                                    i2 = -1;
                                    break;
                            }
                            switch (i2) {
                                case 0:
                                    C31146m.dTZ().AMr.getSharedPreferences("wcwebview", 4).edit().putBoolean("m_bEnableLocalDebug", parse3.getBooleanQueryParameter("enable_local_debug", false)).commit();
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(85184);
                return true;
            }
        }
        z2 = false;
        if (str.contains("public.debugxweb.qq.com")) {
        }
    }

    private static String aaV(String str) {
        AppMethodBeat.m2504i(85185);
        String str2;
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            if (digest == null || digest.length == 0) {
                str2 = "";
                AppMethodBeat.m2505o(85185);
                return str2;
            }
            StringBuilder stringBuilder = new StringBuilder(digest.length);
            for (byte b : digest) {
                String toHexString = Integer.toHexString(b & 255);
                if (toHexString.length() == 1) {
                    stringBuilder.append(0);
                }
                stringBuilder.append(toHexString);
            }
            str2 = stringBuilder.toString().toUpperCase();
            AppMethodBeat.m2505o(85185);
            return str2;
        } catch (Exception e) {
            str2 = "";
            AppMethodBeat.m2505o(85185);
            return str2;
        }
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: cr */
    private boolean m51005cr(String str, boolean z) {
        AppMethodBeat.m2504i(85186);
        if (str.contains("debugxweb.qq.com") || z) {
            Uri parse = Uri.parse(str);
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames == null || queryParameterNames.size() == 0) {
                dVF();
                AppMethodBeat.m2505o(85186);
                return true;
            }
            for (String str2 : queryParameterNames) {
                String str22;
                if (str22 != null) {
                    int i;
                    boolean i2;
                    switch (str22.hashCode()) {
                        case -1688684924:
                            if (str22.equals("set_apkver")) {
                                i2 = 9;
                                break;
                            }
                        case -1479708147:
                            if (str22.equals("set_config_peroid")) {
                                i2 = 13;
                                break;
                            }
                        case -1302829141:
                            if (str22.equals("wait_debugger")) {
                                i2 = 7;
                                break;
                            }
                        case -974615216:
                            if (str22.equals("show_webview_version")) {
                                i2 = 3;
                                break;
                            }
                        case -939528941:
                            if (str22.equals("revert_to_apk")) {
                                i2 = 12;
                                break;
                            }
                        case -748036674:
                            if (str22.equals("set_appbrand_config")) {
                                i2 = 2;
                                break;
                            }
                        case -83404669:
                            if (str22.equals("debug_process")) {
                                i2 = 8;
                                break;
                            }
                        case 208243139:
                            if (str22.equals("recheck_cmds")) {
                                i2 = 14;
                                break;
                            }
                        case 368659514:
                            if (str22.equals("clear_commands")) {
                                i2 = 4;
                                break;
                            }
                        case 603805332:
                            if (str22.equals("load_local_xwalk")) {
                                i2 = false;
                                break;
                            }
                        case 684429537:
                            if (str22.equals("set_plugin_config_url")) {
                                i2 = 11;
                                break;
                            }
                        case 989541982:
                            if (str22.equals("check_xwalk_update")) {
                                i2 = 6;
                                break;
                            }
                        case 1098980480:
                            if (str22.equals("check_files")) {
                                i2 = 10;
                                break;
                            }
                        case 1874228874:
                            if (str22.equals("set_web_config")) {
                                i2 = true;
                                break;
                            }
                        case 2135256815:
                            if (str22.equals("set_config_url")) {
                                i2 = 5;
                                break;
                            }
                        default:
                            i2 = -1;
                            break;
                    }
                    C44570d valueOf;
                    switch (i2) {
                        case 0:
                            mo51462rD(false);
                            break;
                        case 1:
                            try {
                                valueOf = C44570d.valueOf(parse.getQueryParameter("set_web_config"));
                                C31146m.dTZ().mo50905a("tools", valueOf);
                                C31146m.dTZ().mo50905a("toolsmp", valueOf);
                                mo51453cs("打开网页将使用:".concat(String.valueOf(valueOf)), true);
                                break;
                            } catch (Exception e) {
                                break;
                            }
                        case 2:
                            try {
                                valueOf = C44570d.valueOf(parse.getQueryParameter("set_appbrand_config"));
                                C31146m.dTZ().mo50905a("appbrand", valueOf);
                                C31146m.dTZ().mo50905a("support", valueOf);
                                switch (valueOf) {
                                    case WV_KIND_CW:
                                        C31146m.dTZ().mo50904a(C36587a.RT_TYPE_MMV8);
                                        mo51453cs("打开小程序将使用:".concat(String.valueOf(valueOf)), true);
                                        break;
                                    case WV_KIND_X5:
                                        C31146m.dTZ().mo50904a(C36587a.RT_TYPE_X5);
                                        mo51453cs("打开小程序将使用:".concat(String.valueOf(valueOf)), true);
                                        break;
                                    case WV_KIND_SYS:
                                        C31146m.dTZ().mo50904a(C36587a.RT_TYPE_MMV8);
                                        mo51453cs("打开小程序将使用:".concat(String.valueOf(valueOf)), true);
                                        break;
                                    default:
                                        break;
                                }
                            } catch (Exception e2) {
                                break;
                            }
                        case 3:
                            if (this.ARf != null) {
                                break;
                            }
                            ScrollView scrollView = new ScrollView(this.AMr);
                            this.ARf = new TextView(this.AMr);
                            this.ARf.setBackgroundColor(-1);
                            scrollView.addView(this.ARf);
                            this.ARf.setOnClickListener(new C3115712());
                            dVC();
                            this.ARb.getTopView().addView(scrollView);
                            break;
                        case 4:
                            C44572a.m80956a(null, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            break;
                        case 5:
                            try {
                                str22 = parse.getQueryParameter("set_config_url");
                                XWalkEnvironment.setTestDownLoadUrl(this.AMr, str22);
                                mo51453cs("测试连接设置为:".concat(String.valueOf(str22)), true);
                                break;
                            } catch (Exception e3) {
                                mo51453cs("测试连接设置失败，格式错误", true);
                                break;
                            }
                        case 6:
                            dVH();
                            break;
                        case 7:
                            i2 = parse.getBooleanQueryParameter("wait_debugger", false);
                            C31146m dTZ = C31146m.dTZ();
                            dTZ.AMy = i2;
                            dTZ.AMr.getSharedPreferences("wcwebview", 0).edit().putBoolean("bWaitforDebugger", i2).commit();
                            break;
                        case 8:
                            C31146m.dTZ().AMr.getSharedPreferences("wcwebview", 4).edit().putString("strDebugProcess", parse.getQueryParameter("debug_process")).commit();
                            break;
                        case 9:
                            str22 = parse.getQueryParameter("set_apkver");
                            try {
                                XWalkEnvironment.setAvailableVersion(Integer.parseInt(str22), "1.0.".concat(String.valueOf(str22)));
                                mo51454ct("版本号设置到:" + str22 + " 点击空白处退出重启进程", true);
                                break;
                            } catch (Exception e4) {
                                mo51453cs("设置版本号失败:" + e4.getMessage(), true);
                                break;
                            }
                        case 10:
                            C46946n.m89799rE(true);
                            break;
                        case 11:
                            try {
                                str22 = parse.getQueryParameter("set_plugin_config_url");
                                XWalkEnvironment.setPluginTestConfigUrl(str22);
                                mo51453cs("插件测试连接设置为:".concat(String.valueOf(str22)), true);
                                break;
                            } catch (Exception e5) {
                                mo51453cs("插件测试连接设置失败，格式错误", true);
                                break;
                            }
                        case 12:
                            try {
                                mo51454ct("版本号回滚到:" + C46946n.m89796aE(XWalkEnvironment.getApplicationContext(), Integer.parseInt(parse.getQueryParameter("revert_to_apk"))) + " 点击空白处退出重启进程", true);
                                break;
                            } catch (Exception e42) {
                                mo51453cs("版本号回滚到失败:" + e42.getMessage(), true);
                                break;
                            }
                        case 13:
                            str22 = parse.getQueryParameter("set_config_peroid");
                            try {
                                C44572a.m80955Sv(Integer.parseInt(str22));
                                mo51454ct("设置配置拉取周期为:" + str22 + "分钟", false);
                                break;
                            } catch (Exception e422) {
                                mo51453cs("设置配置拉取周期失败:" + e422.getMessage(), true);
                                break;
                            }
                        case 14:
                            C44581k.m80968f(C44570d.WV_KIND_CW).excute("STR_CMD_SET_RECHECK_COMMAND", null);
                            mo51454ct("重新跑了一遍命令配置 点击空白处退出重启进程", true);
                            break;
                        default:
                            break;
                    }
                }
            }
            AppMethodBeat.m2505o(85186);
            return true;
        }
        AppMethodBeat.m2505o(85186);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void dVB() {
        AppMethodBeat.m2504i(85187);
        if (!C31146m.dTZ().AMw) {
            AppMethodBeat.m2505o(85187);
        } else if (this.ARg != null) {
            AppMethodBeat.m2505o(85187);
        } else {
            this.ARg = new Button(this.AMr);
            this.ARg.setText("保存页面");
            this.ARg.setOnClickListener(new C315141());
            this.ARb.getTopView().addView(this.ARg);
            AppMethodBeat.m2505o(85187);
        }
    }

    /* Access modifiers changed, original: final */
    public final void dVC() {
        AppMethodBeat.m2504i(85188);
        if (this.ARf == null) {
            AppMethodBeat.m2505o(85188);
            return;
        }
        String xWalkUpdateConfigUrl = XWalkEnvironment.getXWalkUpdateConfigUrl();
        String str = "\n\n" + this.ARb.getAbstractInfo();
        if (WebView.getCurWebType() != C44570d.WV_KIND_CW) {
            str = str + "\n xwebsdk is = 190301 apk ver is " + XWalkEnvironment.getAvailableVersion();
        }
        StringBuilder append = new StringBuilder().append(str).append("\n\n current js engine: =  ").append(C41128i.dTU()).append("\n prefered js engine =  ").append(C41128i.m71556a(C36587a.RT_TYPE_AUTO, "appbrand", this.AMr)).append("\n isWaitingForUpdate = ");
        C41136c.dVV();
        CharSequence stringBuilder = append.append(C41136c.dVW()).append("\n local gray value = ").append(XWalkEnvironment.getGrayValue()).append("\n config url = ").append(xWalkUpdateConfigUrl).append("\n config period(minutes) = ").append(C41136c.dWb() / 60000).append("\n\n apilevel = ").append(VERSION.SDK_INT).append("\n device is  ").append(Build.BRAND).append(" ").append(Build.MODEL).append("\n usertype is ").append(XWalkEnvironment.getUserType()).toString();
        xWalkUpdateConfigUrl = C44572a.getAbstractInfo();
        if (!(xWalkUpdateConfigUrl == null || xWalkUpdateConfigUrl.isEmpty())) {
            stringBuilder = stringBuilder + "\n\n ------dump commands start:------\n" + xWalkUpdateConfigUrl + "\n ------dump commands end------";
        }
        xWalkUpdateConfigUrl = "";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (C41136c.dVX()) {
                xWalkUpdateConfigUrl = ((((((xWalkUpdateConfigUrl + "going to update to apk ver = " + C41136c.dWd().ATn) + "\n update time is = " + simpleDateFormat.format(new Date(C41136c.dWd().ATv))) + "\n is patch update = " + C41136c.dWd().ATt) + "\n can use cellular = " + C41136c.dWd().ATh) + "\n try count = " + C41136c.dWd().ATx) + "\n try use shared core count = " + C41136c.dWd().ATy) + IOUtils.LINE_SEPARATOR_UNIX;
            }
            xWalkUpdateConfigUrl = xWalkUpdateConfigUrl + " last fetch config time = " + simpleDateFormat.format(new Date(C41136c.dWd().ATs));
        } catch (Exception e) {
        }
        if (!(xWalkUpdateConfigUrl == null || xWalkUpdateConfigUrl.isEmpty())) {
            stringBuilder = stringBuilder + "\n\n ------dump schedule updateInfo start:------\n" + xWalkUpdateConfigUrl + "\n ------dump schedule updateInfo end------";
        }
        xWalkUpdateConfigUrl = XWalkEnvironment.getXWalkInitializeLog();
        if (!(xWalkUpdateConfigUrl == null || xWalkUpdateConfigUrl.isEmpty())) {
            stringBuilder = stringBuilder + "\n\n ------dump xweb log------\n" + xWalkUpdateConfigUrl;
        }
        this.ARf.setText(stringBuilder);
        AppMethodBeat.m2505o(85188);
    }

    /* Access modifiers changed, original: final */
    public final void dVD() {
        AppMethodBeat.m2504i(85189);
        if (!C31146m.dTZ().AMu && (!C31146m.dTZ().AMv || this.ARb.getWebCoreType() != C44570d.WV_KIND_X5)) {
            AppMethodBeat.m2505o(85189);
        } else if (this.ARe != null) {
            AppMethodBeat.m2505o(85189);
        } else {
            this.ARe = new TextView(this.AMr);
            this.ARe.setOnLongClickListener(new C606223());
            dVE();
            this.ARb.getTopView().addView(this.ARe);
            AppMethodBeat.m2505o(85189);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: rC */
    public final String mo51461rC(boolean z) {
        AppMethodBeat.m2504i(85190);
        String versionInfo = this.ARb.getVersionInfo();
        if (z) {
            versionInfo = versionInfo + ", " + C36602e.dVR() + " current process is " + XWalkEnvironment.getProcessName();
        } else {
            int indexOf = versionInfo.indexOf(",apkversion");
            if (indexOf > 0) {
                versionInfo = versionInfo.substring(0, indexOf);
            }
        }
        AppMethodBeat.m2505o(85190);
        return versionInfo;
    }

    private void dVE() {
        AppMethodBeat.m2504i(85191);
        if (this.ARe == null) {
            AppMethodBeat.m2505o(85191);
            return;
        }
        this.ARe.setText(mo51461rC(false));
        AppMethodBeat.m2505o(85191);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: l */
    public final void mo51460l(C44570d c44570d) {
        AppMethodBeat.m2504i(85192);
        switch (c44570d) {
            case WV_KIND_CW:
                ((RadioButton) this.ARh.findViewById(2131823217)).setChecked(true);
                AppMethodBeat.m2505o(85192);
                return;
            case WV_KIND_X5:
                ((RadioButton) this.ARh.findViewById(2131823219)).setChecked(true);
                AppMethodBeat.m2505o(85192);
                return;
            case WV_KIND_SYS:
                ((RadioButton) this.ARh.findViewById(2131823218)).setChecked(true);
                break;
            case WV_KIND_NONE:
                ((RadioButton) this.ARh.findViewById(2131823216)).setChecked(true);
                AppMethodBeat.m2505o(85192);
                return;
        }
        AppMethodBeat.m2505o(85192);
    }

    /* Access modifiers changed, original: final */
    public final boolean dVF() {
        AppMethodBeat.m2504i(85193);
        if (this.ARh != null) {
            this.ARh.setVisibility(0);
            AppMethodBeat.m2505o(85193);
        } else {
            this.ARh = ((LayoutInflater) this.AMr.getSystemService("layout_inflater")).inflate(2130969264, this.ARb.getTopView(), true).findViewById(2131822083);
            ((Button) this.ARh.findViewById(2131823205)).setOnClickListener(new C3153034());
            final CheckBox checkBox = (CheckBox) this.ARh.findViewById(2131823203);
            checkBox.setChecked(C31146m.dTZ().AMu);
            checkBox.setOnCheckedChangeListener(new C2456142());
            ((TextView) this.ARh.findViewById(2131823204)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(85171);
                    checkBox.setChecked(!checkBox.isChecked());
                    AppMethodBeat.m2505o(85171);
                }
            });
            final EditText editText = (EditText) this.ARh.findViewById(2131823226);
            if (editText != null) {
                editText.setInputType(2);
                editText.setText(XWalkEnvironment.getGrayValue());
                editText.addTextChangedListener(new TextWatcher() {
                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void afterTextChanged(Editable editable) {
                        AppMethodBeat.m2504i(85172);
                        int i = 0;
                        try {
                            i = Integer.parseInt(editText.getText().toString());
                        } catch (Exception e) {
                        }
                        XWalkEnvironment.setGrayValueForTest(i);
                        AppMethodBeat.m2505o(85172);
                    }
                });
            }
            ((Spinner) this.ARh.findViewById(2131823214)).setOnItemSelectedListener(new C2456445());
            ((RadioGroup) this.ARh.findViewById(2131823215)).setOnCheckedChangeListener(new C3153246());
            switch (C31146m.dTZ().AMA) {
                case RT_TYPE_AUTO:
                    ((RadioButton) this.ARh.findViewById(2131823221)).setChecked(true);
                    break;
                case RT_TYPE_SYS:
                    ((RadioButton) this.ARh.findViewById(2131823223)).setChecked(true);
                    break;
                case RT_TYPE_X5:
                    ((RadioButton) this.ARh.findViewById(2131823224)).setChecked(true);
                    break;
                case RT_TYPE_NATIVE_SCRIPT:
                    ((RadioButton) this.ARh.findViewById(2131823222)).setChecked(true);
                    break;
                case RT_TYPE_MMV8:
                    ((RadioButton) this.ARh.findViewById(2131823225)).setChecked(true);
                    break;
            }
            ((RadioGroup) this.ARh.findViewById(2131823220)).setOnCheckedChangeListener(new C315202());
            ((Button) this.ARh.findViewById(2131823227)).setOnClickListener(new C315353());
            final Button button = (Button) this.ARh.findViewById(2131823228);
            mo51451a(C31146m.dTZ().AMt, button, false);
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(85125);
                    boolean z = !C31146m.dTZ().AMt;
                    C31146m.dTZ().mo50908rw(z);
                    C31513c.this.mo51451a(z, button, true);
                    AppMethodBeat.m2505o(85125);
                }
            });
            ((Button) this.ARh.findViewById(2131823229)).setOnClickListener(new C311645());
            ((Button) this.ARh.findViewById(2131823247)).setOnClickListener(new C164166());
            ((Button) this.ARh.findViewById(2131823232)).setOnClickListener(new C311657());
            button = (Button) this.ARh.findViewById(2131823230);
            button.setText(C31146m.dTZ().AMB ? "使用正式版config" : "使用测试config");
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(85129);
                    C31146m.dTZ().mo50910ry(!C31146m.dTZ().AMB);
                    button.setText(C31146m.dTZ().AMB ? "使用正式版config" : "使用测试config");
                    AppMethodBeat.m2505o(85129);
                }
            });
            ((Button) this.ARh.findViewById(2131823231)).setOnClickListener(new C164189());
            final LinearLayout linearLayout = (LinearLayout) this.ARh.findViewById(2131823234);
            linearLayout.setVisibility(8);
            Button button2 = (Button) this.ARh.findViewById(2131823233);
            button2.setText("插件设置");
            button2.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(85131);
                    if (linearLayout.getVisibility() == 8) {
                        linearLayout.setVisibility(0);
                        ((Button) view).setText("隐藏插件设置");
                        AppMethodBeat.m2505o(85131);
                        return;
                    }
                    linearLayout.setVisibility(8);
                    ((Button) view).setText("插件设置");
                    AppMethodBeat.m2505o(85131);
                }
            });
            button = (Button) this.ARh.findViewById(2131823235);
            button.setText(XWalkEnvironment.hasPluginTestConfigUrl() ? "切换插件config，当前使用测试版" : "切换插件config，当前使用正式版");
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(85132);
                    if (XWalkEnvironment.hasPluginTestConfigUrl()) {
                        if (XWalkEnvironment.setPluginTestConfigUrl("")) {
                            button.setText("切换插件config，当前使用正式版");
                            AppMethodBeat.m2505o(85132);
                            return;
                        }
                        C31513c.this.mo51453cs("切换失败", true);
                        AppMethodBeat.m2505o(85132);
                    } else if (XWalkEnvironment.setPluginTestConfigUrl(XWalkEnvironment.DOWNLOAD_PLUGIN_UPDATE_TEST_CONFIG_DEFAULT_URL)) {
                        button.setText("切换插件config，当前使用测试版");
                        AppMethodBeat.m2505o(85132);
                    } else {
                        C31513c.this.mo51453cs("切换失败", true);
                        AppMethodBeat.m2505o(85132);
                    }
                }
            });
            ((Button) this.ARh.findViewById(2131823237)).setOnClickListener(new C2455713());
            ((Button) this.ARh.findViewById(2131823238)).setOnClickListener(new C3153314());
            ((Button) this.ARh.findViewById(2131823236)).setOnClickListener(new C3152115());
            ((Button) this.ARh.findViewById(2131823239)).setOnClickListener(new C3152916());
            ((Button) this.ARh.findViewById(2131823240)).setOnClickListener(new C3152217());
            ((Button) this.ARh.findViewById(2131823241)).setOnClickListener(new C3115818());
            ((TextView) this.ARh.findViewById(2131823242)).setText(C31513c.dVG());
            editText = (EditText) this.ARh.findViewById(2131823243);
            ((Button) this.ARh.findViewById(2131823244)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(85140);
                    C31513c.m51003a(C31513c.this, editText.getText().toString(), C31140a.XWEB);
                    AppMethodBeat.m2505o(85140);
                }
            });
            ((Button) this.ARh.findViewById(2131823245)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(85141);
                    C31513c.m51003a(C31513c.this, editText.getText().toString(), C31140a.X5);
                    AppMethodBeat.m2505o(85141);
                }
            });
            ((Button) this.ARh.findViewById(2131823246)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(85142);
                    C31513c.m51003a(C31513c.this, editText.getText().toString(), C31140a.NONE);
                    AppMethodBeat.m2505o(85142);
                }
            });
            ((TextView) this.ARh.findViewById(2131823250)).setText(mo51461rC(true) + IOUtils.LINE_SEPARATOR_UNIX + XWalkInitializer.getXWalkInitializeLog());
            ((LinearLayout) this.ARh.findViewById(2131823212)).setVisibility(8);
            ((Button) this.ARh.findViewById(2131823207)).setOnClickListener(new C3151722());
            ((Button) this.ARh.findViewById(2131823208)).setOnClickListener(new C606324());
            ((Button) this.ARh.findViewById(2131823209)).setOnClickListener(new C3151825());
            ((Button) this.ARh.findViewById(2131823210)).setOnClickListener(new C606426());
            ((Button) this.ARh.findViewById(2131823211)).setOnClickListener(new C606527());
            ((Button) this.ARh.findViewById(2131823248)).setOnClickListener(new C3151928());
            button = (Button) this.ARh.findViewById(2131823249);
            button.setOnClickListener(new C3152429());
            button.setOnLongClickListener(new C1641330());
            AppMethodBeat.m2505o(85193);
        }
        return true;
    }

    private static String dVG() {
        AppMethodBeat.m2504i(85194);
        StringBuilder stringBuilder = new StringBuilder("文件预览服务设置：\n");
        for (String str : C31139d.ALV) {
            stringBuilder.append(str).append(": force-").append(C44572a.avf(C31146m.dTZ().AMr.getSharedPreferences("wcwebview", 4).getString("force_fr_" + str.toLowerCase(), ""))).append("  cmd-").append(C44572a.auX(str)).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(85194);
        return stringBuilder2;
    }

    private void avr(String str) {
        AppMethodBeat.m2504i(85195);
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str2 : list) {
                    avr(str + "//" + str2);
                }
            }
        }
        file.delete();
        AppMethodBeat.m2505o(85195);
    }

    /* Access modifiers changed, original: final */
    public final void dVH() {
        AppMethodBeat.m2504i(85196);
        C44572a.m80956a(null, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
        edit.putLong("nLastFetchConfigTime", 0);
        edit.putBoolean("bCanUseCellular", true);
        edit.putLong("nTimeToUpdate", 100);
        edit.commit();
        C41136c.dWd().ATs = 100;
        C41136c.dWd().ATh = true;
        C41136c.dWd().ATv = 100;
        new C16419b(this.AMr).mo76256s(null);
        AppMethodBeat.m2505o(85196);
    }

    /* renamed from: jB */
    protected static void m51006jB(Context context) {
        AppMethodBeat.m2504i(85198);
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.uid == myUid && runningAppProcessInfo.pid != myPid) {
                String str = runningAppProcessInfo.processName;
                if (str == null || !str.contains("com.tencent.mm") || runningAppProcessInfo.processName.contains("tools") || runningAppProcessInfo.processName.contains("appbrand") || runningAppProcessInfo.processName.contains("support")) {
                    Process.killProcess(runningAppProcessInfo.pid);
                }
            }
        }
        Process.killProcess(myPid);
        AppMethodBeat.m2505o(85198);
    }

    /* renamed from: a */
    public final void mo51451a(boolean z, Button button, boolean z2) {
        AppMethodBeat.m2504i(85199);
        try {
            XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, z);
        } catch (Exception e) {
        }
        try {
            if (VERSION.SDK_INT >= 19) {
                android.webkit.WebView.setWebContentsDebuggingEnabled(z);
            }
        } catch (Exception e2) {
        }
        try {
            com.tencent.smtt.sdk.WebView.setWebContentsDebuggingEnabled(z);
        } catch (Exception e3) {
        }
        if (z2 && this.ARb.getX5WebViewExtension() != null) {
            if (z) {
                this.ARb.loadUrl("http://debugx5.qq.com/?inspector=true");
            } else {
                this.ARb.loadUrl("http://debugx5.qq.com/?inspector=false");
            }
        }
        if (button != null) {
            if (z) {
                button.setText("关闭远程调试模式");
                AppMethodBeat.m2505o(85199);
                return;
            }
            button.setText("打开远程调试模式");
        }
        AppMethodBeat.m2505o(85199);
    }

    public static boolean avs(String str) {
        int i = 99999;
        AppMethodBeat.m2504i(85200);
        C24550c avu = C36602e.avu(XWalkEnvironment.XWALK_PLUGIN_NAME_FILE_READER);
        if (avu == null) {
            AppMethodBeat.m2505o(85200);
            return false;
        }
        try {
            if (avu.ASG >= 99999) {
                i = avu.ASG + 1;
            }
            C6051d c6051d = new C6051d();
            c6051d.version = i;
            c6051d.isPatch = false;
            c6051d.cvZ = C6037d.m9501cz(str);
            c6051d.path = avu.mo13331aM(i, false);
            C41131b.copyFile(str, c6051d.path);
            if (avu.mo13330a(c6051d) == 0) {
                AppMethodBeat.m2505o(85200);
                return true;
            }
            AppMethodBeat.m2505o(85200);
            return false;
        } catch (Exception e) {
            Log.m81046e("WebDebugPage", "loadFileReaderFromLocalInternal error: " + e.getMessage());
            AppMethodBeat.m2505o(85200);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: rD */
    public final void mo51462rD(final boolean z) {
        AppMethodBeat.m2504i(85201);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            mo51453cs("请确认应用权限，在权限管理打开应用的读写存储权限", true);
            AppMethodBeat.m2505o(85201);
        } else if (externalStorageDirectory.listFiles() == null) {
            mo51453cs("请确认应用权限，在权限管理打开应用的读写存储权限", true);
            AppMethodBeat.m2505o(85201);
        } else {
            try {
                File[] listFiles = new File(externalStorageDirectory.getPath() + "/apkxwebtest").listFiles();
                if (listFiles == null || listFiles.length == 0) {
                    mo51453cs("apkxwebtest目录下没有.zip文件,请确认应用权限，在权限管理打开应用的读写存储权限", true);
                    AppMethodBeat.m2505o(85201);
                    return;
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (listFiles[i].getName().endsWith(".zip")) {
                        final String absolutePath = listFiles[i].getAbsolutePath();
                        final String name = listFiles[i].getName();
                        if (z) {
                            new Builder(this.AMr).setTitle("提示").setMessage("确定加载:" + name + "?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(85165);
                                    C31513c.this.mo51450G(absolutePath, name, z);
                                    AppMethodBeat.m2505o(85165);
                                }
                            }).setNegativeButton("取消", new C3152735()).show();
                            AppMethodBeat.m2505o(85201);
                            return;
                        }
                        mo51450G(absolutePath, name, z);
                        AppMethodBeat.m2505o(85201);
                        return;
                    }
                }
                mo51453cs("apkxwebtest目录下没有.zip文件", true);
                AppMethodBeat.m2505o(85201);
            } catch (Exception e) {
                mo51453cs("没有找到apkxwebtest目录,请确认应用权限，在权限管理打开应用的读写存储权限", true);
                AppMethodBeat.m2505o(85201);
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: G */
    public final void mo51450G(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(85202);
        C31166a c31166a = new C31166a(str, str2);
        try {
            File file = new File(XWalkEnvironment.getDownloadZipDir(c31166a.apkVer));
            if (file.exists()) {
                file.delete();
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1048576];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
        }
        try {
            Integer onHandleFile = XWalkUpdater.onHandleFile(c31166a);
            if (onHandleFile.intValue() == 0) {
                mo51453cs("安装" + str2 + "成功", z);
                AppMethodBeat.m2505o(85202);
                return;
            }
            mo51453cs("安装" + str2 + "失败,错误码=" + onHandleFile, true);
            AppMethodBeat.m2505o(85202);
        } catch (Exception e2) {
            mo51453cs("安装失败", true);
            Log.m81046e("WebDebugPage", "install local apk failed : " + e2.getMessage());
            AppMethodBeat.m2505o(85202);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cs */
    public final void mo51453cs(String str, boolean z) {
        AppMethodBeat.m2504i(85203);
        if (z) {
            try {
                Builder builder = new Builder(this.AMr);
                builder.setMessage(str);
                builder.create().show();
                AppMethodBeat.m2505o(85203);
                return;
            } catch (Exception e) {
                Log.m81049i("WebDebugPage", "show alert failed may be in abtets exe " + e.getMessage());
                AppMethodBeat.m2505o(85203);
                return;
            }
        }
        Log.m81046e("WebDebugPage", str);
        AppMethodBeat.m2505o(85203);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ct */
    public final void mo51454ct(String str, boolean z) {
        AppMethodBeat.m2504i(85204);
        try {
            Builder builder = new Builder(this.AMr);
            builder.setMessage(str);
            builder.create();
            builder.setCancelable(true);
            if (z) {
                builder.setOnCancelListener(new C606639());
            }
            builder.show();
            AppMethodBeat.m2505o(85204);
        } catch (Exception e) {
            Log.m81049i("WebDebugPage", "show alert failed may be in abtets exe " + e.getMessage());
            AppMethodBeat.m2505o(85204);
        }
    }

    /* Access modifiers changed, original: final */
    public final void aAe() {
        AppMethodBeat.m2504i(85197);
        C31513c.m51006jB(this.AMr);
        AppMethodBeat.m2505o(85197);
    }

    /* renamed from: a */
    static /* synthetic */ void m51002a(C31513c c31513c, final String str) {
        AppMethodBeat.m2504i(85205);
        final C36603f c36603f = new C36603f();
        C3115931 c3115931 = new C36604a() {
            private ProgressDialog ARs = null;
            boolean mFinished = false;

            /* renamed from: com.tencent.xweb.xwalk.c$31$2 */
            class C245592 implements DialogInterface.OnClickListener {
                C245592() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(85154);
                    C31513c.this.aAe();
                    AppMethodBeat.m2505o(85154);
                }
            }

            /* renamed from: com.tencent.xweb.xwalk.c$31$1 */
            class C311601 implements DialogInterface.OnClickListener {
                C311601() {
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(85153);
                    if (!C3115931.this.mFinished) {
                        C36603f c36603f = c36603f;
                        if (c36603f.ASM != null) {
                            c36603f.ASM.mo58396a(4, -1, null);
                        }
                    }
                    AppMethodBeat.m2505o(85153);
                }
            }

            public final void dVI() {
                AppMethodBeat.m2504i(85155);
                this.ARs = new ProgressDialog(C31513c.this.AMr);
                this.ARs.setProgressStyle(1);
                this.ARs.setMessage("下载更新中");
                this.ARs.setCancelable(false);
                this.ARs.setCanceledOnTouchOutside(false);
                this.ARs.setButton(-2, "取消", new C311601());
                this.ARs.setButton(-1, "重启", new C245592());
                this.ARs.show();
                this.ARs.getButton(-1).setVisibility(8);
                AppMethodBeat.m2505o(85155);
            }

            /* renamed from: Sy */
            public final void mo50916Sy(int i) {
                AppMethodBeat.m2504i(85156);
                if (this.mFinished || this.ARs == null) {
                    AppMethodBeat.m2505o(85156);
                    return;
                }
                this.ARs.setProgress(i);
                AppMethodBeat.m2505o(85156);
            }

            /* renamed from: Sz */
            public final void mo50917Sz(int i) {
                AppMethodBeat.m2504i(85157);
                this.mFinished = true;
                if (this.ARs == null) {
                    AppMethodBeat.m2505o(85157);
                    return;
                }
                switch (i) {
                    case -9:
                        this.ARs.setMessage("更新失败，下载安装出错，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.m2505o(85157);
                        return;
                    case -8:
                        this.ARs.setMessage("更新失败，未找到可用更新，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.m2505o(85157);
                        return;
                    case -7:
                        this.ARs.setMessage("更新失败，配置中未包含插件信息，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.m2505o(85157);
                        return;
                    case -6:
                        this.ARs.setMessage("更新失败，配置解析失败，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.m2505o(85157);
                        return;
                    case -5:
                        this.ARs.setMessage("更新失败，配置下载失败，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.m2505o(85157);
                        return;
                    case -4:
                        this.ARs.setMessage("更新失败，其它任务正在更新插件，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.m2505o(85157);
                        return;
                    case -3:
                        this.ARs.setMessage("更新失败，未到检查时间，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.m2505o(85157);
                        return;
                    case -2:
                        this.ARs.setMessage("更新失败，无网络，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.m2505o(85157);
                        return;
                    case -1:
                        this.ARs.setMessage("更新被取消，ErrCode = ".concat(String.valueOf(i)));
                        Toast.makeText(C31513c.this.AMr, "更新被取消，ErrCode = ".concat(String.valueOf(i)), 0).show();
                        AppMethodBeat.m2505o(85157);
                        return;
                    case 0:
                        if (XWalkEnvironment.XWALK_PLUGIN_NAME_FILE_READER.equalsIgnoreCase(str)) {
                            C31513c.m51003a(C31513c.this, "", C31140a.XWEB);
                        }
                        this.ARs.setMessage("更新完成，请重启进程");
                        this.ARs.setProgress(100);
                        this.ARs.getButton(-2).setVisibility(8);
                        this.ARs.getButton(-1).setVisibility(0);
                        AppMethodBeat.m2505o(85157);
                        return;
                    default:
                        this.ARs.setMessage("更新失败，未知错误，ErrCode = ".concat(String.valueOf(i)));
                        AppMethodBeat.m2505o(85157);
                        return;
                }
            }
        };
        c36603f.ASK = str;
        c36603f.ASL = c3115931;
        HashMap hashMap = new HashMap();
        hashMap.put("UpdaterCheckType", "1");
        c36603f.mo30119a(c31513c.AMr, hashMap);
        AppMethodBeat.m2505o(85205);
    }
}
