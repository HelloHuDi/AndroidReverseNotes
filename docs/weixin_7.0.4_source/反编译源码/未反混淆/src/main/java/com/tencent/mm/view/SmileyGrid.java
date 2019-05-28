package com.tencent.mm.view;

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
import com.tencent.mm.R;
import com.tencent.mm.cb.e;
import com.tencent.mm.emoji.a.b;
import com.tencent.mm.emoji.a.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask;
import com.tencent.mm.plugin.emojicapture.api.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;

public class SmileyGrid extends GridView {
    public static int zZY = 1;
    public int Aaa = 0;
    private int Aab = 0;
    private a Aac;
    private boolean Aad;
    public OnItemClickListener Aae = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(62906);
            Object item = adapterView.getAdapter().getItem(i);
            if (item instanceof f) {
                int i2 = ((f) item).position;
                ((d) g.M(d.class)).getProvider().bZ(e.dqK().qL(i2), i2);
                if (SmileyGrid.this.Aac != null) {
                    String qK;
                    if (SmileyGrid.this.Aad) {
                        qK = e.dqK().qK(i2);
                    } else {
                        qK = e.dqK().getText(i2);
                    }
                    SmileyGrid.this.Aac.append(qK);
                    h.pYm.e(13470, qK.replaceAll(",", " "), Integer.valueOf(SmileyGrid.this.gOW), Integer.valueOf(1));
                }
            }
            AppMethodBeat.o(62906);
        }
    };
    public ListAdapter Ei;
    private int gOW = ChatFooterPanel.vhh;
    private OnItemClickListener jMk = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            boolean z = true;
            AppMethodBeat.i(62898);
            EmojiInfo emojiInfo;
            switch (SmileyGrid.this.zZZ) {
                case 20:
                    if (!(adapterView.getAdapter() instanceof com.tencent.mm.view.a.f) || !((com.tencent.mm.view.a.f) adapterView.getAdapter()).QD(i)) {
                        if (i != SmileyGrid.this.Ei.getCount() - 1) {
                            if ((SmileyGrid.this.jiy * (SmileyGrid.this.Aaa - 1)) + i < SmileyGrid.this.jiw) {
                                int i2 = (SmileyGrid.this.jiy * (SmileyGrid.this.Aaa - 1)) + i;
                                ((d) g.M(d.class)).getProvider().bZ(e.dqK().qL(i2), i2);
                                if (SmileyGrid.this.Aac != null) {
                                    String qK;
                                    if (SmileyGrid.this.Aad) {
                                        qK = e.dqK().qK(i2);
                                    } else {
                                        qK = e.dqK().getText(i2);
                                    }
                                    SmileyGrid.this.Aac.append(qK);
                                    h.pYm.e(13470, qK.replaceAll(",", " "), Integer.valueOf(SmileyGrid.this.gOW), Integer.valueOf(0));
                                    break;
                                }
                            }
                            AppMethodBeat.o(62898);
                            return;
                        }
                        if (SmileyGrid.this.Aac != null) {
                            SmileyGrid.this.Aac.aRg();
                        }
                        AppMethodBeat.o(62898);
                        return;
                    }
                    if (SmileyGrid.this.Aac != null) {
                        SmileyGrid.this.Aac.aRg();
                    }
                    AppMethodBeat.o(62898);
                    return;
                    break;
                case 23:
                case 25:
                    if (SmileyGrid.this.zZZ == 25 && i == 0 && SmileyGrid.this.jiy == 0 && com.tencent.mm.view.f.a.QM(SmileyGrid.this.gOW)) {
                        SmileyGrid.c(SmileyGrid.this);
                        AppMethodBeat.o(62898);
                        return;
                    }
                    emojiInfo = (EmojiInfo) SmileyGrid.this.Ei.getItem(i);
                    if (emojiInfo != null) {
                        if (SmileyGrid.this.zZZ != 25) {
                            z = false;
                        }
                        com.tencent.mm.emoji.c.a.OZ().a(z, i, emojiInfo.field_md5, emojiInfo.field_groupId, emojiInfo.field_designerID, emojiInfo.field_activityid);
                        SmileyGrid.a(SmileyGrid.this, emojiInfo);
                    }
                    AppMethodBeat.o(62898);
                    return;
                case 26:
                    if (i != 0 || SmileyGrid.this.jiy != 0 || !com.tencent.mm.view.f.a.QL(SmileyGrid.this.gOW)) {
                        emojiInfo = (EmojiInfo) SmileyGrid.this.Ei.getItem(i);
                        if (emojiInfo != null) {
                            if (SmileyGrid.this.zZZ != 25) {
                                z = false;
                            }
                            com.tencent.mm.emoji.c.a.OZ().a(z, i, emojiInfo.field_md5, emojiInfo.field_groupId, emojiInfo.field_designerID, emojiInfo.field_activityid);
                            SmileyGrid.b(SmileyGrid.this, emojiInfo);
                        }
                        AppMethodBeat.o(62898);
                        return;
                    } else if (((d) g.M(d.class)).getEmojiMgr().OT()) {
                        c.h(SmileyGrid.this.getContext(), null, com.tencent.mm.view.f.a.QK(SmileyGrid.this.gOW));
                        AppMethodBeat.o(62898);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(62898);
        }
    };
    private int jiw;
    public int jiy;
    private j voG;
    private int zZZ = 20;

    public void setCallback(j jVar) {
        this.voG = jVar;
    }

    public SmileyGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(62913);
        AppMethodBeat.o(62913);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(62914);
        super.onSizeChanged(i, i2, i3, i4);
        AppMethodBeat.o(62914);
    }

    /* Access modifiers changed, original: protected */
    @TargetApi(8)
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(62915);
        super.onConfigurationChanged(configuration);
        AppMethodBeat.o(62915);
    }

    public final void dMI() {
        AppMethodBeat.i(62916);
        setOnItemClickListener(this.jMk);
        AppMethodBeat.o(62916);
    }

    public final void j(int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(62917);
        ab.v("MicroMsg.emoji.SmileyGrid", "type:" + i + " itemsPerPage:" + i4 + " totalPage:" + i5 + " curPage:" + this.jiy);
        setOnItemClickListener(this.jMk);
        this.zZZ = i;
        this.jiy = i2;
        this.jiw = i3;
        this.Aaa = i4;
        this.Aab = i5;
        AppMethodBeat.o(62917);
    }

    public void release() {
        this.Aac = null;
        this.voG = null;
    }

    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.i(62918);
        super.setAdapter(listAdapter);
        this.Ei = listAdapter;
        AppMethodBeat.o(62918);
    }

    public void setOnTextOperationListener(a aVar) {
        this.Aac = aVar;
    }

    public int getSmileyType() {
        return this.zZZ;
    }

    public void setScene(int i) {
        this.gOW = i;
    }

    static /* synthetic */ void c(SmileyGrid smileyGrid) {
        AppMethodBeat.i(62920);
        h.pYm.e(11594, Integer.valueOf(1));
        String value = com.tencent.mm.m.g.Nu().getValue("ShowDesignerEmoji");
        ab.i("MicroMsg.emoji.SmileyGrid", "get dynamic Designer_Emoji_Store_Show config value:%s", value);
        com.tencent.mm.bp.d.b(smileyGrid.getContext(), "emoji", ".ui.EmojiCustomUI", new Intent());
        AppMethodBeat.o(62920);
    }

    static /* synthetic */ void a(SmileyGrid smileyGrid, EmojiInfo emojiInfo) {
        AppMethodBeat.i(62921);
        if (smileyGrid.voG == null || emojiInfo == null) {
            ab.e("MicroMsg.emoji.SmileyGrid", "jacks npe dealCustomEmojiClick");
            AppMethodBeat.o(62921);
        } else if (zZY == 2) {
            if (emojiInfo.field_catalog == EmojiGroupInfo.yas) {
                com.tencent.mm.ui.base.h.g(smileyGrid.getContext(), R.string.ak9, R.string.ak9).show();
            }
            AppMethodBeat.o(62921);
        } else if (!smileyGrid.voG.bOf()) {
            com.tencent.mm.ui.base.h.a(smileyGrid.getContext(), (int) R.string.an1, 0, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            AppMethodBeat.o(62921);
        } else if (emojiInfo.field_type != EmojiInfo.zYX && emojiInfo.field_type != EmojiInfo.zYY) {
            ab.i("MicroMsg.emoji.SmileyGrid", "cpan send dealcustom emoji click emoji:%s", emojiInfo.Aq());
            final EmojiInfo n = ((d) g.M(d.class)).getProvider().n(emojiInfo);
            if (n != null) {
                com.tencent.mm.ui.widget.a.e.a aVar;
                switch (n.duZ()) {
                    case STATUS_SUCCESS:
                        smileyGrid.voG.A(n);
                        ab.d("MicroMsg.emoji.SmileyGrid", "onSendCustomEmoji emoji md5 is [%s]", n.Aq());
                        AppMethodBeat.o(62921);
                        return;
                    case STATUS_MIXING:
                    case STATUS_UPLOADING:
                        com.tencent.mm.ui.base.h.bQ(smileyGrid.getContext(), smileyGrid.getContext().getString(R.string.b9i));
                        AppMethodBeat.o(62921);
                        return;
                    case STATUS_MIX_FAIL:
                        aVar = new com.tencent.mm.ui.widget.a.e.a(smileyGrid.getContext());
                        aVar.asL(smileyGrid.getContext().getString(R.string.b9d)).Qg(R.string.bd3).Qh(smileyGrid.getContext().getResources().getColor(R.color.y0));
                        aVar.c(new com.tencent.mm.ui.widget.a.e.c() {
                            public final void d(boolean z, String str) {
                                AppMethodBeat.i(62907);
                                if (z && !bo.isNullOrNil(n.Aq())) {
                                    ((d) g.M(d.class)).getEmojiMgr().Jr(n.Aq());
                                }
                                AppMethodBeat.o(62907);
                            }
                        }).show();
                        AppMethodBeat.o(62921);
                        return;
                    case STATUS_UPLOAD_FAIL:
                        ab.d("MicroMsg.emoji.SmileyGrid", "CaptureUploadErrCode: %d.", Integer.valueOf(n.dvc().ordinal()));
                        switch (n.dvc()) {
                            case ERR_NON_NETWORK:
                            case ERR_WIFI_NETWORK:
                            case ERR_MOBILE_NETWORK:
                            case ERR_NOT_COMPLETED:
                                aVar = new com.tencent.mm.ui.widget.a.e.a(smileyGrid.getContext());
                                aVar.asL(smileyGrid.getContext().getString(R.string.b9h)).Qg(R.string.b9f);
                                aVar.c(new com.tencent.mm.ui.widget.a.e.c() {
                                    public final void d(boolean z, String str) {
                                        AppMethodBeat.i(62908);
                                        if (z) {
                                            n.a(EmojiInfo.a.STATUS_UPLOADING);
                                            ((d) g.M(d.class)).getEmojiMgr().updateEmojiInfo(n);
                                            EmojiCaptureReporter emojiCaptureReporter = new EmojiCaptureReporter();
                                            emojiCaptureReporter.ezZ = System.currentTimeMillis();
                                            emojiCaptureReporter.lgP = System.currentTimeMillis();
                                            ((d) g.M(d.class)).getProvider().b(new UploadTask(n.field_md5, emojiCaptureReporter));
                                        }
                                        AppMethodBeat.o(62908);
                                    }
                                }).show();
                                AppMethodBeat.o(62921);
                                return;
                            case ERR_OVER_LIMIT:
                                ((d) g.M(d.class)).getEmojiMgr();
                                b bVar = b.eyD;
                                if (b.OF()) {
                                    aVar = new com.tencent.mm.ui.widget.a.e.a(smileyGrid.getContext());
                                    aVar.asL(smileyGrid.getContext().getString(R.string.bd2)).zQJ = smileyGrid.getContext().getString(R.string.bb0);
                                    aVar.c(new com.tencent.mm.ui.widget.a.e.c() {
                                        public final void d(boolean z, String str) {
                                            AppMethodBeat.i(62909);
                                            if (z) {
                                                Intent intent = new Intent();
                                                intent.putExtra("key_emoji_panel_type", 1);
                                                com.tencent.mm.bp.d.b(SmileyGrid.this.getContext(), "emoji", ".ui.EmojiCustomUI", intent);
                                            }
                                            AppMethodBeat.o(62909);
                                        }
                                    }).show();
                                    AppMethodBeat.o(62921);
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
                                if (EmojiInfo.b.ERR_LOCAL_FILE == n.dvc()) {
                                    string = smileyGrid.getContext().getString(R.string.b9d);
                                } else if (EmojiInfo.b.ERR_OVER_SIZE == n.dvc()) {
                                    string = smileyGrid.getContext().getString(R.string.b9w);
                                } else if (EmojiInfo.b.ERR_SPAM == n.dvc()) {
                                    string = smileyGrid.getContext().getString(R.string.b9g);
                                } else {
                                    string = smileyGrid.getContext().getString(R.string.b9e);
                                }
                                com.tencent.mm.ui.widget.a.e.a aVar2 = new com.tencent.mm.ui.widget.a.e.a(smileyGrid.getContext());
                                aVar2.asL(string).Qg(R.string.bd3).Qh(smileyGrid.getContext().getResources().getColor(R.color.y0));
                                aVar2.c(new com.tencent.mm.ui.widget.a.e.c() {
                                    public final void d(boolean z, String str) {
                                        AppMethodBeat.i(62911);
                                        if (z && !bo.isNullOrNil(n.Aq())) {
                                            ((d) g.M(d.class)).getEmojiMgr().Jr(n.Aq());
                                        }
                                        AppMethodBeat.o(62911);
                                    }
                                }).show();
                                AppMethodBeat.o(62921);
                                return;
                            default:
                                aVar = new com.tencent.mm.ui.widget.a.e.a(smileyGrid.getContext());
                                aVar.asL(smileyGrid.getContext().getString(R.string.b9h)).Qg(R.string.b9f);
                                aVar.c(new com.tencent.mm.ui.widget.a.e.c() {
                                    public final void d(boolean z, String str) {
                                        AppMethodBeat.i(62912);
                                        if (z) {
                                            n.a(EmojiInfo.a.STATUS_UPLOADING);
                                            ((d) g.M(d.class)).getEmojiMgr().updateEmojiInfo(n);
                                            EmojiCaptureReporter emojiCaptureReporter = new EmojiCaptureReporter();
                                            emojiCaptureReporter.ezZ = System.currentTimeMillis();
                                            emojiCaptureReporter.lgP = System.currentTimeMillis();
                                            ((d) g.M(d.class)).getProvider().b(new UploadTask(n.field_md5, emojiCaptureReporter));
                                        }
                                        AppMethodBeat.o(62912);
                                    }
                                }).show();
                                AppMethodBeat.o(62921);
                                return;
                        }
                        aVar = new com.tencent.mm.ui.widget.a.e.a(smileyGrid.getContext());
                        aVar.asL(smileyGrid.getContext().getString(R.string.b9h)).Qg(R.string.b9f);
                        aVar.c(new com.tencent.mm.ui.widget.a.e.c() {
                            public final void d(boolean z, String str) {
                                AppMethodBeat.i(62910);
                                if (z) {
                                    n.a(EmojiInfo.a.STATUS_UPLOADING);
                                    ((d) g.M(d.class)).getEmojiMgr().updateEmojiInfo(n);
                                    ((d) g.M(d.class)).getProvider().b(new UploadTask(n.field_md5, new EmojiCaptureReporter()));
                                }
                                AppMethodBeat.o(62910);
                            }
                        }).show();
                        AppMethodBeat.o(62921);
                        return;
                    default:
                        AppMethodBeat.o(62921);
                        return;
                }
            }
            ab.w("MicroMsg.emoji.SmileyGrid", "onSendCustomEmoji error, emoji is null");
            AppMethodBeat.o(62921);
        } else if (smileyGrid.voG.bOe()) {
            smileyGrid.voG.B(emojiInfo);
            ab.d("MicroMsg.emoji.SmileyGrid", "onSendAppMsgCustomEmoji emoji md5 is [%s]", emojiInfo.Aq());
            AppMethodBeat.o(62921);
        } else {
            Toast.makeText(smileyGrid.getContext(), smileyGrid.getContext().getString(R.string.an0), 0).show();
            AppMethodBeat.o(62921);
        }
    }

    /* JADX WARNING: Missing block: B:20:0x019a, code skipped:
            r0 = new com.tencent.mm.ui.widget.a.e.a(r9.getContext());
            r0.asL(r9.getContext().getString(com.tencent.mm.R.string.b9h)).Qg(com.tencent.mm.R.string.b9f);
            r0.c(new com.tencent.mm.view.SmileyGrid.AnonymousClass5(r9)).show();
            com.tencent.matrix.trace.core.AppMethodBeat.o(62922);
     */
    /* JADX WARNING: Missing block: B:40:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(SmileyGrid smileyGrid, final EmojiInfo emojiInfo) {
        AppMethodBeat.i(62922);
        if (smileyGrid.voG == null || emojiInfo == null) {
            ab.e("MicroMsg.emoji.SmileyGrid", "penn npe dealCaptureEmojiClick");
            AppMethodBeat.o(62922);
        } else if (bo.isEqual("capture", emojiInfo.field_groupId)) {
            ab.i("MicroMsg.emoji.SmileyGrid", "penn send capture emoji click emoji: %s status: %d.", emojiInfo.Aq(), Integer.valueOf(emojiInfo.field_captureStatus));
            com.tencent.mm.ui.widget.a.e.a aVar;
            switch (emojiInfo.duZ()) {
                case STATUS_SUCCESS:
                    smileyGrid.voG.A(emojiInfo);
                    ab.d("MicroMsg.emoji.SmileyGrid", "onSendCustomEmoji emoji md5 is [%s].", emojiInfo.Aq());
                    AppMethodBeat.o(62922);
                    return;
                case STATUS_MIXING:
                case STATUS_UPLOADING:
                    com.tencent.mm.ui.base.h.bQ(smileyGrid.getContext(), smileyGrid.getContext().getString(R.string.b9i));
                    AppMethodBeat.o(62922);
                    return;
                case STATUS_MIX_FAIL:
                    aVar = new com.tencent.mm.ui.widget.a.e.a(smileyGrid.getContext());
                    aVar.asL(smileyGrid.getContext().getString(R.string.b9d)).Qg(R.string.bd3).Qh(smileyGrid.getContext().getResources().getColor(R.color.y0));
                    aVar.c(new com.tencent.mm.ui.widget.a.e.c() {
                        public final void d(boolean z, String str) {
                            AppMethodBeat.i(62899);
                            if (z && !bo.isNullOrNil(emojiInfo.Aq())) {
                                ((d) g.M(d.class)).getEmojiMgr().Jr(emojiInfo.Aq());
                            }
                            AppMethodBeat.o(62899);
                        }
                    }).show();
                    AppMethodBeat.o(62922);
                    return;
                case STATUS_UPLOAD_FAIL:
                    ab.d("MicroMsg.emoji.SmileyGrid", "CaptureUploadErrCode: %d.", Integer.valueOf(emojiInfo.dvc().ordinal()));
                    switch (emojiInfo.dvc()) {
                        case ERR_NON_NETWORK:
                        case ERR_WIFI_NETWORK:
                        case ERR_MOBILE_NETWORK:
                        case ERR_NOT_COMPLETED:
                            aVar = new com.tencent.mm.ui.widget.a.e.a(smileyGrid.getContext());
                            aVar.asL(smileyGrid.getContext().getString(R.string.b9h)).Qg(R.string.b9f);
                            aVar.c(new com.tencent.mm.ui.widget.a.e.c() {
                                public final void d(boolean z, String str) {
                                    AppMethodBeat.i(62900);
                                    if (z) {
                                        emojiInfo.a(EmojiInfo.a.STATUS_UPLOADING);
                                        ((d) g.M(d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
                                        EmojiCaptureReporter emojiCaptureReporter = new EmojiCaptureReporter();
                                        emojiCaptureReporter.ezZ = System.currentTimeMillis();
                                        emojiCaptureReporter.lgP = System.currentTimeMillis();
                                        ((d) g.M(d.class)).getProvider().b(new UploadTask(emojiInfo.field_md5, emojiCaptureReporter));
                                    }
                                    AppMethodBeat.o(62900);
                                }
                            }).show();
                            AppMethodBeat.o(62922);
                            return;
                        case ERR_OVER_LIMIT:
                            ((d) g.M(d.class)).getEmojiMgr();
                            b bVar = b.eyD;
                            if (b.OF()) {
                                aVar = new com.tencent.mm.ui.widget.a.e.a(smileyGrid.getContext());
                                aVar.asL(smileyGrid.getContext().getString(R.string.bd2)).zQJ = smileyGrid.getContext().getString(R.string.bb0);
                                aVar.c(new com.tencent.mm.ui.widget.a.e.c() {
                                    public final void d(boolean z, String str) {
                                        AppMethodBeat.i(62901);
                                        if (z) {
                                            Intent intent = new Intent();
                                            intent.putExtra("key_emoji_panel_type", 1);
                                            com.tencent.mm.bp.d.b(SmileyGrid.this.getContext(), "emoji", ".ui.EmojiCustomUI", intent);
                                        }
                                        AppMethodBeat.o(62901);
                                    }
                                }).show();
                                AppMethodBeat.o(62922);
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
                            if (EmojiInfo.b.ERR_LOCAL_FILE == emojiInfo.dvc()) {
                                string = smileyGrid.getContext().getString(R.string.b9d);
                            } else if (EmojiInfo.b.ERR_OVER_SIZE == emojiInfo.dvc()) {
                                string = smileyGrid.getContext().getString(R.string.b9w);
                            } else if (EmojiInfo.b.ERR_SPAM == emojiInfo.dvc()) {
                                string = smileyGrid.getContext().getString(R.string.b9g);
                            } else {
                                string = smileyGrid.getContext().getString(R.string.b9e);
                            }
                            com.tencent.mm.ui.widget.a.e.a aVar2 = new com.tencent.mm.ui.widget.a.e.a(smileyGrid.getContext());
                            aVar2.asL(string).Qg(R.string.bd3).Qh(smileyGrid.getContext().getResources().getColor(R.color.y0));
                            aVar2.c(new com.tencent.mm.ui.widget.a.e.c() {
                                public final void d(boolean z, String str) {
                                    AppMethodBeat.i(62903);
                                    if (z && !bo.isNullOrNil(emojiInfo.Aq())) {
                                        ((d) g.M(d.class)).getEmojiMgr().Jr(emojiInfo.Aq());
                                    }
                                    AppMethodBeat.o(62903);
                                }
                            }).show();
                            AppMethodBeat.o(62922);
                            return;
                        default:
                            aVar = new com.tencent.mm.ui.widget.a.e.a(smileyGrid.getContext());
                            aVar.asL(smileyGrid.getContext().getString(R.string.b9h)).Qg(R.string.b9f);
                            aVar.c(new com.tencent.mm.ui.widget.a.e.c() {
                                public final void d(boolean z, String str) {
                                    AppMethodBeat.i(62904);
                                    if (z) {
                                        emojiInfo.a(EmojiInfo.a.STATUS_UPLOADING);
                                        ((d) g.M(d.class)).getEmojiMgr().updateEmojiInfo(emojiInfo);
                                        EmojiCaptureReporter emojiCaptureReporter = new EmojiCaptureReporter();
                                        emojiCaptureReporter.ezZ = System.currentTimeMillis();
                                        emojiCaptureReporter.lgP = System.currentTimeMillis();
                                        ((d) g.M(d.class)).getProvider().b(new UploadTask(emojiInfo.field_md5, emojiCaptureReporter));
                                    }
                                    AppMethodBeat.o(62904);
                                }
                            }).show();
                            break;
                    }
            }
            AppMethodBeat.o(62922);
        } else {
            ab.e("MicroMsg.emoji.SmileyGrid", "penn group err, %s.", emojiInfo.field_groupId);
            AppMethodBeat.o(62922);
        }
    }
}
