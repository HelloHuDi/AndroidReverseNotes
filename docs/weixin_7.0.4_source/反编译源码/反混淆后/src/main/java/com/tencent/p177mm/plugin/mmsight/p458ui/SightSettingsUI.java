package com.tencent.p177mm.plugin.mmsight.p458ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30382d;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.mmsight.ui.SightSettingsUI */
public class SightSettingsUI extends MMActivity {
    private C46607d ext = new C46607d(this);
    private ListView gKd;
    private C12590a oDo;
    private LinkedList<C28526b> oDp = new LinkedList();
    private CaptureMMProxy otb;

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightSettingsUI$a */
    class C12590a extends BaseAdapter {
        C12590a() {
        }

        public final int getCount() {
            AppMethodBeat.m2504i(55282);
            int size = SightSettingsUI.this.oDp.size();
            AppMethodBeat.m2505o(55282);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(55283);
            Object obj = SightSettingsUI.this.oDp.get(i);
            AppMethodBeat.m2505o(55283);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(55284);
            TextView textView = new TextView(SightSettingsUI.this);
            final C28526b c28526b = (C28526b) getItem(i);
            textView.setText(c28526b.oDt + "->:" + c28526b.mo46506zc(((Integer) SightSettingsUI.this.otb.get(c28526b.oDw, Integer.valueOf(0))).intValue()));
            textView.setGravity(17);
            textView.setTextSize(1, 20.0f);
            textView.setHeight(C1338a.fromDPToPix(C4996ah.getContext(), 50));
            if (i % 2 == 1) {
                textView.setBackgroundColor(Color.parseColor("#e2efda"));
            }
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(55281);
                    C28526b c28526b = c28526b;
                    List linkedList = new LinkedList();
                    List linkedList2 = new LinkedList();
                    for (int i = 0; i < c28526b.oDu.length; i++) {
                        linkedList.add(c28526b.oDu[i]);
                        linkedList2.add(Integer.valueOf(i));
                    }
                    C30379h.m48419a(SightSettingsUI.this, "", linkedList, linkedList2, "", new C125921());
                    AppMethodBeat.m2505o(55281);
                }
            });
            AppMethodBeat.m2505o(55284);
            return textView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightSettingsUI$1 */
    class C213171 implements Runnable {
        C213171() {
        }

        public final void run() {
            AppMethodBeat.m2504i(55279);
            C4990ab.m7416i("MicroMsg.SightSettingsUI", "has connect");
            SightSettingsUI.m67268a(SightSettingsUI.this);
            AppMethodBeat.m2505o(55279);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightSettingsUI$b */
    class C28526b {
        public String oDt;
        String[] oDu;
        int[] oDv;
        C5127a oDw;

        /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightSettingsUI$b$1 */
        class C125921 implements C30382d {
            C125921() {
            }

            /* renamed from: bV */
            public final void mo4975bV(int i, int i2) {
                AppMethodBeat.m2504i(55285);
                try {
                    SightSettingsUI.this.otb.set(C28526b.this.oDw, Integer.valueOf(C28526b.this.oDv[i]));
                    SightSettingsUI.this.oDo.notifyDataSetChanged();
                    AppMethodBeat.m2505o(55285);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.SightSettingsUI", e, "", new Object[0]);
                    AppMethodBeat.m2505o(55285);
                }
            }
        }

        public C28526b(String str, C5127a c5127a, String[] strArr, int[] iArr) {
            this.oDt = str;
            this.oDu = strArr;
            this.oDw = c5127a;
            this.oDv = iArr;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: zc */
        public final String mo46506zc(int i) {
            int i2 = 0;
            while (i2 < this.oDv.length) {
                if (i == this.oDv[i2] && i2 < this.oDu.length) {
                    return this.oDu[i2];
                }
                i2++;
            }
            return this.oDu[0];
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.SightSettingsUI$2 */
    class C394112 implements OnMenuItemClickListener {
        C394112() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(55280);
            SightSettingsUI.this.finish();
            AppMethodBeat.m2505o(55280);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SightSettingsUI() {
        AppMethodBeat.m2504i(55286);
        AppMethodBeat.m2505o(55286);
    }

    public final int getLayoutId() {
        return 2130970696;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(55287);
        super.onCreate(bundle);
        this.otb = new CaptureMMProxy(this.ext);
        this.ext.connect(new C213171());
        setBackBtn(new C394112());
        AppMethodBeat.m2505o(55287);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(55288);
        super.onDestroy();
        this.ext.release();
        AppMethodBeat.m2505o(55288);
    }

    public void onResume() {
        AppMethodBeat.m2504i(55289);
        super.onResume();
        AppMethodBeat.m2505o(55289);
    }

    public void onPause() {
        AppMethodBeat.m2504i(55290);
        super.onPause();
        AppMethodBeat.m2505o(55290);
    }

    /* renamed from: a */
    static /* synthetic */ void m67268a(SightSettingsUI sightSettingsUI) {
        AppMethodBeat.m2504i(55291);
        SightSettingsUI sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDp.add(new C28526b("打开测试信息", C5127a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, new String[]{"Y", "N"}, new int[]{1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDp.add(new C28526b("对焦方案", C5127a.USERINFO_LOCAL_SIGHT_FOCUS_INT_SYNC, new String[]{"System", "啊..."}, new int[]{1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDp.add(new C28526b("裁剪方案", C5127a.USERINFO_LOCAL_SIGHT_FFMMPEGCUT_INT_SYNC, new String[]{"default", "mediacodecv21", "mediacodecv", "ffmpeg"}, new int[]{-1, 1, 2, 3}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDp.add(new C28526b("是否把双通音频压成单通道", C5127a.USERINFO_LOCAL_SIGHT_COMPRESS_TO_SINGLE_CHANNEL_INT_SYNC, new String[]{"-1", "yes", "no"}, new int[]{-1, 1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDp.add(new C28526b("Thread", C5127a.USERINFO_LOCAL_SIGHT_THREADCOUNT_INT_SYNC, new String[]{"-1", "1", "2", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "4", "5", "6"}, new int[]{-1, 1, 2, 3, 4, 5, 6}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDp.add(new C28526b("裁剪预览MediaPlayer", C5127a.USERINFO_LOCAL_SIGHT_CLIP_PREVIEW_MEDIA_PLAYER_INT_SYNC, new String[]{"default", "系统方案", "MediaCodec解码播放方案"}, new int[]{-1, 1, 2}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDp.add(new C28526b("音频录制方案", C5127a.USERINFO_LOCAL_SIGHT_AUDIO_RECORDER_TYPE_INT_SYNC, new String[]{"-1", "MediaCodec", "MediaRecorder"}, new int[]{-1, 1, 2}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDp.add(new C28526b("预设配置", C5127a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, new String[]{"跟后台配置", "MediaCodec+540p录制", "MediaCodec+720p双倍码率录制+后期压缩", "FFMpeg+540p录制", "FFMpeg+720p双倍码率录制+后期压缩", "MediaCodec+720p原码率录制", "FFMpeg+720p原码率录制", "MediaCodec+1080p+实时压缩", "MediaCodec+1080p+实时压缩/旋转", "FFMpeg+1080p+实时压缩", "FFMpeg+1080p+实时压缩/旋转", "MediaCodec+1080p双倍码率+后压+实时压缩"}, new int[]{-1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}));
        sightSettingsUI.gKd = (ListView) sightSettingsUI.findViewById(2131821698);
        sightSettingsUI.oDo = new C12590a();
        sightSettingsUI.gKd.setAdapter(sightSettingsUI.oDo);
        AppMethodBeat.m2505o(55291);
    }
}
