package com.tencent.p177mm.plugin.story.p536ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1706e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.media.proxy.MediaEditorProxy;
import com.tencent.p177mm.media.proxy.MediaEditorProxy.C32762a;
import com.tencent.p177mm.media.widget.camerarecordview.C26393b;
import com.tencent.p177mm.media.widget.camerarecordview.C9615a;
import com.tencent.p177mm.media.widget.camerarecordview.p869b.C32766a;
import com.tencent.p177mm.media.widget.p257b.C1788b;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C26250ui;
import com.tencent.p177mm.p230g.p232b.p233a.C26274at;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.plugin.story.model.C43641i;
import com.tencent.p177mm.plugin.story.model.C43641i.C43642a;
import com.tencent.p177mm.plugin.story.model.C43641i.C43642a.C39908a;
import com.tencent.p177mm.plugin.story.model.audio.C22219b;
import com.tencent.p177mm.plugin.story.model.audio.C22219b.C13771a;
import com.tencent.p177mm.plugin.story.p1303e.C39872a;
import com.tencent.p177mm.plugin.story.p530f.C31420c;
import com.tencent.p177mm.plugin.story.p531g.C22212h;
import com.tencent.p177mm.plugin.story.p531g.C35182d;
import com.tencent.p177mm.plugin.story.p536ui.view.CaptureView;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.EditorView;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.EditorView.C16891b;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.item.EditorItemContainer;
import com.tencent.p177mm.plugin.story.p536ui.view.editor.item.EditorItemContainer.C13876f;
import com.tencent.p177mm.plugin.story.proxy.C39913d;
import com.tencent.p177mm.plugin.story.proxy.C39913d.C22249a;
import com.tencent.p177mm.plugin.story.proxy.StoryAudioManagerProxy;
import com.tencent.p177mm.plugin.story.proxy.StoryAudioManagerProxy.C22248a;
import com.tencent.p177mm.plugin.story.proxy.StoryCaptureProxy;
import com.tencent.p177mm.plugin.story.proxy.StoryCaptureProxy.C31583a;
import com.tencent.p177mm.protocal.protobuf.cei;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import p000a.C0220l;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C5271a(3)
@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005*\u0002\u0012\u0015\b\u0007\u0018\u0000 22\u00020\u0001:\u000223B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0014J\b\u0010\u001a\u001a\u00020\u0010H\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\"\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0018H\u0016J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0018H\u0014J\b\u0010)\u001a\u00020\u0018H\u0014J+\u0010*\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00102\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010.\u001a\u00020/H\u0016¢\u0006\u0002\u00100J\b\u00101\u001a\u00020\u0018H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u0010\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0016¨\u00064"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "captureView", "Lcom/tencent/mm/plugin/story/ui/view/CaptureView;", "editorPresenter", "Lcom/tencent/mm/plugin/story/presenter/EditorPresenter;", "editorView", "Lcom/tencent/mm/plugin/story/ui/view/editor/EditorView;", "isInit", "", "screenDp", "Landroid/graphics/Point;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "status", "", "uiNavigation", "com/tencent/mm/plugin/story/ui/StoryCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$uiNavigation$1;", "voipCallingListener", "com/tencent/mm/plugin/story/ui/StoryCaptureUI$voipCallingListener$1", "Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$voipCallingListener$1;", "doReport", "", "getForceOrientation", "getLayoutId", "initCreate", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "Companion", "UINavigation", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.StoryCaptureUI */
public final class StoryCaptureUI extends MMActivity {
    public static final C13801a seG = new C13801a();
    private boolean bZi;
    private final C46607d ext = new C46607d(this);
    private Point oCX;
    private CaptureView seB;
    private EditorView seC;
    private C31420c seD;
    private final C13804f seE = new C13804f(this);
    private final C13806g seF = new C13806g(this);
    private int status = -1;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "", "exit", "", "go2Capture", "onEditorPrepared", "prepareEditor", "captureInfo", "Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StoryCaptureUI$b */
    public interface C4149b {
        /* renamed from: b */
        void mo9029b(C39872a c39872a);

        void bnN();

        void bnO();

        void exit();
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StoryCaptureUI$c */
    static final class C4150c implements Runnable {
        final /* synthetic */ StoryCaptureUI seH;

        C4150c(StoryCaptureUI storyCaptureUI) {
            this.seH = storyCaptureUI;
        }

