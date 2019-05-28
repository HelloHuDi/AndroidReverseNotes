package com.tencent.p177mm.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.emoji.p1381c.C26073a;
import com.tencent.p177mm.emoji.p227a.C1511f;
import com.tencent.p177mm.emoji.p227a.C32498b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p211cb.C26003e;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emojicapture.api.C20423c;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel;
import com.tencent.p177mm.pluginsdk.p597ui.ChatFooterPanel.C44073a;
import com.tencent.p177mm.pluginsdk.p597ui.chat.C23297j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30301b;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30302a;
import com.tencent.p177mm.view.p1097f.C16067a;
import com.tencent.p177mm.view.p645a.C36883f;

/* renamed from: com.tencent.mm.view.SmileyGrid */
public class SmileyGrid extends GridView {
    public static int zZY = 1;
    public int Aaa = 0;
    private int Aab = 0;
    private C44073a Aac;
    private boolean Aad;
    public OnItemClickListener Aae = new C308389();
    /* renamed from: Ei */
    public ListAdapter f17952Ei;
    private int gOW = ChatFooterPanel.vhh;
    private OnItemClickListener jMk = new C308361();
    private int jiw;
    public int jiy;
    private C23297j voG;
    private int zZZ = 20;

    /* renamed from: com.tencent.mm.view.SmileyGrid$16 */
    class C3083516 implements OnClickListener {
        C3083516() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.view.SmileyGrid$1 */
    class C308361 implements OnItemClickListener {
        C308361() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            boolean z = true;
            AppMethodBeat.m2504i(62898);
            EmojiInfo emojiInfo;
            switch (SmileyGrid.this.zZZ) {
                case 20:
                    if (!(adapterView.getAdapter() instanceof C36883f) || !((C36883f) adapterView.getAdapter()).mo58774QD(i)) {
                        if (i != SmileyGrid.this.f17952Ei.getCount() - 1) {
                            if ((SmileyGrid.this.jiy * (SmileyGrid.this.Aaa - 1)) + i < SmileyGrid.this.jiw) {
                                int i2 = (SmileyGrid.this.jiy * (SmileyGrid.this.Aaa - 1)) + i;
                                ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35626bZ(C26003e.dqK().mo43878qL(i2), i2);
                                if (SmileyGrid.this.Aac != null) {
                                    String qK;
                                    if (SmileyGrid.this.Aad) {
                                        qK = C26003e.dqK().mo43877qK(i2);
                                    } else {
                                        qK = C26003e.dqK().getText(i2);
                                    }
                                    SmileyGrid.this.Aac.append(qK);
                                    C7060h.pYm.mo8381e(13470, qK.replaceAll(",", " "), Integer.valueOf(SmileyGrid.this.gOW), Integer.valueOf(0));
                                    break;
                                }
                            }
                            AppMethodBeat.m2505o(62898);
                            return;
                        }
                        if (SmileyGrid.this.Aac != null) {
                            SmileyGrid.this.Aac.aRg();
                        }
                        AppMethodBeat.m2505o(62898);
                        return;
                    }
                    if (SmileyGrid.this.Aac != null) {
                        SmileyGrid.this.Aac.aRg();
                    }
                    AppMethodBeat.m2505o(62898);
                    return;
                    break;
                case 23:
                case 25:
                    if (SmileyGrid.this.zZZ == 25 && i == 0 && SmileyGrid.this.jiy == 0 && C16067a.m24370QM(SmileyGrid.this.gOW)) {
                        SmileyGrid.m88533c(SmileyGrid.this);
                        AppMethodBeat.m2505o(62898);
                        return;
                    }
                    emojiInfo = (EmojiInfo) SmileyGrid.this.f17952Ei.getItem(i);
                    if (emojiInfo != null) {
                        if (SmileyGrid.this.zZZ != 25) {
                            z = false;
                        }
                        C26073a.m41631OZ().mo43942a(z, i, emojiInfo.field_md5, emojiInfo.field_groupId, emojiInfo.field_designerID, emojiInfo.field_activityid);
                        SmileyGrid.m88530a(SmileyGrid.this, emojiInfo);
                    }
                    AppMethodBeat.m2505o(62898);
                    return;
                case 26:
                    if (i != 0 || SmileyGrid.this.jiy != 0 || !C16067a.m24369QL(SmileyGrid.this.gOW)) {
                        emojiInfo = (EmojiInfo) SmileyGrid.this.f17952Ei.getItem(i);
                        if (emojiInfo != null) {
                            if (SmileyGrid.this.zZZ != 25) {
                                z = false;
                            }
                            C26073a.m41631OZ().mo43942a(z, i, emojiInfo.field_md5, emojiInfo.field_groupId, emojiInfo.field_designerID, emojiInfo.field_activityid);
                            SmileyGrid.m88532b(SmileyGrid.this, emojiInfo);
                        }
                        AppMethodBeat.m2505o(62898);
                        return;
                    } else if (((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35614OT()) {
                        C20423c.m31582h(SmileyGrid.this.getContext(), null, C16067a.m24368QK(SmileyGrid.this.gOW));
                        AppMethodBeat.m2505o(62898);
                        return;
                    }
                    break;
            }
            AppMethodBeat.m2505o(62898);
        }
    }

