package com.tencent.mm.plugin.story.ui;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.g.a.ui;
import com.tencent.mm.media.proxy.MediaEditorProxy;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.story.g.h;
import com.tencent.mm.plugin.story.model.i;
import com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy;
import com.tencent.mm.plugin.story.proxy.StoryCaptureProxy;
import com.tencent.mm.plugin.story.ui.view.CaptureView;
import com.tencent.mm.plugin.story.ui.view.editor.EditorView;
import com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
@l(dWo = {1, 1, 13}, dWp = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005*\u0002\u0012\u0015\b\u0007\u0018\u0000 22\u00020\u0001:\u000223B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0014J\b\u0010\u001a\u001a\u00020\u0010H\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\"\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0018H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0018H\u0014J\b\u0010)\u001a\u00020\u0018H\u0014J+\u0010*\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00102\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010.\u001a\u00020/H\u0016¢\u0006\u0002\u00100J\b\u00101\u001a\u00020\u0018H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0016¨\u00064"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "captureView", "Lcom/tencent/mm/plugin/story/ui/view/CaptureView;", "editorPresenter", "Lcom/tencent/mm/plugin/story/presenter/EditorPresenter;", "editorView", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView;", "isInit", "", "screenDp", "Landroid/graphics/Point;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "status", "", "uiNavigation", "com/tencent/mm/plugin/story/ui/StoryCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$uiNavigation$1;", "voipCallingListener", "com/tencent/mm/plugin/story/ui/StoryCaptureUI$voipCallingListener$1", "Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$voipCallingListener$1;", "doReport", "", "getForceOrientation", "getLayoutId", "initCreate", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "Companion", "UINavigation", "plugin-story_release"})
public final class StoryCaptureUI extends MMActivity {
    public static final a seG = new a();
    private boolean bZi;
    private final com.tencent.mm.remoteservice.d ext = new com.tencent.mm.remoteservice.d(this);
    private Point oCX;
    private CaptureView seB;
    private EditorView seC;
    private com.tencent.mm.plugin.story.f.c seD;
    private final f seE = new f(this);
    private final g seF = new g(this);
    private int status = -1;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "", "exit", "", "go2Capture", "onEditorPrepared", "prepareEditor", "captureInfo", "Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "plugin-story_release"})
    public interface b {
        void b(com.tencent.mm.plugin.story.e.a aVar);

        void bnN();

        void bnO();