        public final void run() {
            AppMethodBeat.m2504i(110002);
            StoryCaptureUI.m21952a(this.seH);
            AppMethodBeat.m2505o(110002);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$Companion;", "", "()V", "RequestCodeAlbum", "", "RequestCodeLocation", "RequestCodePreview", "STATE_CAPTURE", "STATE_EDIT", "STATE_EDIT_PREPARE", "STATE_NONE", "TAG", "", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StoryCaptureUI$a */
    public static final class C13801a {
        private C13801a() {
        }

        public /* synthetic */ C13801a(byte b) {
            this();
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StoryCaptureUI$d */
    static final class C13802d implements OnClickListener {
        final /* synthetic */ StoryCaptureUI seH;

        C13802d(StoryCaptureUI storyCaptureUI) {
            this.seH = storyCaptureUI;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(110003);
            this.seH.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(110003);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StoryCaptureUI$e */
    static final class C13803e implements OnClickListener {
        public static final C13803e seI = new C13803e();

        static {
            AppMethodBeat.m2504i(110005);
            AppMethodBeat.m2505o(110005);
        }

        C13803e() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(110004);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(110004);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, dWq = {"com/tencent/mm/plugin/story/ui/StoryCaptureUI$uiNavigation$1", "Lcom/tencent/mm/plugin/story/ui/StoryCaptureUI$UINavigation;", "exit", "", "go2Capture", "onEditorPrepared", "prepareEditor", "captureInfo", "Lcom/tencent/mm/plugin/story/data/StoryCaptureInfo;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StoryCaptureUI$f */
    public static final class C13804f implements C4149b {
        final /* synthetic */ StoryCaptureUI seH;

        @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        /* renamed from: com.tencent.mm.plugin.story.ui.StoryCaptureUI$f$a */
        static final class C13805a implements Runnable {
            final /* synthetic */ C13804f seJ;

            C13805a(C13804f c13804f) {
                this.seJ = c13804f;
            }

            public final void run() {
                AppMethodBeat.m2504i(138849);
                CaptureView c = this.seJ.seH.seB;
                if (c != null) {
                    c.setVisibility(8);
                    AppMethodBeat.m2505o(138849);
                    return;
                }
                AppMethodBeat.m2505o(138849);
            }
        }

        C13804f(StoryCaptureUI storyCaptureUI) {
            this.seH = storyCaptureUI;
        }

        public final void bnN() {
            AppMethodBeat.m2504i(110007);
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
                C9615a.m17111a(c.lmr);
                AppMethodBeat.m2505o(110007);
                return;
            }
            AppMethodBeat.m2505o(110007);
        }

        /* renamed from: b */
        public final void mo9029b(C39872a c39872a) {
            AppMethodBeat.m2504i(110008);
            C25052j.m39376p(c39872a, "captureInfo");
            C4990ab.m7416i("MicroMsg.StoryCaptureUI", "prepareEditor, captureView:" + this.seH.seB);
            this.seH.status = 2;
            CaptureView c = this.seH.seB;
            if (c != null) {
                c.postDelayed(new C13805a(this), 50);
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
            C31420c e = this.seH.seD;
            if (e != null) {
                e.mo51364a(c39872a);
            }
            C22212h c22212h = C22212h.scu;
            C22212h.cAm().mo4998ba(System.currentTimeMillis());
            AppMethodBeat.m2505o(110008);
        }

        public final void bnO() {
            AppMethodBeat.m2504i(110009);
            C4990ab.m7416i("MicroMsg.StoryCaptureUI", "onEditorPrepared, captureView:" + this.seH.seB);
            this.seH.status = 1;
            EditorView d = this.seH.seC;
            if (d != null) {
                d.setAlpha(1.0f);
                AppMethodBeat.m2505o(110009);
                return;
            }
            AppMethodBeat.m2505o(110009);
        }

        public final void exit() {
            AppMethodBeat.m2504i(110010);
            this.seH.setResult(-1);
            this.seH.finish();
            AppMethodBeat.m2505o(110010);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/StoryCaptureUI$voipCallingListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/VoipEvent;", "callback", "", "event", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.StoryCaptureUI$g */
    public static final class C13806g extends C4884c<C26250ui> {
        final /* synthetic */ StoryCaptureUI seH;

        C13806g(StoryCaptureUI storyCaptureUI) {
            this.seH = storyCaptureUI;
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(110011);
            C26250ui c26250ui = (C26250ui) c4883b;
            if (c26250ui instanceof C26250ui) {
                if (!C1720g.m3531RK()) {
                    AppMethodBeat.m2505o(110011);
                    return false;
                } else if (c26250ui.cQx.cAd == 3 && this.seH.status == 0) {
                    this.seH.seE.exit();
                }
            }
            AppMethodBeat.m2505o(110011);
            return true;
        }
    }

    static {
        AppMethodBeat.m2504i(110021);
        AppMethodBeat.m2505o(110021);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public StoryCaptureUI() {
        AppMethodBeat.m2504i(110020);
        AppMethodBeat.m2505o(110020);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(110012);
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        C31583a c31583a = StoryCaptureProxy.saw;
        C31583a.createInstance(this.ext);
        C22248a c22248a = StoryAudioManagerProxy.sas;
        C22248a.createInstance(this.ext);
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.ext));
        C32762a c32762a = MediaEditorProxy.eWZ;
        C32762a.createInstance(this.ext);
        this.ext.connect(new C4150c(this));
        this.seB = (CaptureView) findViewById(2131828043);
        CaptureView captureView = this.seB;
        if (captureView != null) {
            captureView.setUiNavigation(this.seE);
        }
        this.seC = (EditorView) findViewById(2131828044);
        mo17375Ne(8);
        getWindow().addFlags(2097280);
        getWindow().setFlags(201327616, 201327616);
        C3475d.m5783iV(true);
        C4879a.xxA.mo10052c(this.seF);
        C22212h c22212h = C22212h.scu;
        C22212h.cAo();
        c22212h = C22212h.scu;
        C22212h.cAp();
        int intExtra = getIntent().getIntExtra("jump_page_from", -1);
        long longExtra = getIntent().getLongExtra("video_object_id", 0);
        long currentTimeMillis = System.currentTimeMillis();
        c22212h = C22212h.scu;
        C22212h.cAm().mo4995aX((long) C5023at.m7472gC(dxU()));
        c22212h = C22212h.scu;
        C22212h.cAm().mo5009fm(String.valueOf(currentTimeMillis));
        c22212h = C22212h.scu;
        C22212h.cAm().mo4996aY((long) intExtra);
        c22212h = C22212h.scu;
        C22212h.cAm().mo4997aZ(currentTimeMillis);
        c22212h = C22212h.scu;
        C22212h.cAm().mo5006bi(longExtra);
        c22212h = C22212h.scu;
        C22212h.cAq().mo43958bV((long) C5023at.m7472gC(dxU()));
        c22212h = C22212h.scu;
        C26274at cAq = C22212h.cAq();
        StringBuilder stringBuilder = new StringBuilder();
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        cAq.mo43967fD(stringBuilder.append(RP.mo5239Ry().get(2).toString()).append(currentTimeMillis).toString());
        c22212h = C22212h.scu;
        C22212h.cAq().mo43959bW((long) intExtra);
        c22212h = C22212h.scu;
        C22212h.cAq().mo43960bX(currentTimeMillis);
        c22212h = C22212h.scu;
        C22212h.cAq().mo43965cc(longExtra);
        C35182d c35182d = C35182d.sbR;
        C35182d.czX();
        this.bZi = true;
        C45287c.aNX();
        AppMethodBeat.m2505o(110012);
    }

    public final int getLayoutId() {
        return 2130970863;
    }

    public final void onResume() {
        AppMethodBeat.m2504i(110013);
        C4990ab.m7416i("MicroMsg.StoryCaptureUI", "onResume, status:" + this.status);
        super.onResume();
        mo17375Ne(8);
        if (this.status == 0) {
            CaptureView captureView = this.seB;
            if (captureView != null) {
                C9615a.m17111a(captureView.lmr);
                AppMethodBeat.m2505o(110013);
                return;
            }
            AppMethodBeat.m2505o(110013);
            return;
        }
        if (this.status == 1) {
            C31420c c31420c = this.seD;
            if (c31420c != null) {
                c31420c.resume();
                AppMethodBeat.m2505o(110013);
                return;
            }
        }
        AppMethodBeat.m2505o(110013);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(110014);
        C4990ab.m7416i("MicroMsg.StoryCaptureUI", "onPause, status:" + this.status);
        C22212h c22212h = C22212h.scu;
        C22212h.m33887EU(15);
        super.onPause();
        if (this.status == 0) {
            CaptureView captureView = this.seB;
            if (captureView != null) {
                captureView.lmr.stopPreview();
                AppMethodBeat.m2505o(110014);
                return;
            }
            AppMethodBeat.m2505o(110014);
            return;
        }
        if (this.status == 1) {
            C31420c c31420c = this.seD;
            if (c31420c != null) {
                c31420c.pause();
                AppMethodBeat.m2505o(110014);
                return;
            }
        }
        AppMethodBeat.m2505o(110014);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x01db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int i, int i2, Intent intent) {
        String stringExtra;
        long j = -1;
        ArrayList arrayList = null;
        AppMethodBeat.m2504i(110015);
        super.onActivityResult(i, i2, intent);
        C4990ab.m7416i("MicroMsg.StoryCaptureUI", "onActivityResult, requestCode:" + i + ", resultCode:" + i2 + ", data:" + intent);
        EditorView editorView = this.seC;
        if (editorView != null && i == 1003 && i2 == -1) {
            if (intent != null) {
                editorView.smk.eUu = C5046bo.m7532bc(intent.getStringExtra("get_poi_name"), "");
                editorView.smk.guP = C5046bo.m7532bc(intent.getStringExtra("get_city"), "");
                editorView.smk.vRq = intent.getFloatExtra("get_lat", -1000.0f);
                editorView.smk.vRp = intent.getFloatExtra("get_lng", -1000.0f);
                editorView.smk.wCC = intent.getStringExtra("get_poi_classify_id");
                C13771a c13771a = C22219b.rUx;
                float f = editorView.smk.vRp;
                float f2 = editorView.smk.vRq;
                C22219b.rUu = (long) (f * 1000000.0f);
                C22219b.rUv = (long) (1000000.0f * f2);
                C4990ab.m7416i(editorView.TAG, "onActivityResult check cur lat " + editorView.smk.vRq + ' ' + editorView.smk.vRp + " poiname " + editorView.smk.eUu + " City " + editorView.smk.guP);
                if (editorView.smc.cCB()) {
                    EditorItemContainer editorItemContainer = editorView.smc;
                    cei cei = editorView.smk;
                    C25052j.m39376p(cei, "sl");
                    if (editorItemContainer.smR != null) {
                        editorItemContainer.mo37831f((C31214a) new C13876f(editorItemContainer, cei));
                    }
                } else {
                    editorView.smc.mo37829b(editorView.smk);
                }
            }
            editorView.smt = new C16891b();
            C16891b c16891b = editorView.smt;
            if (!(c16891b == null || intent == null)) {
                c16891b.index = intent.getIntExtra("report_index", -1);
                c16891b.oRM = intent.getLongExtra("first_start_time", 0);
                c16891b.oRN = intent.getLongExtra("lastSuccStamp", 0);
                c16891b.oRO = intent.getLongExtra("firstSuccStamp", 0);
                c16891b.oRP = intent.getIntExtra("reqLoadCnt", 0);
                c16891b.nPQ = intent.getIntExtra("entry_time", 0);
                stringExtra = intent.getStringExtra("search_id");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                c16891b.hlm = stringExtra;
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
            if (C5046bo.isNullOrNil(stringExtra2)) {
                if (intent != null) {
                    arrayList = intent.getStringArrayListExtra("key_select_video_list");
                }
                if (arrayList != null && arrayList.size() > 0) {
                    stringExtra = (String) arrayList.get(0);
                    C4990ab.m7416i("MicroMsg.StoryCaptureUI", "select from album finish, videoPath:" + stringExtra + ", startTime:" + valueOf + ", endTime:" + valueOf2);
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        long longValue;
                        C39872a c39872a = new C39872a();
                        if (stringExtra == null) {
                            C25052j.dWJ();
                        }
                        c39872a.aad(stringExtra);
                        if (valueOf != null) {
                            longValue = valueOf.longValue();
                        } else {
                            longValue = -1;
                        }
                        c39872a.rRG = longValue;
                        if (valueOf2 != null) {
                            j = valueOf2.longValue();
                        }
                        c39872a.rRH = j;
                        c39872a.fbV = false;
                        c39872a.eXL = SightVideoJNI.getMp4Rotate(stringExtra);
                        this.seE.mo9029b(c39872a);
                    }
                }
            }
            stringExtra = stringExtra2;
            C4990ab.m7416i("MicroMsg.StoryCaptureUI", "select from album finish, videoPath:" + stringExtra + ", startTime:" + valueOf + ", endTime:" + valueOf2);
            if (C5046bo.isNullOrNil(stringExtra)) {
            }
        }
        AppMethodBeat.m2505o(110015);
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(110016);
        C25052j.m39376p(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        C25052j.m39376p(iArr, "grantResults");
        Object[] objArr;
        Thread currentThread;
        if (iArr.length <= 0) {
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(i);
            currentThread = Thread.currentThread();
            C25052j.m39375o(currentThread, "Thread.currentThread()");
            objArr[1] = Long.valueOf(currentThread.getId());
            C4990ab.m7417i("MicroMsg.StoryCaptureUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", objArr);
            AppMethodBeat.m2505o(110016);
            return;
        }
        objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(iArr[0]);
        currentThread = Thread.currentThread();
        C25052j.m39375o(currentThread, "Thread.currentThread()");
        objArr[2] = Long.valueOf(currentThread.getId());
        C4990ab.m7417i("MicroMsg.StoryCaptureUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", objArr);
        switch (i) {
            case 64:
                if (iArr[0] != 0) {
                    C30379h.m48445a((Context) this, getString(C25738R.string.dby), getString(C25738R.string.dc8), getString(C25738R.string.ckr), getString(C25738R.string.f9076or), false, (OnClickListener) new C13802d(this), (OnClickListener) C13803e.seI);
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(110016);
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(110017);
        C25052j.m39376p(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        if (this.bZi && C1443d.m3068iW(13)) {
            Point point = new Point(configuration.screenWidthDp, configuration.screenHeightDp);
            if (this.oCX == null || (C25052j.m39373j(this.oCX, point) ^ 1) != 0) {
                this.oCX = point;
            }
        }
        AppMethodBeat.m2505o(110017);
    }

    public final void onBackPressed() {
        AppMethodBeat.m2504i(110018);
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
                AppMethodBeat.m2505o(110018);
                return;
            }
        }
        C22212h c22212h = C22212h.scu;
        C22212h.m33887EU(14);
        C31420c c31420c = this.seD;
        if (c31420c != null) {
            if (!c31420c.mo47474Ab()) {
                this.seE.exit();
                c22212h = C22212h.scu;
                C22212h.cAo();
                c22212h = C22212h.scu;
                C22212h.cAr();
            }
            AppMethodBeat.m2505o(110018);
            return;
        }
        AppMethodBeat.m2505o(110018);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(110019);
        super.onDestroy();
        this.ext.release();
        CaptureView captureView = this.seB;
        if (captureView != null) {
            C9615a c9615a = captureView.lmr;
            C32766a c32766a = c9615a.fbJ;
            c32766a.fbZ.disable();
            c32766a.context = null;
            C26393b c26393b = C26393b.fbR;
            C26393b.m42007Wv();
            c9615a.fbK.getCameraPreviewView().release();
            C1788b c1788b = c9615a.fbB;
            if (c1788b != null) {
                c1788b.cancel();
            }
            C1788b c1788b2 = c9615a.fbB;
            if (c1788b2 != null) {
                c1788b2.clear();
            }
        }
        C31420c c31420c = this.seD;
        if (c31420c != null) {
            c31420c.reset();
            c31420c.rYw.destroy();
        }
        C4879a.xxA.mo10053d(this.seF);
        C43642a c43642a = C43641i.rSv;
        C7305d.post(C39908a.rSw, "Story_cleanAudioFile");
        C35182d c35182d = C35182d.sbR;
        C35182d.czY();
        AppMethodBeat.m2505o(110019);
    }

    public final int getForceOrientation() {
        if (C1427q.etc.erC) {
            return 7;
        }
        return 1;
    }

    /* renamed from: a */
    public static final /* synthetic */ void m21952a(StoryCaptureUI storyCaptureUI) {
        AppMethodBeat.m2504i(110022);
        C43642a c43642a = C43641i.rSv;
        C22249a c22249a = C39913d.sbf;
        C39913d.sbe;
        C25052j.m39376p(C39913d.getAccPath(), "accPath");
        StringBuilder stringBuilder = new StringBuilder();
        C1706e RP = C1720g.m3536RP();
        C25052j.m39375o(RP, "MMKernel.storage()");
        String stringBuilder2 = stringBuilder.append(RP.getAccPath()).append("story/").toString();
        C25052j.m39376p(stringBuilder2, "<set-?>");
        C43641i.rSr = stringBuilder2;
        C5730e.m8643tf(C43641i.rSr);
        storyCaptureUI.status = 0;
        EditorView editorView = storyCaptureUI.seC;
        if (editorView != null) {
            C31420c c31420c = new C31420c(storyCaptureUI, storyCaptureUI.seE, editorView);
            editorView.setPresenter(c31420c);
            storyCaptureUI.seD = c31420c;
        }
        CaptureView captureView = storyCaptureUI.seB;
        if (captureView != null) {
            C9615a.m17111a(captureView.lmr);
            AppMethodBeat.m2505o(110022);
            return;
        }
        AppMethodBeat.m2505o(110022);
    }
}
