package com.tencent.mm.plugin.mmsight.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SightSettingsUI extends MMActivity {
    private d ext = new d(this);
    private ListView gKd;
    private a oDo;
    private LinkedList<b> oDp = new LinkedList();
    private CaptureMMProxy otb;

    class a extends BaseAdapter {
        a() {
        }

        public final int getCount() {
            AppMethodBeat.i(55282);
            int size = SightSettingsUI.this.oDp.size();
            AppMethodBeat.o(55282);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(55283);
            Object obj = SightSettingsUI.this.oDp.get(i);
            AppMethodBeat.o(55283);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(55284);
            TextView textView = new TextView(SightSettingsUI.this);
            final b bVar = (b) getItem(i);
            textView.setText(bVar.oDt + "->:" + bVar.zc(((Integer) SightSettingsUI.this.otb.get(bVar.oDw, Integer.valueOf(0))).intValue()));
            textView.setGravity(17);
            textView.setTextSize(1, 20.0f);
            textView.setHeight(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 50));
            if (i % 2 == 1) {
                textView.setBackgroundColor(Color.parseColor("#e2efda"));
            }
            textView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(55281);
                    b bVar = bVar;
                    List linkedList = new LinkedList();
                    List linkedList2 = new LinkedList();
                    for (int i = 0; i < bVar.oDu.length; i++) {
                        linkedList.add(bVar.oDu[i]);
                        linkedList2.add(Integer.valueOf(i));
                    }
                    h.a(SightSettingsUI.this, "", linkedList, linkedList2, "", new h.d() {
                        public final void bV(int i, int i2) {
                            AppMethodBeat.i(55285);
                            try {
                                SightSettingsUI.this.otb.set(b.this.oDw, Integer.valueOf(b.this.oDv[i]));
                                SightSettingsUI.this.oDo.notifyDataSetChanged();
                                AppMethodBeat.o(55285);
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.SightSettingsUI", e, "", new Object[0]);
                                AppMethodBeat.o(55285);
                            }
                        }
                    });
                    AppMethodBeat.o(55281);
                }
            });
            AppMethodBeat.o(55284);
            return textView;
        }
    }

    class b {
        public String oDt;
        String[] oDu;
        int[] oDv;
        com.tencent.mm.storage.ac.a oDw;

        public b(String str, com.tencent.mm.storage.ac.a aVar, String[] strArr, int[] iArr) {
            this.oDt = str;
            this.oDu = strArr;
            this.oDw = aVar;
            this.oDv = iArr;
        }

        /* Access modifiers changed, original: final */
        public final String zc(int i) {
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

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SightSettingsUI() {
        AppMethodBeat.i(55286);
        AppMethodBeat.o(55286);
    }

    public final int getLayoutId() {
        return R.layout.atg;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(55287);
        super.onCreate(bundle);
        this.otb = new CaptureMMProxy(this.ext);
        this.ext.connect(new Runnable() {
            public final void run() {
                AppMethodBeat.i(55279);
                ab.i("MicroMsg.SightSettingsUI", "has connect");
                SightSettingsUI.a(SightSettingsUI.this);
                AppMethodBeat.o(55279);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(55280);
                SightSettingsUI.this.finish();
                AppMethodBeat.o(55280);
                return false;
            }
        });
        AppMethodBeat.o(55287);
    }

    public void onDestroy() {
        AppMethodBeat.i(55288);
        super.onDestroy();
        this.ext.release();
        AppMethodBeat.o(55288);
    }

    public void onResume() {
        AppMethodBeat.i(55289);
        super.onResume();
        AppMethodBeat.o(55289);
    }

    public void onPause() {
        AppMethodBeat.i(55290);
        super.onPause();
        AppMethodBeat.o(55290);
    }

    static /* synthetic */ void a(SightSettingsUI sightSettingsUI) {
        AppMethodBeat.i(55291);
        SightSettingsUI sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDp.add(new b("打开测试信息", com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, new String[]{"Y", "N"}, new int[]{1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDp.add(new b("对焦方案", com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_FOCUS_INT_SYNC, new String[]{"System", "啊..."}, new int[]{1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDp.add(new b("裁剪方案", com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_FFMMPEGCUT_INT_SYNC, new String[]{"default", "mediacodecv21", "mediacodecv", "ffmpeg"}, new int[]{-1, 1, 2, 3}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDp.add(new b("是否把双通音频压成单通道", com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_COMPRESS_TO_SINGLE_CHANNEL_INT_SYNC, new String[]{"-1", "yes", "no"}, new int[]{-1, 1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDp.add(new b("Thread", com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_THREADCOUNT_INT_SYNC, new String[]{"-1", "1", "2", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "4", "5", "6"}, new int[]{-1, 1, 2, 3, 4, 5, 6}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDp.add(new b("裁剪预览MediaPlayer", com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_CLIP_PREVIEW_MEDIA_PLAYER_INT_SYNC, new String[]{"default", "系统方案", "MediaCodec解码播放方案"}, new int[]{-1, 1, 2}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDp.add(new b("音频录制方案", com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_AUDIO_RECORDER_TYPE_INT_SYNC, new String[]{"-1", "MediaCodec", "MediaRecorder"}, new int[]{-1, 1, 2}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.oDp.add(new b("预设配置", com.tencent.mm.storage.ac.a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, new String[]{"跟后台配置", "MediaCodec+540p录制", "MediaCodec+720p双倍码率录制+后期压缩", "FFMpeg+540p录制", "FFMpeg+720p双倍码率录制+后期压缩", "MediaCodec+720p原码率录制", "FFMpeg+720p原码率录制", "MediaCodec+1080p+实时压缩", "MediaCodec+1080p+实时压缩/旋转", "FFMpeg+1080p+实时压缩", "FFMpeg+1080p+实时压缩/旋转", "MediaCodec+1080p双倍码率+后压+实时压缩"}, new int[]{-1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}));
        sightSettingsUI.gKd = (ListView) sightSettingsUI.findViewById(R.id.a46);
        sightSettingsUI.oDo = new a();
        sightSettingsUI.gKd.setAdapter(sightSettingsUI.oDo);
        AppMethodBeat.o(55291);
    }
}