        void exit();
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class c implements Runnable {
        final /* synthetic */ StoryCaptureUI seH;

        c(StoryCaptureUI storyCaptureUI) {
            this.seH = storyCaptureUI;
        }

        public final void run() {
            AppMethodBeat.i(110002);
            StoryCaptureUI.a(this.seH);
            AppMethodBeat.o(110002);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$Companion;", "", "()V", "RequestCodeAlbum", "", "RequestCodeLocation", "RequestCodePreview", "STATE_CAPTURE", "STATE_EDIT", "STATE_EDIT_PREPARE", "STATE_NONE", "TAG", "", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class d implements OnClickListener {
        final /* synthetic */ StoryCaptureUI seH;

        d(StoryCaptureUI storyCaptureUI) {
            this.seH = storyCaptureUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(110003);
            this.seH.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            dialogInterface.dismiss();
            AppMethodBeat.o(110003);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class e implements OnClickListener {
        public static final e seI = new e();

        static {
            AppMethodBeat.i(110005);
            AppMethodBeat.o(110005);
        }

        e() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(110004);
            dialogInterface.dismiss();
            AppMethodBeat.o(110004);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/story/ui/StoryCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "exit", "", "go2Capture", "onEditorPrepared", "prepareEditor", "captureInfo", "Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "plugin-story_release"})
    public static final class f implements b {
        final /* synthetic */ StoryCaptureUI seH;

        @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ f seJ;

            a(f fVar) {
                this.seJ = fVar;
            }

            public final void run() {
                AppMethodBeat.i(138849);
                CaptureView c = this.seJ.seH.seB;
                if (c != null) {
                    c.setVisibility(8);
                    AppMethodBeat.o(138849);
                    return;
                }
                AppMethodBeat.o(138849);
            }
        }

        f(StoryCaptureUI storyCaptureUI) {
            this.seH = storyCaptureUI;
        }

        public final void bnN() {
            AppMethodBeat.i(110007);
            this.seH.status = 0;
            CaptureView c = this.seH.seB;
            if (c != null) {
                c.setVisibility(0);
            }
            EditorView d = this.seH.seC;
            if (d != null) {
                d.setVisibility(8);
            }
            c = this.seH.seB;
            if (c != null) {
                com.tencent.mm.media.widget.camerarecordview.a.a(c.lmr);
                AppMethodBeat.o(110007);
                return;
            }
            AppMethodBeat.o(110007);
        }

        public final void b(com.tencent.mm.plugin.story.e.a aVar) {
            AppMethodBeat.i(110008);
            j.p(aVar, "captureInfo");
            ab.i("MicroMsg.StoryCaptureUI", "prepareEditor, captureView:" + this.seH.seB);
            this.seH.status = 2;
            CaptureView c = this.seH.seB;
            if (c != null) {
                c.postDelayed(new a(this), 50);
            }
            CaptureView c2 = this.seH.seB;
            if (c2 != null) {
                c2.lmr.stopPreview();
            }
            EditorView d = this.seH.seC;
            if (d != null) {
                d.setVisibility(0);
            }
            d = this.seH.seC;
            if (d != null) {
                d.setAlpha(0.0f);
            }
            com.tencent.mm.plugin.story.f.c e = this.seH.seD;
            if (e != null) {
                e.a(aVar);
            }
            h hVar = h.scu;
            h.cAm().ba(System.currentTimeMillis());
            AppMethodBeat.o(110008);
        }

        public final void bnO() {
            AppMethodBeat.i(110009);
            ab.i("MicroMsg.StoryCaptureUI", "onEditorPrepared, captureView:" + this.seH.seB);
            this.seH.status = 1;
            EditorView d = this.seH.seC;
            if (d != null) {
                d.setAlpha(1.0f);
                AppMethodBeat.o(110009);
                return;
            }
            AppMethodBeat.o(110009);
        }

        public final void exit() {
            AppMethodBeat.i(110010);
            this.seH.setResult(-1);
            this.seH.finish();
            AppMethodBeat.o(110010);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StoryCaptureUI$voipCallingListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "callback", "", "event", "plugin-story_release"})
    public static final class g extends com.tencent.mm.sdk.b.c<ui> {
        final /* synthetic */ StoryCaptureUI seH;

        g(StoryCaptureUI storyCaptureUI) {
            this.seH = storyCaptureUI;
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(110011);
            ui uiVar = (ui) bVar;
            if (uiVar instanceof ui) {
                if (!com.tencent.mm.kernel.g.RK()) {
                    AppMethodBeat.o(110011);
                    return false;
                } else if (uiVar.cQx.cAd == 3 && this.seH.status == 0) {
                    this.seH.seE.exit();
                }
            }
            AppMethodBeat.o(110011);
            return true;
        }
    }

    static {
        AppMethodBeat.i(110021);
        AppMethodBeat.o(110021);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public StoryCaptureUI() {
        AppMethodBeat.i(110020);
        AppMethodBeat.o(110020);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(110012);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        com.tencent.mm.plugin.story.proxy.StoryCaptureProxy.a aVar = StoryCaptureProxy.saw;
        com.tencent.mm.plugin.story.proxy.StoryCaptureProxy.a.createInstance(this.ext);
        com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy.a aVar2 = StoryAudioManagerProxy.sas;
        com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy.a.createInstance(this.ext);
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.ext));
        com.tencent.mm.media.proxy.MediaEditorProxy.a aVar3 = MediaEditorProxy.eWZ;
        com.tencent.mm.media.proxy.MediaEditorProxy.a.createInstance(this.ext);
        this.ext.connect(new c(this));
        this.seB = (CaptureView) findViewById(R.id.eqp);
        CaptureView captureView = this.seB;
        if (captureView != null) {
            captureView.setUiNavigation(this.seE);
        }
        this.seC = (EditorView) findViewById(R.id.eqq);
        Ne(8);
        getWindow().addFlags(2097280);
        getWindow().setFlags(201327616, 201327616);
        com.tencent.mm.plugin.mmsight.d.iV(true);
        com.tencent.mm.sdk.b.a.xxA.c(this.seF);
        h hVar = h.scu;
        h.cAo();
        hVar = h.scu;
        h.cAp();
        int intExtra = getIntent().getIntExtra("jump_page_from", -1);
        long longExtra = getIntent().getLongExtra("video_object_id", 0);
        long currentTimeMillis = System.currentTimeMillis();
        hVar = h.scu;
        h.cAm().aX((long) at.gC(dxU()));
        hVar = h.scu;
        h.cAm().fm(String.valueOf(currentTimeMillis));
        hVar = h.scu;
        h.cAm().aY((long) intExtra);
        hVar = h.scu;
        h.cAm().aZ(currentTimeMillis);
        hVar = h.scu;
        h.cAm().bi(longExtra);
        hVar = h.scu;
        h.cAq().bV((long) at.gC(dxU()));
        hVar = h.scu;
        com.tencent.mm.g.b.a.at cAq = h.cAq();
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
        j.o(RP, "MMKernel.storage()");
        cAq.fD(stringBuilder.append(RP.Ry().get(2).toString()).append(currentTimeMillis).toString());
        hVar = h.scu;
        h.cAq().bW((long) intExtra);
        hVar = h.scu;
        h.cAq().bX(currentTimeMillis);
        hVar = h.scu;
        h.cAq().cc(longExtra);
        com.tencent.mm.plugin.story.g.d dVar = com.tencent.mm.plugin.story.g.d.sbR;
        com.tencent.mm.plugin.story.g.d.czX();
        this.bZi = true;
        com.tencent.mm.cj.c.aNX();
        AppMethodBeat.o(110012);
    }

    public final int getLayoutId() {
        return R.layout.ay0;
    }

    public final void onResume() {
        AppMethodBeat.i(110013);
        ab.i("MicroMsg.StoryCaptureUI", "onResume, status:" + this.status);
        super.onResume();
        Ne(8);
        if (this.status == 0) {
            CaptureView captureView = this.seB;
            if (captureView != null) {
                com.tencent.mm.media.widget.camerarecordview.a.a(captureView.lmr);
                AppMethodBeat.o(110013);
                return;
            }
            AppMethodBeat.o(110013);
            return;
        }
        if (this.status == 1) {
            com.tencent.mm.plugin.story.f.c cVar = this.seD;
            if (cVar != null) {
                cVar.resume();
                AppMethodBeat.o(110013);
                return;
            }
        }
        AppMethodBeat.o(110013);
    }

    public final void onPause() {
        AppMethodBeat.i(110014);
        ab.i("MicroMsg.StoryCaptureUI", "onPause, status:" + this.status);
        h hVar = h.scu;
        h.EU(15);
        super.onPause();
        if (this.status == 0) {
            CaptureView captureView = this.seB;
            if (captureView != null) {
                captureView.lmr.stopPreview();
                AppMethodBeat.o(110014);
                return;
            }
            AppMethodBeat.o(110014);
            return;
        }
        if (this.status == 1) {
            com.tencent.mm.plugin.story.f.c cVar = this.seD;
            if (cVar != null) {
                cVar.pause();
                AppMethodBeat.o(110014);
                return;
            }
        }
        AppMethodBeat.o(110014);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x01db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        long j = -1;
        ArrayList arrayList = null;
        AppMethodBeat.i(110015);
        super.onActivityResult(i, i2, intent);
        ab.i("MicroMsg.StoryCaptureUI", "onActivityResult, requestCode:" + i + ", resultCode:" + i2 + ", data:" + intent);
        EditorView editorView = this.seC;
        if (editorView != null && i == 1003 && i2 == -1) {
            if (intent != null) {
                editorView.smk.eUu = bo.bc(intent.getStringExtra("get_poi_name"), "");
                editorView.smk.guP = bo.bc(intent.getStringExtra("get_city"), "");
                editorView.smk.vRq = intent.getFloatExtra("get_lat", -1000.0f);
                editorView.smk.vRp = intent.getFloatExtra("get_lng", -1000.0f);
                editorView.smk.wCC = intent.getStringExtra("get_poi_classify_id");
                com.tencent.mm.plugin.story.model.audio.b.a aVar = com.tencent.mm.plugin.story.model.audio.b.rUx;
                float f = editorView.smk.vRp;
                float f2 = editorView.smk.vRq;
                com.tencent.mm.plugin.story.model.audio.b.rUu = (long) (f * 1000000.0f);
                com.tencent.mm.plugin.story.model.audio.b.rUv = (long) (1000000.0f * f2);
                ab.i(editorView.TAG, "onActivityResult check cur lat " + editorView.smk.vRq + ' ' + editorView.smk.vRp + " poiname " + editorView.smk.eUu + " City " + editorView.smk.guP);
                if (editorView.smc.cCB()) {
                    EditorItemContainer editorItemContainer = editorView.smc;
                    cei cei = editorView.smk;
                    j.p(cei, "sl");
                    if (editorItemContainer.smR != null) {
                        editorItemContainer.f((a.f.a.a) new com.tencent.mm.plugin.story.ui.view.editor.item.EditorItemContainer.f(editorItemContainer, cei));
                    }
                } else {
                    editorView.smc.b(editorView.smk);
                }
            }
            editorView.smt = new com.tencent.mm.plugin.story.ui.view.editor.EditorView.b();
            com.tencent.mm.plugin.story.ui.view.editor.EditorView.b bVar = editorView.smt;
            if (!(bVar == null || intent == null)) {
                bVar.index = intent.getIntExtra("report_index", -1);
                bVar.oRM = intent.getLongExtra("first_start_time", 0);
                bVar.oRN = intent.getLongExtra("lastSuccStamp", 0);
                bVar.oRO = intent.getLongExtra("firstSuccStamp", 0);
                bVar.oRP = intent.getIntExtra("reqLoadCnt", 0);
                bVar.nPQ = intent.getIntExtra("entry_time", 0);
                stringExtra = intent.getStringExtra("search_id");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                bVar.hlm = stringExtra;
            }
        }
        if (i == 1002 && i2 == -1) {
            Object valueOf;
            Object valueOf2;
            String stringExtra2 = intent != null ? intent.getStringExtra("K_SEGMENTVIDEOPATH") : null;
            if (intent != null) {
                valueOf = Long.valueOf(intent.getLongExtra("key_seek_look_start_time", -1));
            } else {
                valueOf = null;
            }
            if (intent != null) {
                valueOf2 = Long.valueOf(intent.getLongExtra("key_seek_end_time", -1));
            } else {
                valueOf2 = null;
            }
            if (bo.isNullOrNil(stringExtra2)) {
                if (intent != null) {
                    arrayList = intent.getStringArrayListExtra("key_select_video_list");
                }
                if (arrayList != null && arrayList.size() > 0) {
                    stringExtra = (String) arrayList.get(0);
                    ab.i("MicroMsg.StoryCaptureUI", "select from album finish, videoPath:" + stringExtra + ", startTime:" + valueOf + ", endTime:" + valueOf2);
                    if (!bo.isNullOrNil(stringExtra)) {
                        long longValue;
                        com.tencent.mm.plugin.story.e.a aVar2 = new com.tencent.mm.plugin.story.e.a();
                        if (stringExtra == null) {
                            j.dWJ();
                        }
                        aVar2.aad(stringExtra);
                        if (valueOf != null) {
                            longValue = valueOf.longValue();
                        } else {
                            longValue = -1;
                        }
                        aVar2.rRG = longValue;
                        if (valueOf2 != null) {
                            j = valueOf2.longValue();
                        }
                        aVar2.rRH = j;
                        aVar2.fbV = false;
                        aVar2.eXL = SightVideoJNI.getMp4Rotate(stringExtra);
                        this.seE.b(aVar2);
                    }
                }
            }
            stringExtra = stringExtra2;
            ab.i("MicroMsg.StoryCaptureUI", "select from album finish, videoPath:" + stringExtra + ", startTime:" + valueOf + ", endTime:" + valueOf2);
            if (bo.isNullOrNil(stringExtra)) {
            }
        }
        AppMethodBeat.o(110015);
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.i(110016);
        j.p(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        j.p(iArr, "grantResults");
        Object[] objArr;
        Thread currentThread;
        if (iArr.length <= 0) {
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            currentThread = Thread.currentThread();
            j.o(currentThread, "Thread.currentThread()");
            objArr[1] = Long.valueOf(currentThread.getId());
            ab.i("MicroMsg.StoryCaptureUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", objArr);
            AppMethodBeat.o(110016);
            return;
        }
        objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(iArr[0]);
        currentThread = Thread.currentThread();
        j.o(currentThread, "Thread.currentThread()");
        objArr[2] = Long.valueOf(currentThread.getId());
        ab.i("MicroMsg.StoryCaptureUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", objArr);
        switch (i) {
            case 64:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.dby), getString(R.string.dc8), getString(R.string.ckr), getString(R.string.or), false, (OnClickListener) new d(this), (OnClickListener) e.seI);
                    break;
                }
                break;
        }
        AppMethodBeat.o(110016);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(110017);
        j.p(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (this.bZi && com.tencent.mm.compatible.util.d.iW(13)) {
            Point point = new Point(configuration.screenWidthDp, configuration.screenHeightDp);
            if (this.oCX == null || (j.j(this.oCX, point) ^ 1) != 0) {
                this.oCX = point;
            }
        }
        AppMethodBeat.o(110017);
    }

    public final void onBackPressed() {
        AppMethodBeat.i(110018);
        CaptureView captureView = this.seB;
        if (captureView != null) {
            Object obj;
            if (captureView.sih != null) {
                captureView.cCl();
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == 1) {
                AppMethodBeat.o(110018);
                return;
            }
        }
        h hVar = h.scu;
        h.EU(14);
        com.tencent.mm.plugin.story.f.c cVar = this.seD;
        if (cVar != null) {
            if (!cVar.Ab()) {
                this.seE.exit();
                hVar = h.scu;
                h.cAo();
                hVar = h.scu;
                h.cAr();
            }
            AppMethodBeat.o(110018);
            return;
        }
        AppMethodBeat.o(110018);
    }

    public final void onDestroy() {
        AppMethodBeat.i(110019);
        super.onDestroy();
        this.ext.release();
        CaptureView captureView = this.seB;
        if (captureView != null) {
            com.tencent.mm.media.widget.camerarecordview.a aVar = captureView.lmr;
            com.tencent.mm.media.widget.camerarecordview.b.a aVar2 = aVar.fbJ;
            aVar2.fbZ.disable();
            aVar2.context = null;
            com.tencent.mm.media.widget.camerarecordview.b bVar = com.tencent.mm.media.widget.camerarecordview.b.fbR;
            com.tencent.mm.media.widget.camerarecordview.b.Wv();
            aVar.fbK.getCameraPreviewView().release();
            com.tencent.mm.media.widget.b.b bVar2 = aVar.fbB;
            if (bVar2 != null) {
                bVar2.cancel();
            }
            com.tencent.mm.media.widget.b.b bVar3 = aVar.fbB;
            if (bVar3 != null) {
                bVar3.clear();
            }
        }
        com.tencent.mm.plugin.story.f.c cVar = this.seD;
        if (cVar != null) {
            cVar.reset();
            cVar.rYw.destroy();
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.seF);
        com.tencent.mm.plugin.story.model.i.a aVar3 = i.rSv;
        com.tencent.mm.sdk.g.d.post(com.tencent.mm.plugin.story.model.i.a.a.rSw, "Story_cleanAudioFile");
        com.tencent.mm.plugin.story.g.d dVar = com.tencent.mm.plugin.story.g.d.sbR;
        com.tencent.mm.plugin.story.g.d.czY();
        AppMethodBeat.o(110019);
    }

    public final int getForceOrientation() {
        if (q.etc.erC) {
            return 7;
        }
        return 1;
    }

    public static final /* synthetic */ void a(StoryCaptureUI storyCaptureUI) {
        AppMethodBeat.i(110022);
        com.tencent.mm.plugin.story.model.i.a aVar = i.rSv;
        com.tencent.mm.plugin.story.proxy.d.a aVar2 = com.tencent.mm.plugin.story.proxy.d.sbf;
        com.tencent.mm.plugin.story.proxy.d.sbe;
        j.p(com.tencent.mm.plugin.story.proxy.d.getAccPath(), "accPath");
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
        j.o(RP, "MMKernel.storage()");
        String stringBuilder2 = stringBuilder.append(RP.getAccPath()).append("story/").toString();
        j.p(stringBuilder2, "<set-?>");
        i.rSr = stringBuilder2;
        com.tencent.mm.vfs.e.tf(i.rSr);
        storyCaptureUI.status = 0;
        EditorView editorView = storyCaptureUI.seC;
        if (editorView != null) {
            com.tencent.mm.plugin.story.f.c cVar = new com.tencent.mm.plugin.story.f.c(storyCaptureUI, storyCaptureUI.seE, editorView);
            editorView.setPresenter(cVar);
            storyCaptureUI.seD = cVar;
        }
        CaptureView captureView = storyCaptureUI.seB;
        if (captureView != null) {
            com.tencent.mm.media.widget.camerarecordview.a.a(captureView.lmr);
            AppMethodBeat.o(110022);
            return;
        }
        AppMethodBeat.o(110022);
    }
}