    /* renamed from: com.tencent.mm.view.SmileyGrid$9 */
    class C308389 implements OnItemClickListener {
        C308389() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(62906);
            Object item = adapterView.getAdapter().getItem(i);
            if (item instanceof C1511f) {
                int i2 = ((C1511f) item).position;
                ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35626bZ(C26003e.dqK().mo43878qL(i2), i2);
                if (SmileyGrid.this.Aac != null) {
                    String qK;
                    if (SmileyGrid.this.Aad) {
                        qK = C26003e.dqK().mo43877qK(i2);
                    } else {
                        qK = C26003e.dqK().getText(i2);
                    }
                    SmileyGrid.this.Aac.append(qK);
                    C7060h.pYm.mo8381e(13470, qK.replaceAll(",", " "), Integer.valueOf(SmileyGrid.this.gOW), Integer.valueOf(1));
                }
            }
            AppMethodBeat.m2505o(62906);
        }
    }

    /* renamed from: com.tencent.mm.view.SmileyGrid$12 */
    class C4441612 implements C5662c {
        C4441612() {
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
            AppMethodBeat.m2504i(62909);
            if (z) {
                Intent intent = new Intent();
                intent.putExtra("key_emoji_panel_type", 1);
                C25985d.m41467b(SmileyGrid.this.getContext(), "emoji", ".ui.EmojiCustomUI", intent);
            }
            AppMethodBeat.m2505o(62909);
        }
    }

    /* renamed from: com.tencent.mm.view.SmileyGrid$4 */
    class C467124 implements C5662c {
        C467124() {
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
            AppMethodBeat.m2504i(62901);
            if (z) {
                Intent intent = new Intent();
                intent.putExtra("key_emoji_panel_type", 1);
                C25985d.m41467b(SmileyGrid.this.getContext(), "emoji", ".ui.EmojiCustomUI", intent);
            }
            AppMethodBeat.m2505o(62901);
        }
    }

    public void setCallback(C23297j c23297j) {
        this.voG = c23297j;
    }

    public SmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(62913);
        AppMethodBeat.m2505o(62913);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(62914);
        super.onSizeChanged(i, i2, i3, i4);
        AppMethodBeat.m2505o(62914);
    }

    /* Access modifiers changed, original: protected */
    @TargetApi(8)
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(62915);
        super.onConfigurationChanged(configuration);
        AppMethodBeat.m2505o(62915);
    }

    public final void dMI() {
        AppMethodBeat.m2504i(62916);
        setOnItemClickListener(this.jMk);
        AppMethodBeat.m2505o(62916);
    }

    /* renamed from: j */
    public final void mo75098j(int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(62917);
        C4990ab.m7418v("MicroMsg.emoji.SmileyGrid", "type:" + i + " itemsPerPage:" + i4 + " totalPage:" + i5 + " curPage:" + this.jiy);
        setOnItemClickListener(this.jMk);
        this.zZZ = i;
        this.jiy = i2;
        this.jiw = i3;
        this.Aaa = i4;
        this.Aab = i5;
        AppMethodBeat.m2505o(62917);
    }

    public void release() {
        this.Aac = null;
        this.voG = null;
    }

    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.m2504i(62918);
        super.setAdapter(listAdapter);
        this.f17952Ei = listAdapter;
        AppMethodBeat.m2505o(62918);
    }

    public void setOnTextOperationListener(C44073a c44073a) {
        this.Aac = c44073a;
    }

    public int getSmileyType() {
        return this.zZZ;
    }

    public void setScene(int i) {
        this.gOW = i;
    }

    /* renamed from: c */
    static /* synthetic */ void m88533c(SmileyGrid smileyGrid) {
        AppMethodBeat.m2504i(62920);
        C7060h.pYm.mo8381e(11594, Integer.valueOf(1));
        String value = C26373g.m41964Nu().getValue("ShowDesignerEmoji");
        C4990ab.m7417i("MicroMsg.emoji.SmileyGrid", "get dynamic Designer_Emoji_Store_Show config value:%s", value);
        C25985d.m41467b(smileyGrid.getContext(), "emoji", ".ui.EmojiCustomUI", new Intent());
        AppMethodBeat.m2505o(62920);
    }

    /* renamed from: a */
    static /* synthetic */ void m88530a(SmileyGrid smileyGrid, EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62921);
        if (smileyGrid.voG == null || emojiInfo == null) {
            C4990ab.m7412e("MicroMsg.emoji.SmileyGrid", "jacks npe dealCustomEmojiClick");
            AppMethodBeat.m2505o(62921);
        } else if (zZY == 2) {
            if (emojiInfo.field_catalog == EmojiGroupInfo.yas) {
                C30379h.m48467g(smileyGrid.getContext(), C25738R.string.ak9, C25738R.string.ak9).show();
            }
            AppMethodBeat.m2505o(62921);
        } else if (!smileyGrid.voG.bOf()) {
            C30379h.m48431a(smileyGrid.getContext(), (int) C25738R.string.an1, 0, new C3083516());
            AppMethodBeat.m2505o(62921);
        } else if (emojiInfo.field_type != EmojiInfo.zYX && emojiInfo.field_type != EmojiInfo.zYY) {
            C4990ab.m7417i("MicroMsg.emoji.SmileyGrid", "cpan send dealcustom emoji click emoji:%s", emojiInfo.mo20410Aq());
            final EmojiInfo n = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35657n(emojiInfo);
            if (n != null) {
                C5659a c5659a;
                switch (n.duZ()) {
                    case STATUS_SUCCESS:
                        smileyGrid.voG.mo39016A(n);
                        C4990ab.m7411d("MicroMsg.emoji.SmileyGrid", "onSendCustomEmoji emoji md5 is [%s]", n.mo20410Aq());
                        AppMethodBeat.m2505o(62921);
                        return;
                    case STATUS_MIXING:
                    case STATUS_UPLOADING:
                        C30379h.m48465bQ(smileyGrid.getContext(), smileyGrid.getContext().getString(C25738R.string.b9i));
                        AppMethodBeat.m2505o(62921);
                        return;
                    case STATUS_MIX_FAIL:
                        c5659a = new C5659a(smileyGrid.getContext());
                        c5659a.asL(smileyGrid.getContext().getString(C25738R.string.b9d)).mo11509Qg(C25738R.string.bd3).mo11510Qh(smileyGrid.getContext().getResources().getColor(C25738R.color.f12267y0));
                        c5659a.mo11523c(new C5662c() {
                            /* renamed from: d */
                            public final void mo5699d(boolean z, String str) {
                                AppMethodBeat.m2504i(62907);
                                if (z && !C5046bo.isNullOrNil(n.mo20410Aq())) {
                                    ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35610Jr(n.mo20410Aq());
                                }
                                AppMethodBeat.m2505o(62907);
                            }
                        }).show();
                        AppMethodBeat.m2505o(62921);
                        return;
                    case STATUS_UPLOAD_FAIL:
                        C4990ab.m7411d("MicroMsg.emoji.SmileyGrid", "CaptureUploadErrCode: %d.", Integer.valueOf(n.dvc().ordinal()));
                        switch (n.dvc()) {
                            case ERR_NON_NETWORK:
                            case ERR_WIFI_NETWORK:
                            case ERR_MOBILE_NETWORK:
                            case ERR_NOT_COMPLETED:
                                c5659a = new C5659a(smileyGrid.getContext());
                                c5659a.asL(smileyGrid.getContext().getString(C25738R.string.b9h)).mo11509Qg(C25738R.string.b9f);
                                c5659a.mo11523c(new C5662c() {
                                    /* renamed from: d */
                                    public final void mo5699d(boolean z, String str) {
                                        AppMethodBeat.m2504i(62908);
                                        if (z) {
                                            n.mo48510a(C30302a.STATUS_UPLOADING);
                                            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().updateEmojiInfo(n);
                                            EmojiCaptureReporter emojiCaptureReporter = new EmojiCaptureReporter();
                                            emojiCaptureReporter.ezZ = System.currentTimeMillis();
                                            emojiCaptureReporter.lgP = System.currentTimeMillis();
                                            ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35624b(new UploadTask(n.field_md5, emojiCaptureReporter));
                                        }
                                        AppMethodBeat.m2505o(62908);
                                    }
                                }).show();
                                AppMethodBeat.m2505o(62921);
                                return;
                            case ERR_OVER_LIMIT:
                                ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr();
                                C32498b c32498b = C32498b.eyD;
                                if (C32498b.m53214OF()) {
                                    c5659a = new C5659a(smileyGrid.getContext());
                                    c5659a.asL(smileyGrid.getContext().getString(C25738R.string.bd2)).zQJ = smileyGrid.getContext().getString(C25738R.string.bb0);
                                    c5659a.mo11523c(new C4441612()).show();
                                    AppMethodBeat.m2505o(62921);
                                    return;
                                }
                                break;
                            case ERR_OTHERS:
                                break;
                            case ERR_LOCAL_FILE:
                            case ERR_OVER_SIZE:
                            case ERR_SPAM:
                            case ERR_OVER_UPLOAD_TIME:
                                String string;
                                if (C30301b.ERR_LOCAL_FILE == n.dvc()) {
                                    string = smileyGrid.getContext().getString(C25738R.string.b9d);
                                } else if (C30301b.ERR_OVER_SIZE == n.dvc()) {
                                    string = smileyGrid.getContext().getString(C25738R.string.b9w);
                                } else if (C30301b.ERR_SPAM == n.dvc()) {
                                    string = smileyGrid.getContext().getString(C25738R.string.b9g);
                                } else {
                                    string = smileyGrid.getContext().getString(C25738R.string.b9e);
                                }
                                C5659a c5659a2 = new C5659a(smileyGrid.getContext());
                                c5659a2.asL(string).mo11509Qg(C25738R.string.bd3).mo11510Qh(smileyGrid.getContext().getResources().getColor(C25738R.color.f12267y0));
                                c5659a2.mo11523c(new C5662c() {
                                    /* renamed from: d */
                                    public final void mo5699d(boolean z, String str) {
                                        AppMethodBeat.m2504i(62911);
                                        if (z && !C5046bo.isNullOrNil(n.mo20410Aq())) {
                                            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35610Jr(n.mo20410Aq());
                                        }
                                        AppMethodBeat.m2505o(62911);
                                    }
                                }).show();
                                AppMethodBeat.m2505o(62921);
                                return;
                            default:
                                c5659a = new C5659a(smileyGrid.getContext());
                                c5659a.asL(smileyGrid.getContext().getString(C25738R.string.b9h)).mo11509Qg(C25738R.string.b9f);
                                c5659a.mo11523c(new C5662c() {
                                    /* renamed from: d */
                                    public final void mo5699d(boolean z, String str) {
                                        AppMethodBeat.m2504i(62912);
                                        if (z) {
                                            n.mo48510a(C30302a.STATUS_UPLOADING);
                                            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().updateEmojiInfo(n);
                                            EmojiCaptureReporter emojiCaptureReporter = new EmojiCaptureReporter();
                                            emojiCaptureReporter.ezZ = System.currentTimeMillis();
                                            emojiCaptureReporter.lgP = System.currentTimeMillis();
                                            ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35624b(new UploadTask(n.field_md5, emojiCaptureReporter));
                                        }
                                        AppMethodBeat.m2505o(62912);
                                    }
                                }).show();
                                AppMethodBeat.m2505o(62921);
                                return;
                        }
                        c5659a = new C5659a(smileyGrid.getContext());
                        c5659a.asL(smileyGrid.getContext().getString(C25738R.string.b9h)).mo11509Qg(C25738R.string.b9f);
                        c5659a.mo11523c(new C5662c() {
                            /* renamed from: d */
                            public final void mo5699d(boolean z, String str) {
                                AppMethodBeat.m2504i(62910);
                                if (z) {
                                    n.mo48510a(C30302a.STATUS_UPLOADING);
                                    ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().updateEmojiInfo(n);
                                    ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35624b(new UploadTask(n.field_md5, new EmojiCaptureReporter()));
                                }
                                AppMethodBeat.m2505o(62910);
                            }
                        }).show();
                        AppMethodBeat.m2505o(62921);
                        return;
                    default:
                        AppMethodBeat.m2505o(62921);
                        return;
                }
            }
            C4990ab.m7420w("MicroMsg.emoji.SmileyGrid", "onSendCustomEmoji error, emoji is null");
            AppMethodBeat.m2505o(62921);
        } else if (smileyGrid.voG.bOe()) {
            smileyGrid.voG.mo39017B(emojiInfo);
            C4990ab.m7411d("MicroMsg.emoji.SmileyGrid", "onSendAppMsgCustomEmoji emoji md5 is [%s]", emojiInfo.mo20410Aq());
            AppMethodBeat.m2505o(62921);
        } else {
            Toast.makeText(smileyGrid.getContext(), smileyGrid.getContext().getString(C25738R.string.an0), 0).show();
            AppMethodBeat.m2505o(62921);
        }
    }

    /* JADX WARNING: Missing block: B:20:0x019a, code skipped:
            r0 = new com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a(r9.getContext());
            r0.asL(r9.getContext().getString(com.tencent.p177mm.C25738R.string.b9h)).mo11509Qg(com.tencent.p177mm.C25738R.string.b9f);
            r0.mo11523c(new com.tencent.p177mm.view.SmileyGrid.C409235(r9)).show();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(62922);
     */
    /* JADX WARNING: Missing block: B:40:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    static /* synthetic */ void m88532b(SmileyGrid smileyGrid, final EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62922);
        if (smileyGrid.voG == null || emojiInfo == null) {
            C4990ab.m7412e("MicroMsg.emoji.SmileyGrid", "penn npe dealCaptureEmojiClick");
            AppMethodBeat.m2505o(62922);
        } else if (C5046bo.isEqual("capture", emojiInfo.field_groupId)) {
            C4990ab.m7417i("MicroMsg.emoji.SmileyGrid", "penn send capture emoji click emoji: %s status: %d.", emojiInfo.mo20410Aq(), Integer.valueOf(emojiInfo.field_captureStatus));
            C5659a c5659a;
            switch (emojiInfo.duZ()) {
                case STATUS_SUCCESS:
                    smileyGrid.voG.mo39016A(emojiInfo);
                    C4990ab.m7411d("MicroMsg.emoji.SmileyGrid", "onSendCustomEmoji emoji md5 is [%s].", emojiInfo.mo20410Aq());
                    AppMethodBeat.m2505o(62922);
                    return;
                case STATUS_MIXING:
                case STATUS_UPLOADING:
                    C30379h.m48465bQ(smileyGrid.getContext(), smileyGrid.getContext().getString(C25738R.string.b9i));
                    AppMethodBeat.m2505o(62922);
                    return;
                case STATUS_MIX_FAIL:
                    c5659a = new C5659a(smileyGrid.getContext());
                    c5659a.asL(smileyGrid.getContext().getString(C25738R.string.b9d)).mo11509Qg(C25738R.string.bd3).mo11510Qh(smileyGrid.getContext().getResources().getColor(C25738R.color.f12267y0));
                    c5659a.mo11523c(new C5662c() {
                        /* renamed from: d */
                        public final void mo5699d(boolean z, String str) {
                            AppMethodBeat.m2504i(62899);
                            if (z && !C5046bo.isNullOrNil(emojiInfo.mo20410Aq())) {
                                ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35610Jr(emojiInfo.mo20410Aq());
                            }
                            AppMethodBeat.m2505o(62899);
                        }
                    }).show();
                    AppMethodBeat.m2505o(62922);
                    return;
                case STATUS_UPLOAD_FAIL:
                    C4990ab.m7411d("MicroMsg.emoji.SmileyGrid", "CaptureUploadErrCode: %d.", Integer.valueOf(emojiInfo.dvc().ordinal()));
                    switch (emojiInfo.dvc()) {
                        case ERR_NON_NETWORK:
                        case ERR_WIFI_NETWORK:
                        case ERR_MOBILE_NETWORK:
                        case ERR_NOT_COMPLETED:
                            c5659a = new C5659a(smileyGrid.getContext());
                            c5659a.asL(smileyGrid.getContext().getString(C25738R.string.b9h)).mo11509Qg(C25738R.string.b9f);
                            c5659a.mo11523c(new C5662c() {
                                /* renamed from: d */
                                public final void mo5699d(boolean z, String str) {
                                    AppMethodBeat.m2504i(62900);
                                    if (z) {
                                        emojiInfo.mo48510a(C30302a.STATUS_UPLOADING);
                                        ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
                                        EmojiCaptureReporter emojiCaptureReporter = new EmojiCaptureReporter();
                                        emojiCaptureReporter.ezZ = System.currentTimeMillis();
                                        emojiCaptureReporter.lgP = System.currentTimeMillis();
                                        ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35624b(new UploadTask(emojiInfo.field_md5, emojiCaptureReporter));
                                    }
                                    AppMethodBeat.m2505o(62900);
                                }
                            }).show();
                            AppMethodBeat.m2505o(62922);
                            return;
                        case ERR_OVER_LIMIT:
                            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr();
                            C32498b c32498b = C32498b.eyD;
                            if (C32498b.m53214OF()) {
                                c5659a = new C5659a(smileyGrid.getContext());
                                c5659a.asL(smileyGrid.getContext().getString(C25738R.string.bd2)).zQJ = smileyGrid.getContext().getString(C25738R.string.bb0);
                                c5659a.mo11523c(new C467124()).show();
                                AppMethodBeat.m2505o(62922);
                                return;
                            }
                            break;
                        case ERR_OTHERS:
                            break;
                        case ERR_LOCAL_FILE:
                        case ERR_OVER_SIZE:
                        case ERR_SPAM:
                        case ERR_OVER_UPLOAD_TIME:
                            String string;
                            if (C30301b.ERR_LOCAL_FILE == emojiInfo.dvc()) {
                                string = smileyGrid.getContext().getString(C25738R.string.b9d);
                            } else if (C30301b.ERR_OVER_SIZE == emojiInfo.dvc()) {
                                string = smileyGrid.getContext().getString(C25738R.string.b9w);
                            } else if (C30301b.ERR_SPAM == emojiInfo.dvc()) {
                                string = smileyGrid.getContext().getString(C25738R.string.b9g);
                            } else {
                                string = smileyGrid.getContext().getString(C25738R.string.b9e);
                            }
                            C5659a c5659a2 = new C5659a(smileyGrid.getContext());
                            c5659a2.asL(string).mo11509Qg(C25738R.string.bd3).mo11510Qh(smileyGrid.getContext().getResources().getColor(C25738R.color.f12267y0));
                            c5659a2.mo11523c(new C5662c() {
                                /* renamed from: d */
                                public final void mo5699d(boolean z, String str) {
                                    AppMethodBeat.m2504i(62903);
                                    if (z && !C5046bo.isNullOrNil(emojiInfo.mo20410Aq())) {
                                        ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35610Jr(emojiInfo.mo20410Aq());
                                    }
                                    AppMethodBeat.m2505o(62903);
                                }
                            }).show();
                            AppMethodBeat.m2505o(62922);
                            return;
                        default:
                            c5659a = new C5659a(smileyGrid.getContext());
                            c5659a.asL(smileyGrid.getContext().getString(C25738R.string.b9h)).mo11509Qg(C25738R.string.b9f);
                            c5659a.mo11523c(new C5662c() {
                                /* renamed from: d */
                                public final void mo5699d(boolean z, String str) {
                                    AppMethodBeat.m2504i(62904);
                                    if (z) {
                                        emojiInfo.mo48510a(C30302a.STATUS_UPLOADING);
                                        ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
                                        EmojiCaptureReporter emojiCaptureReporter = new EmojiCaptureReporter();
                                        emojiCaptureReporter.ezZ = System.currentTimeMillis();
                                        emojiCaptureReporter.lgP = System.currentTimeMillis();
                                        ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().mo35624b(new UploadTask(emojiInfo.field_md5, emojiCaptureReporter));
                                    }
                                    AppMethodBeat.m2505o(62904);
                                }
                            }).show();
                            break;
                    }
            }
            AppMethodBeat.m2505o(62922);
        } else {
            C4990ab.m7413e("MicroMsg.emoji.SmileyGrid", "penn group err, %s.", emojiInfo.field_groupId);
            AppMethodBeat.m2505o(62922);
        }
    }
}
