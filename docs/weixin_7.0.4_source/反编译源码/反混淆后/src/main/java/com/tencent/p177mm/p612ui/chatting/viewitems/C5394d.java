package com.tencent.p177mm.p612ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C26415ao.C9635b.C9636a;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelappbrand.C32809i;
import com.tencent.p177mm.modelappbrand.C32809i.C32807a;
import com.tencent.p177mm.modelappbrand.C42202a;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C9676i;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.modelstat.C42219a;
import com.tencent.p177mm.modelstat.C42219a.C32832a;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p181af.C25747e;
import com.tencent.p177mm.p181af.C32222n;
import com.tencent.p177mm.p181af.C37436r;
import com.tencent.p177mm.p181af.C41728a;
import com.tencent.p177mm.p181af.C45138g;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p181af.C8909j.C8913a;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p187al.C37458c;
import com.tencent.p177mm.p187al.C37461f;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C32292p.C32293a;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p1527d.C37477b;
import com.tencent.p177mm.p190at.p191a.p193c.C9014g;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18348nt;
import com.tencent.p177mm.p230g.p231a.C26165ii;
import com.tencent.p177mm.p230g.p231a.C32599lz;
import com.tencent.p177mm.p230g.p231a.C9321dq;
import com.tencent.p177mm.p235i.C18496c;
import com.tencent.p177mm.p235i.C42129a;
import com.tencent.p177mm.p235i.C42130g;
import com.tencent.p177mm.p235i.C42130g.C1628a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.C5510e.C5506m;
import com.tencent.p177mm.p612ui.MMImageView;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.p177mm.p612ui.chatting.C40788j;
import com.tencent.p177mm.p612ui.chatting.C44288am;
import com.tencent.p177mm.p612ui.chatting.C44318s.C36201j;
import com.tencent.p177mm.p612ui.chatting.C44318s.C40802i;
import com.tencent.p177mm.p612ui.chatting.C44318s.C40803l;
import com.tencent.p177mm.p612ui.chatting.C44318s.C5365n;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36133b;
import com.tencent.p177mm.p612ui.chatting.p616c.p759b.C36137j;
import com.tencent.p177mm.p612ui.chatting.viewitems.C30613r.C30616d;
import com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.C5379a;
import com.tencent.p177mm.p612ui.tools.ShowImageUI;
import com.tencent.p177mm.p612ui.transmit.MsgRetransmitUI;
import com.tencent.p177mm.p612ui.widget.MMNeat7extView;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.config.WxaExposedParams.C19154a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.p328r.C38496n;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.brandservice.p1241a.C20023b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C11263c;
import com.tencent.p177mm.plugin.brandservice.p926b.C11188a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C46210i;
import com.tencent.p177mm.plugin.topstory.p539a.C39964g;
import com.tencent.p177mm.plugin.topstory.p539a.C46297h;
import com.tencent.p177mm.plugin.websearch.api.C14420ab;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.pluginsdk.C30033c.C23234a;
import com.tencent.p177mm.pluginsdk.C30034d;
import com.tencent.p177mm.pluginsdk.C44068p.C14896a;
import com.tencent.p177mm.pluginsdk.model.C30080q;
import com.tencent.p177mm.pluginsdk.model.C44065o;
import com.tencent.p177mm.pluginsdk.model.app.C14875aj;
import com.tencent.p177mm.pluginsdk.model.app.C14877am;
import com.tencent.p177mm.pluginsdk.model.app.C30065b;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.pluginsdk.model.app.C4733l;
import com.tencent.p177mm.pluginsdk.model.app.C7237j.C7238a;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35838f;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.p1338b.p1339a.C44099c;
import com.tencent.p177mm.protocal.protobuf.aar;
import com.tencent.p177mm.protocal.protobuf.cvi;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.wav.WavFileHeader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.ui.chatting.viewitems.d */
public final class C5394d {

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.d$e */
    public static class C5395e extends C5378c implements C5365n {
        private boolean rEF = false;
        private C46650a yJI;
        protected C40802i zcO;
        protected C40803l zcP;
        protected C36201j zcQ;

        /* renamed from: com.tencent.mm.ui.chatting.viewitems.d$e$9 */
        class C54029 implements OnClickListener {
            C54029() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        public final boolean dHk() {
            return true;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z && (i == 49 || i == 335544369 || i == 402653233 || i == 369098801)) {
                return true;
            }
            return false;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32852);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969085);
                view.setTag(new C5410c().mo11055y(view, false));
            }
            AppMethodBeat.m2505o(32852);
            return view;
        }

        /* JADX WARNING: Missing block: B:216:0x0a21, code skipped:
            r8 = 1;
     */
        /* JADX WARNING: Missing block: B:217:0x0a25, code skipped:
            if (r8 != null) goto L_0x16db;
     */
        /* JADX WARNING: Missing block: B:219:0x0a2b, code skipped:
            if (com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.dHm() == false) goto L_0x0bb9;
     */
        /* JADX WARNING: Missing block: B:220:0x0a2d, code skipped:
            com.tencent.p177mm.p612ui.chatting.viewitems.C5394d.C5395e.m8195a((com.tencent.p177mm.p612ui.chatting.viewitems.C5394d.C5410c) r20, (com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h) r27.mo74857aF(com.tencent.p177mm.p612ui.chatting.p616c.p759b.C15612h.class), r28);
     */
        /* JADX WARNING: Missing block: B:221:0x0a42, code skipped:
            if (r20.pyf == null) goto L_0x16db;
     */
        /* JADX WARNING: Missing block: B:222:0x0a44, code skipped:
            r20.pyf.setVisibility(8);
            r7 = r8;
            r12 = r6;
     */
        /* JADX WARNING: Missing block: B:242:0x0bbd, code skipped:
            if (r20.pyf == null) goto L_0x16db;
     */
        /* JADX WARNING: Missing block: B:243:0x0bbf, code skipped:
            r20.pyf.setVisibility(0);
     */
        /* JADX WARNING: Missing block: B:244:0x0bcc, code skipped:
            if (r28.getStatus() < 2) goto L_0x16db;
     */
        /* JADX WARNING: Missing block: B:245:0x0bce, code skipped:
            r20.pyf.setVisibility(8);
            r7 = r8;
            r12 = r6;
     */
        /* JADX WARNING: Missing block: B:493:0x16d6, code skipped:
            r7 = null;
            r12 = r6;
     */
        /* JADX WARNING: Missing block: B:494:0x16db, code skipped:
            r7 = r8;
            r12 = r6;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            C32222n mj;
            C8910b c8910b;
            Object obj;
            AppMethodBeat.m2504i(32853);
            C5379a c5379a2 = (C5410c) c5379a;
            this.yJI = c46650a;
            ((C36137j) c46650a.mo74857aF(C36137j.class)).mo57030bg(c7620bi);
            c5379a2.reset();
            String str2 = c7620bi.field_content;
            ((C36137j) c46650a.mo74857aF(C36137j.class)).mo57028be(c7620bi);
            if (str2 != null) {
                C8910b X = C8910b.m16058X(str2, c7620bi.field_reserved);
                mj = C32222n.m52572mj(str2);
                c8910b = X;
            } else {
                mj = null;
                c8910b = null;
            }
            C40814ay c40814ay = new C40814ay(c7620bi, c46650a.dFx(), i, null, 0);
            Object obj2 = null;
            if (c8910b != null) {
                final C46650a c46650a2;
                boolean z;
                Object obj3;
                C40814ay c40814ay2;
                Bitmap b;
                C40439f dX = C46494g.m87742dX(c8910b.appId, c8910b.axy);
                c5379a2.gnB.setText(c8910b.title);
                c5379a2.gnC.setText(c8910b.description);
                c5379a2.zbN.setMaxLines(1);
                c5379a2.gnB.setTextColor(c46650a.yTx.getContext().getResources().getColor(C25738R.color.f12212w4));
                c5379a2.gnC.setTextColor(c46650a.yTx.getContext().getResources().getColor(C25738R.color.f12092s0));
                c5379a2.zcd.setBackgroundResource(C25738R.drawable.b0t);
                c5379a2.zcd.setPadding(0, c46650a.yTx.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9966lo), 0, 0);
                c5379a2.zbI.setVisibility(0);
                c5379a2.zcb.setVisibility(0);
                c5379a2.gnC.setVisibility(0);
                c5379a2.zcf.setVisibility(8);
                c5379a2.zcg.setVisibility(8);
                c5379a2.zbS.setVisibility(8);
                c5379a2.zbR.setVisibility(8);
                c5379a2.zbO.setVisibility(8);
                c5379a2.zbL.setVisibility(8);
                c5379a2.zbK.setVisibility(8);
                c5379a2.zcq.setVisibility(8);
                c5379a2.zcj.setVisibility(8);
                c5379a2.zcd.setVisibility(0);
                c5379a2.zcv.setVisibility(8);
                c5379a2.zcC.setVisibility(8);
                C5379a.m8170an(c5379a2.zcc, c5379a2.zcJ);
                String str3 = (dX == null || dX.field_appName == null || dX.field_appName.trim().length() <= 0) ? c8910b.appName : dX.field_appName;
                boolean z2 = true;
                C1338a.fromDPToPix(c46650a.yTx.getContext(), 12);
                if (c8910b.type == 20 || "wxaf060266bfa9a35c".equals(c8910b.appId)) {
                    z2 = C14896a.dgQ().cjQ();
                }
                if (z2 && c8910b.appId != null && c8910b.appId.length() > 0 && C46494g.m87743dg(str3)) {
                    c5379a2.moL.setText(C46494g.m87733b(c46650a.yTx.getContext(), dX, str3));
                    c5379a2.zbM.setVisibility(0);
                    c5379a2.moL.setVisibility(0);
                    c5379a2.moL.setCompoundDrawables(null, null, null, null);
                    c5379a2.zbJ.setVisibility(0);
                    if (dX == null || !dX.mo63847xy()) {
                        C5378c.m8126a(c46650a, (View) c5379a2.moL, c8910b.appId);
                    } else {
                        C5378c.m8124a(c46650a, (View) c5379a2.moL, c7620bi, c8910b, dX.field_packageName, c7620bi.field_msgSvrId);
                    }
                    c5379a2.zbJ.setImageResource(C25738R.drawable.f6579ir);
                    C5378c.m8128a(c46650a, c5379a2.zbJ, c8910b.appId);
                } else if (c8910b.type == 24) {
                    c5379a2.moL.setText(C4996ah.getContext().getString(C25738R.string.bnl));
                    c5379a2.zbM.setVisibility(0);
                    c5379a2.moL.setVisibility(0);
                    c5379a2.zbJ.setVisibility(8);
                } else if (c8910b.type == 19 || mj.fju == 19) {
                    c5379a2.moL.setText(C4996ah.getContext().getString(C25738R.string.alu));
                    c5379a2.zbM.setVisibility(0);
                    c5379a2.moL.setVisibility(0);
                    c5379a2.zbJ.setVisibility(8);
                } else if (!C5394d.m8193a(c8910b, (C5410c) c5379a2)) {
                    c5379a2.zbM.setVisibility(8);
                    c5379a2.moL.setVisibility(8);
                    c5379a2.zbJ.setVisibility(8);
                }
                boolean z3 = false;
                c5379a2.zbI.setVisibility(0);
                if (this.kuU) {
                    Bitmap bitmap = null;
                    if (!(c8910b.type == 33 || c8910b.type == 36 || c8910b.type == 44 || C5406b.arC(c7620bi.field_imgPath))) {
                        bitmap = C32291o.ahl().mo73087a(c7620bi.field_imgPath, C1338a.getDensity(c46650a.yTx.getContext()), false);
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        z3 = true;
                    } else {
                        c5379a2.zbI.setImageBitmap(bitmap);
                    }
                    if (c8910b.type == 3) {
                        final C5410c c5410c = c5379a2;
                        c46650a2 = c46650a;
                        c5379a2.zcd.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                            private boolean zcR = false;

                            public final boolean onPreDraw() {
                                AppMethodBeat.m2504i(32839);
                                if (this.zcR) {
                                    c5410c.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                    AppMethodBeat.m2505o(32839);
                                } else {
                                    c5410c.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                    this.zcR = true;
                                    int fromDPToPix = C1338a.fromDPToPix(c46650a2.yTx.getContext(), 24);
                                    Bitmap bitmap = bitmap;
                                    if (bitmap == null || bitmap.isRecycled()) {
                                        bitmap = C5056d.m7644au(c46650a2.yTx.getContext().getResources().getColor(C25738R.color.f11868k0), fromDPToPix, fromDPToPix);
                                    }
                                    int height = bitmap.getHeight();
                                    if (fromDPToPix <= height) {
                                        height = fromDPToPix;
                                    }
                                    Bitmap e = C5056d.m7660e(C5056d.m7639al(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
                                    height = c5410c.zcd.getHeight();
                                    int width = c5410c.zcd.getWidth();
                                    if (height == 0) {
                                        height = C1338a.m2856al(c46650a2.yTx.getContext(), C25738R.dimen.f10296x5);
                                    }
                                    if (width == 0) {
                                        width = C1338a.m2856al(c46650a2.yTx.getContext(), C25738R.dimen.f10297x6);
                                    }
                                    c5410c.zcd.setBackgroundDrawable(new BitmapDrawable(C5056d.m7614a(e, (int) C25738R.drawable.b0t, width, height)));
                                    AppMethodBeat.m2505o(32839);
                                }
                                return true;
                            }
                        });
                    }
                    z = z3;
                } else {
                    c5379a2.zbI.setImageBitmap(BitmapFactory.decodeResource(c46650a.yTx.getMMResources(), C25738R.drawable.ak9));
                    z = false;
                }
                c5379a2.zbT.setOnClickListener(null);
                Bitmap b2;
                WxaAttributes zb;
                CharSequence charSequence;
                Object charSequence2;
                final C5379a c5379a3;
                switch (c8910b.type) {
                    case 0:
                        if (c8910b.title == null || c8910b.title.length() <= 0) {
                            c5379a2.gnB.setVisibility(8);
                        } else {
                            c5379a2.gnB.setVisibility(0);
                        }
                        c5379a2.gnC.setVisibility(0);
                        c5379a2.zbN.setVisibility(8);
                        c5379a2.zbO.setVisibility(8);
                        c5379a2.zbT.setVisibility(4);
                        c5379a2.gnC.setMaxLines(2);
                        if (z) {
                            b2 = C46494g.m87732b(c8910b.appId, 1, C1338a.getDensity(c46650a.getContext()));
                            if (b2 != null && !b2.isRecycled()) {
                                c5379a2.zbI.setImageBitmap(b2);
                                obj3 = null;
                                c40814ay2 = c40814ay;
                                break;
                            }
                            c5379a2.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                            obj3 = null;
                            c40814ay2 = c40814ay;
                            break;
                        }
                        break;
                    case 3:
                        if (c8910b.title == null || c8910b.title.length() <= 0) {
                            c5379a2.gnB.setVisibility(8);
                        } else {
                            c5379a2.gnB.setVisibility(0);
                            c5379a2.gnB.setTextColor(c46650a.yTx.getContext().getResources().getColor(C25738R.color.a69));
                        }
                        c5379a2.gnC.setVisibility(0);
                        c5379a2.gnC.setTextColor(c46650a.yTx.getContext().getResources().getColor(C25738R.color.a69));
                        c5379a2.zbN.setVisibility(8);
                        c5379a2.zbO.setVisibility(4);
                        c5379a2.gnC.setMaxLines(2);
                        c5379a2.zbT.setVisibility(0);
                        if ((c7620bi.field_msgId).equals(c5379a.zbz)) {
                            c5379a2.zbT.setImageResource(C25738R.drawable.f6930vq);
                        } else {
                            c5379a2.zbT.setImageResource(C25738R.drawable.f6932vs);
                        }
                        C5404f c5404f = new C5404f();
                        c5404f.cvx = c7620bi.field_msgId;
                        c5404f.cHz = c7620bi.field_content;
                        c5404f.imgPath = c7620bi.field_imgPath;
                        c5379a2.zbT.setTag(c5404f);
                        c5379a2.zbT.setOnClickListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dDa());
                        if (z) {
                            b2 = C46494g.m87732b(c8910b.appId, 1, C1338a.getDensity(c46650a.yTx.getContext()));
                            if (b2 == null || b2.isRecycled()) {
                                c5379a2.zbI.setImageResource(C1318a.app_attach_file_icon_music);
                            } else {
                                c5379a2.zbI.setImageBitmap(b2);
                            }
                        }
                        if (!C5378c.dHm()) {
                            if (c5379a2.pyf != null) {
                                c5379a2.pyf.setVisibility(0);
                                if (c7620bi.field_status >= 2) {
                                    c5379a2.pyf.setVisibility(8);
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                            }
                        } else if (c5379a2.pyf != null) {
                            c5379a2.pyf.setVisibility(8);
                            obj3 = null;
                            c40814ay2 = c40814ay;
                            break;
                        }
                        break;
                    case 4:
                        if (c8910b.title == null || c8910b.title.length() <= 0) {
                            c5379a2.gnB.setVisibility(8);
                        } else {
                            c5379a2.gnB.setVisibility(0);
                        }
                        c5379a2.gnC.setVisibility(0);
                        c5379a2.zbN.setVisibility(8);
                        c5379a2.gnC.setMaxLines(2);
                        c5379a2.zbO.setVisibility(4);
                        c5379a2.zbT.setVisibility(0);
                        c5379a2.zbT.setImageResource(C25738R.drawable.a4k);
                        if (z) {
                            b2 = C46494g.m87732b(c8910b.appId, 1, C1338a.getDensity(c46650a.yTx.getContext()));
                            if (b2 == null || b2.isRecycled()) {
                                c5379a2.zbI.setImageResource(C1318a.app_attach_file_icon_video);
                            } else {
                                c5379a2.zbI.setImageBitmap(b2);
                            }
                            c5379a2.zbT.setVisibility(8);
                            obj3 = null;
                            c40814ay2 = c40814ay;
                            break;
                        }
                        break;
                    case 5:
                        C25747e c25747e = (C25747e) c8910b.mo20333X(C25747e.class);
                        if (c25747e == null || c25747e.fgb != 1 || c25747e.ffZ != 5 || !((C20023b) C1720g.m3528K(C20023b.class)).aVP()) {
                            c5379a2.gnB.setVisibility(8);
                            if (c8910b.title == null || c8910b.title.length() <= 0) {
                                c5379a2.zbN.setVisibility(8);
                            } else {
                                c5379a2.zbN.setMaxLines(2);
                                c5379a2.zbN.setVisibility(0);
                                c5379a2.zbN.setText(c8910b.title);
                            }
                            c5379a2.gnC.setMaxLines(3);
                            c5379a2.zbO.setVisibility(4);
                            if (C5394d.m8194h(c8910b)) {
                                c5379a2.zbT.setImageResource(C25738R.drawable.a4k);
                                c5379a2.zbT.setVisibility(0);
                            } else {
                                c5379a2.zbT.setVisibility(8);
                            }
                            if (z) {
                                b2 = C46494g.m87732b(c8910b.appId, 1, C1338a.getDensity(c46650a.yTx.getContext()));
                                if (b2 == null) {
                                    C17927a c17927a = new C17927a();
                                    c17927a.ePT = C1318a.app_attach_file_icon_webpage;
                                    c17927a.ePG = true;
                                    c17927a.ePK = C43217c.bGF();
                                    c17927a.mo33448ct(C1338a.fromDPToPix(C4996ah.getContext(), 50), C1338a.fromDPToPix(C4996ah.getContext(), 50)).ePF = true;
                                    C32291o.ahp().mo43766a(C5046bo.isNullOrNil(c8910b.thumburl) ? c8910b.fgv : c8910b.thumburl, c5379a2.zbI, c17927a.ahG());
                                } else if (b2.isRecycled()) {
                                    c5379a2.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                                } else {
                                    c5379a2.zbI.setImageBitmap(b2);
                                }
                            }
                            if (C5378c.dHm()) {
                                C5395e.m8195a((C5410c) c5379a2, (C15612h) c46650a.mo74857aF(C15612h.class), c7620bi);
                                if (c5379a2.pyf != null) {
                                    c5379a2.pyf.setVisibility(8);
                                }
                            } else if (c5379a2.pyf != null) {
                                c5379a2.pyf.setVisibility(0);
                                if (c7620bi.field_status >= 2) {
                                    c5379a2.pyf.setVisibility(8);
                                }
                            }
                            if (c8910b != null) {
                                int ad = C32798u.m53583ad(mo11017b(c46650a, c7620bi), c46650a.getTalkerUserName());
                                int i2 = -1;
                                c25747e = (C25747e) c8910b.mo20333X(C25747e.class);
                                if (c25747e != null) {
                                    i2 = c25747e.ffZ;
                                }
                                ((C20023b) C1720g.m3528K(C20023b.class)).mo6749a(c8910b.url, i2, 1, Long.valueOf(c7620bi.field_msgSvrId), str, Integer.valueOf(ad));
                                if (!(this.rEF || i2 == -1 || !((C20023b) C1720g.m3528K(C20023b.class)).mo6758rW(23))) {
                                    this.rEF = true;
                                    ((C20023b) C1720g.m3528K(C20023b.class)).mo6759rX(1);
                                }
                                obj3 = null;
                                c40814ay2 = c40814ay;
                                break;
                            }
                        }
                        C5410c.m8217a(c46650a, (C5410c) c5379a2, c8910b, c7620bi, z);
                        obj3 = null;
                        c40814ay2 = c40814ay;
                        break;
                        break;
                    case 6:
                        if (c8910b.title == null || c8910b.title.length() <= 0) {
                            c5379a2.gnB.setVisibility(8);
                        } else {
                            c5379a2.gnB.setVisibility(0);
                            c5379a2.gnB.setMaxLines(2);
                        }
                        c5379a2.gnC.setVisibility(0);
                        c5379a2.zbN.setVisibility(8);
                        c5379a2.zbO.setVisibility(4);
                        c5379a2.gnC.setMaxLines(2);
                        c5379a2.gnC.setText(C5046bo.m7565ga((long) c8910b.fgo));
                        c5379a2.zbT.setVisibility(8);
                        C5410c.m8220a(c5379a2, str2, c8910b.fgo);
                        C5410c.m8219a((C5410c) c5379a2, Boolean.FALSE, c7620bi, c8910b.csD, c8910b.title);
                        if (z) {
                            if (!C5046bo.any(c8910b.fgp)) {
                                c5379a2.zbI.setImageResource(C44065o.aiD(c8910b.fgp));
                                obj3 = null;
                                c40814ay2 = c40814ay;
                                break;
                            }
                            c5379a2.zbI.setImageResource(C25738R.drawable.aay);
                            obj3 = null;
                            c40814ay2 = c40814ay;
                            break;
                        }
                        break;
                    case 7:
                        c5379a2.gnB.setVisibility(8);
                        if (c8910b.title == null || c8910b.title.length() <= 0) {
                            c5379a2.zbN.setVisibility(8);
                        } else {
                            c5379a2.zbN.setMaxLines(2);
                            c5379a2.zbN.setVisibility(0);
                            c5379a2.zbN.setText(c8910b.title);
                        }
                        c5379a2.gnC.setMaxLines(3);
                        c5379a2.zbO.setVisibility(4);
                        c5379a2.zbT.setVisibility(8);
                        if (z) {
                            b2 = C46494g.m87732b(c8910b.appId, 1, C1338a.getDensity(c46650a.getContext()));
                            if (b2 == null || b2.isRecycled()) {
                                c5379a2.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                            } else {
                                c5379a2.zbI.setImageBitmap(b2);
                            }
                        }
                        if (!C5378c.dHm()) {
                            if (c5379a2.pyf != null) {
                                c5379a2.pyf.setVisibility(0);
                                if (c7620bi.getStatus() >= 2) {
                                    c5379a2.pyf.setVisibility(8);
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                            }
                        } else if (c5379a2.pyf != null) {
                            c5379a2.pyf.setVisibility(8);
                            obj3 = null;
                            c40814ay2 = c40814ay;
                            break;
                        }
                        break;
                    case 10:
                        c5379a2.zbN.setVisibility(0);
                        if (c8910b.fgP == 1) {
                            c5379a2.zbN.setText(C25738R.string.dyb);
                        } else if (c8910b.fgP == 2) {
                            c5379a2.zbN.setText(C25738R.string.dyd);
                        } else if (c8910b.fgP == 3) {
                            c5379a2.zbN.setText(C25738R.string.dyc);
                        } else {
                            c5379a2.zbN.setText(C25738R.string.dye);
                        }
                        if (c8910b.title != null && c8910b.title.length() > 0) {
                            c5379a2.gnB.setVisibility(0);
                            c5379a2.gnB.setText(c8910b.title);
                        }
                        c5379a2.gnC.setMaxLines(4);
                        c5379a2.zbO.setVisibility(4);
                        c5379a2.zbT.setVisibility(8);
                        if (z) {
                            b2 = C32291o.ahl().mo73104b(c7620bi.mo14770HF(), C1338a.getDensity(c46650a.getContext()), false);
                            if (b2 != null && !b2.isRecycled()) {
                                c5379a2.zbI.setImageBitmap(b2);
                                obj3 = null;
                                c40814ay2 = c40814ay;
                                break;
                            }
                            c5379a2.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                            obj3 = null;
                            c40814ay2 = c40814ay;
                            break;
                        }
                        break;
                    case 13:
                        c5379a2.gnB.setVisibility(0);
                        c5379a2.gnB.setText(c8910b.title);
                        c5379a2.zbN.setVisibility(0);
                        c5379a2.zbN.setText(C25738R.string.amu);
                        c5379a2.gnC.setMaxLines(4);
                        c5379a2.zbO.setVisibility(4);
                        c5379a2.zbT.setVisibility(8);
                        if (z) {
                            b2 = C32291o.ahl().mo73104b(c7620bi.mo14770HF(), C1338a.getDensity(c46650a.getContext()), false);
                            if (b2 != null && !b2.isRecycled()) {
                                c5379a2.zbI.setImageBitmap(b2);
                                obj3 = null;
                                c40814ay2 = c40814ay;
                                break;
                            }
                            c5379a2.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                            obj3 = null;
                            c40814ay2 = c40814ay;
                            break;
                        }
                        break;
                    case 15:
                        if (c8910b.title == null || c8910b.title.length() <= 0) {
                            c5379a2.gnB.setVisibility(8);
                        } else {
                            c5379a2.gnB.setVisibility(0);
                        }
                        c5379a2.gnC.setVisibility(0);
                        c5379a2.zbN.setVisibility(8);
                        c5379a2.zbT.setVisibility(8);
                        c5379a2.zbO.setVisibility(4);
                        c5379a2.gnC.setMaxLines(2);
                        if (z) {
                            b = C32291o.ahl().mo73104b(c7620bi.mo14770HF(), C1338a.getDensity(c46650a.getContext()), false);
                            if (b == null || b.isRecycled()) {
                                c5379a2.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                            } else {
                                c5379a2.zbI.setImageBitmap(b);
                            }
                        }
                        c40814ay = new C40814ay(c7620bi, false, i, "", false, c46650a.dDw(), c8910b.cMg, c8910b.cMh, c8910b.title, c8910b.fgX, c8910b.url, false, false);
                        c5379a2.zcc.setTag(c40814ay);
                        c5379a2.zcc.setOnClickListener(mo11030i(c46650a));
                        obj2 = 1;
                        obj3 = null;
                        c40814ay2 = c40814ay;
                        break;
                    case 16:
                        c5379a2.gnB.setVisibility(0);
                        c5379a2.gnB.setText(c8910b.description);
                        c5379a2.gnC.setText(c8910b.fhC);
                        if (c8910b.title == null || c8910b.title.length() <= 0) {
                            c5379a2.zbN.setVisibility(8);
                        } else {
                            c5379a2.zbN.setVisibility(0);
                            c5379a2.zbN.setText(c8910b.title);
                        }
                        c5379a2.gnC.setMaxLines(4);
                        c5379a2.zbO.setVisibility(4);
                        c5379a2.zbT.setVisibility(8);
                        if (z) {
                            b2 = C32291o.ahl().mo73104b(c7620bi.mo14770HF(), C1338a.getDensity(c46650a.getContext()), false);
                            if (b2 == null) {
                                c5379a2.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                                obj3 = null;
                                c40814ay2 = c40814ay;
                                break;
                            }
                            c5379a2.zbI.setImageBitmap(b2);
                            obj3 = null;
                            c40814ay2 = c40814ay;
                            break;
                        }
                        break;
                    case 19:
                        C5410c.m8218a(c46650a, c5379a2, c8910b, z);
                        if (!C5378c.dHm()) {
                            if (c5379a2.pyf != null) {
                                c5379a2.pyf.setVisibility(0);
                                if (c7620bi.getStatus() >= 2) {
                                    c5379a2.pyf.setVisibility(8);
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                            }
                        }
                        C5395e.m8195a((C5410c) c5379a2, (C15612h) c46650a.mo74857aF(C15612h.class), c7620bi);
                        if (c5379a2.pyf != null) {
                            c5379a2.pyf.setVisibility(8);
                            obj3 = null;
                            c40814ay2 = c40814ay;
                            break;
                        }
                    case 20:
                        if (c8910b.title != null && c8910b.title.length() > 0) {
                            c5379a2.gnB.setVisibility(0);
                            c5379a2.gnB.setText(c8910b.title);
                            c5379a2.zbN.setVisibility(8);
                        }
                        c5379a2.gnC.setMaxLines(4);
                        c5379a2.zbO.setVisibility(4);
                        c5379a2.zbT.setVisibility(8);
                        if (z) {
                            b2 = C32291o.ahl().mo73104b(c7620bi.mo14770HF(), C1338a.getDensity(c46650a.getContext()), false);
                            if (b2 != null && !b2.isRecycled()) {
                                c5379a2.zbI.setImageBitmap(b2);
                                obj3 = null;
                                c40814ay2 = c40814ay;
                                break;
                            }
                            c5379a2.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                            obj3 = null;
                            c40814ay2 = c40814ay;
                            break;
                        }
                        break;
                    case 24:
                        c5379a2.gnB.setVisibility(8);
                        c5379a2.zbN.setVisibility(0);
                        if (c8910b.title == null || c8910b.title.length() <= 0) {
                            c5379a2.zbN.setText(C44089j.m79294b(c5379a2.zbN.getContext(), C4996ah.getContext().getString(C25738R.string.bsc), (int) c5379a2.zbN.getTextSize()));
                        } else {
                            c5379a2.zbN.setText(C44089j.m79294b(c5379a2.zbN.getContext(), c8910b.title, (int) c5379a2.zbN.getTextSize()));
                        }
                        c5379a2.gnC.setMaxLines(3);
                        c5379a2.zbO.setVisibility(4);
                        c5379a2.zbT.setVisibility(8);
                        if (z) {
                            c5379a2.zbI.setVisibility(8);
                        }
                        C5410c.m8221b(c46650a, c5379a2, c8910b, c7620bi, z);
                        if (!C5378c.dHm()) {
                            if (c5379a2.pyf != null) {
                                c5379a2.pyf.setVisibility(0);
                                if (c7620bi.getStatus() >= 2) {
                                    c5379a2.pyf.setVisibility(8);
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                            }
                        }
                        C5395e.m8195a((C5410c) c5379a2, (C15612h) c46650a.mo74857aF(C15612h.class), c7620bi);
                        if (c5379a2.pyf != null) {
                            c5379a2.pyf.setVisibility(8);
                            obj3 = null;
                            c40814ay2 = c40814ay;
                            break;
                        }
                        break;
                    case 25:
                        if (c8910b.title == null || c8910b.title.length() <= 0) {
                            c5379a2.gnB.setVisibility(8);
                        } else {
                            c5379a2.gnB.setVisibility(0);
                        }
                        c5379a2.gnC.setVisibility(0);
                        c5379a2.zbN.setVisibility(8);
                        c5379a2.zbT.setVisibility(8);
                        c5379a2.zbO.setVisibility(4);
                        c5379a2.gnC.setMaxLines(2);
                        if (z) {
                            b = C32291o.ahl().mo73104b(c7620bi.mo14770HF(), C1338a.getDensity(c46650a.getContext()), false);
                            if (b == null || b.isRecycled()) {
                                c5379a2.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                            } else {
                                c5379a2.zbI.setImageBitmap(b);
                            }
                        }
                        c40814ay = new C40814ay(c7620bi, i, "", c46650a.dDw(), c8910b.cMg, c8910b.cMh, c8910b.title, c8910b.fiD, c8910b.designerName, c8910b.designerRediretctUrl, c8910b.url);
                        c5379a2.zcc.setTag(c40814ay);
                        FrameLayout frameLayout = c5379a2.zcc;
                        if (this.zcO == null) {
                            this.zcO = new C40802i(c46650a);
                        }
                        frameLayout.setOnClickListener(this.zcO);
                        obj2 = 1;
                        obj3 = null;
                        c40814ay2 = c40814ay;
                        break;
                    case 26:
                    case 27:
                        if (c8910b.title == null || c8910b.title.length() <= 0) {
                            c5379a2.gnB.setVisibility(8);
                        } else {
                            c5379a2.gnB.setVisibility(0);
                        }
                        c5379a2.gnC.setVisibility(0);
                        c5379a2.zbN.setVisibility(8);
                        c5379a2.zbT.setVisibility(8);
                        c5379a2.zbO.setVisibility(4);
                        c5379a2.gnC.setMaxLines(2);
                        if (z) {
                            if (C5046bo.isNullOrNil(c7620bi.mo14770HF())) {
                                C32291o.ahp().mo43765a(c8910b.thumburl, c5379a2.zbI);
                            } else {
                                b = C32291o.ahl().mo73104b(c7620bi.mo14770HF(), C1338a.getDensity(c46650a.getContext()), false);
                                if (b == null || b.isRecycled()) {
                                    c5379a2.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                                } else {
                                    c5379a2.zbI.setImageBitmap(b);
                                }
                            }
                        }
                        c40814ay2 = new C40814ay();
                        c40814ay2.cKd = c7620bi;
                        c40814ay2.yFW = false;
                        c40814ay2.position = i;
                        c40814ay2.zis = false;
                        c40814ay2.title = c46650a.dDw();
                        c40814ay2.cMg = c8910b.cMg;
                        c40814ay2.cMh = c8910b.cMh;
                        c40814ay2.zit = c8910b.title;
                        FrameLayout frameLayout2;
                        if (c8910b.type == 26) {
                            c40814ay2.tid = c8910b.tid;
                            c40814ay2.fiE = c8910b.fiE;
                            c40814ay2.desc = c8910b.desc;
                            c40814ay2.iconUrl = c8910b.iconUrl;
                            c40814ay2.secondUrl = c8910b.secondUrl;
                            c40814ay2.pageType = c8910b.pageType;
                            frameLayout2 = c5379a2.zcc;
                            if (this.zcP == null) {
                                this.zcP = new C40803l(c46650a);
                            }
                            frameLayout2.setOnClickListener(this.zcP);
                            obj = 1;
                        } else if (c8910b.type == 27) {
                            c40814ay2.tid = c8910b.tid;
                            c40814ay2.fiE = c8910b.fiE;
                            c40814ay2.desc = c8910b.desc;
                            c40814ay2.iconUrl = c8910b.iconUrl;
                            c40814ay2.secondUrl = c8910b.secondUrl;
                            c40814ay2.pageType = c8910b.pageType;
                            frameLayout2 = c5379a2.zcc;
                            if (this.zcQ == null) {
                                this.zcQ = new C36201j(c46650a);
                            }
                            frameLayout2.setOnClickListener(this.zcQ);
                            obj = 1;
                        } else {
                            C4990ab.m7416i("MicroMsg.ChattingItemAppMsgTo", "unknow view type");
                            obj = null;
                        }
                        c5379a2.zcc.setTag(c40814ay2);
                        obj3 = null;
                        obj2 = obj;
                        break;
                    case 33:
                        zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(c8910b.fiP);
                        switch (c8910b.fiR) {
                            case 0:
                                c5379a2.zbM.setVisibility(0);
                                c5379a2.zbJ.setVisibility(0);
                                c5379a2.zbJ.setBackground(null);
                                c5379a2.zbJ.setImageResource(C1318a.app_brand_we_app_logo_share);
                                C5394d.m8192a(c5379a2.moL, c8910b);
                                break;
                            case 1:
                                if (zb != null) {
                                    charSequence2 = zb.field_nickname;
                                } else {
                                    charSequence2 = c8910b.title;
                                }
                                str3 = zb != null ? zb.field_smallHeadURL : null;
                                c5379a2.zcd.setVisibility(8);
                                c5379a2.zcq.setVisibility(8);
                                c5379a2.zcj.setVisibility(0);
                                c5379a2.zcl.setText(charSequence2);
                                c5379a2.zcv.setVisibility(8);
                                if (!C5046bo.isNullOrNil(str3)) {
                                    C37926b.abR().mo60683a(c5379a2.zck, str3, C32804a.abQ(), C42201f.fqH);
                                    charSequence2 = null;
                                    break;
                                }
                                C37926b.abR().mo60683a(c5379a2.zck, "file://".concat(String.valueOf(C32291o.ahl().mo73123so(c7620bi.mo14770HF()))), C32804a.abQ(), C42201f.fqH);
                                charSequence2 = null;
                                break;
                            case 2:
                            case 3:
                                if (zb != null) {
                                    charSequence2 = zb.field_nickname;
                                } else {
                                    charSequence2 = c8910b.cMh;
                                }
                                if (zb != null) {
                                    str3 = zb.field_smallHeadURL;
                                } else {
                                    str3 = c8910b.fjb;
                                }
                                c5379a2.zcd.setVisibility(8);
                                c5379a2.zcq.setVisibility(0);
                                c5379a2.zcj.setVisibility(8);
                                c5379a2.zcm.setVisibility(8);
                                c5379a2.zcv.setVisibility(8);
                                c5379a2.zct.setText(c8910b.title);
                                c5379a2.zcm.setText(c8910b.description);
                                c5379a2.zco.setText(charSequence2);
                                C5394d.m8192a(c5379a2.zcp, c8910b);
                                C32291o.ahp().mo43766a(str3, c5379a2.zcn, C30616d.zel);
                                str3 = C32291o.ahl().mo73123so(c7620bi.field_imgPath);
                                c5379a2.zcr.setImageBitmap(null);
                                c5379a3 = c5379a2;
                                C37926b.abR().mo60686a(new C9676i() {
                                    public final void abU() {
                                    }

                                    /* renamed from: x */
                                    public final void mo6524x(Bitmap bitmap) {
                                        AppMethodBeat.m2504i(32840);
                                        if (bitmap == null || bitmap.isRecycled()) {
                                            c5379a3.zcr.setVisibility(4);
                                            c5379a3.zcs.setVisibility(0);
                                            AppMethodBeat.m2505o(32840);
                                            return;
                                        }
                                        c5379a3.zcr.setImageBitmap(bitmap);
                                        c5379a3.zcr.setVisibility(0);
                                        c5379a3.zcs.setVisibility(4);
                                        AppMethodBeat.m2505o(32840);
                                    }

                                    /* renamed from: mr */
                                    public final void mo6522mr() {
                                    }

                                    /* renamed from: wP */
                                    public final String mo6523wP() {
                                        AppMethodBeat.m2504i(32841);
                                        String str = "CHAT#" + C38496n.m65148bE(this);
                                        AppMethodBeat.m2505o(32841);
                                        return str;
                                    }
                                }, "file://".concat(String.valueOf(str3)), null, ((C32809i) C1720g.m3528K(C32809i.class)).mo22292cq(240, C33250az.CTRL_INDEX));
                                charSequence2 = null;
                                break;
                        }
                        break;
                    case 34:
                        if (c8910b.title == null || c8910b.title.length() <= 0) {
                            c5379a2.gnB.setVisibility(8);
                        } else {
                            c5379a2.gnB.setVisibility(0);
                            if (C5046bo.isNullOrNil(c8910b.fhL)) {
                                c5379a2.gnB.setTextColor(c46650a.getContext().getResources().getColor(C25738R.color.f11782h4));
                            } else if (C5046bo.isNullOrNil(c8910b.fhL)) {
                                c5379a2.gnB.setTextColor(c46650a.getContext().getResources().getColor(C25738R.color.f11782h4));
                            } else {
                                c5379a2.gnB.setTextColor(C5046bo.m7530bS(c8910b.fhL, c46650a.getContext().getResources().getColor(C25738R.color.f11782h4)));
                            }
                        }
                        c5379a2.gnC.setMaxLines(2);
                        c5379a2.gnC.setVisibility(0);
                        if (C5046bo.isNullOrNil(c8910b.fhM)) {
                            c5379a2.gnC.setTextColor(c46650a.getContext().getResources().getColor(C25738R.color.f12073rb));
                        } else {
                            c5379a2.gnC.setTextColor(C5046bo.m7530bS(c8910b.fhM, c46650a.getContext().getResources().getColor(C25738R.color.f12073rb)));
                        }
                        c5379a2.zbN.setVisibility(8);
                        c5379a2.zbO.setVisibility(4);
                        c5379a2.zbT.setVisibility(8);
                        c5379a2.zbM.setVisibility(0);
                        c5379a2.moL.setVisibility(0);
                        if (C5046bo.isNullOrNil(c8910b.fhH)) {
                            c5379a2.moL.setText(C25738R.string.als);
                        } else {
                            c5379a2.moL.setText(c8910b.fhH);
                        }
                        if (!this.kuU) {
                            c5379a2.zbI.setImageBitmap(BitmapFactory.decodeResource(c46650a.yTx.getMMResources(), C25738R.drawable.ak9));
                            obj3 = null;
                            c40814ay2 = c40814ay;
                            break;
                        }
                        b2 = C32291o.ahl().mo73111e(c7620bi.mo14770HF(), C1338a.getDensity(c46650a.getContext()));
                        if (!(b2 == null || b2.isRecycled())) {
                            c5379a2.zbI.setImageBitmap(C5056d.m7616a(b2, false, (float) (b2.getWidth() / 2)));
                        }
                        if (!C5046bo.isNullOrNil(c8910b.fhK)) {
                            c5379a3 = c5379a2;
                            c46650a2 = c46650a;
                            C32291o.ahp().mo43767a(c8910b.fhK, new ImageView(c46650a.getContext()), new C17927a().ahD().ahG(), new C9014g() {
                                /* renamed from: sH */
                                public final void mo7596sH(String str) {
                                }

                                /* renamed from: a */
                                public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
                                    return null;
                                }

                                /* renamed from: b */
                                public final void mo7595b(String str, View view, C37477b c37477b) {
                                    AppMethodBeat.m2504i(32848);
                                    if (c37477b.bitmap != null) {
                                        final Bitmap bitmap = c37477b.bitmap;
                                        c5379a3.zcd.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                                            public final boolean onPreDraw() {
                                                AppMethodBeat.m2504i(32847);
                                                c5379a3.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                                int height = c5379a3.zcd.getHeight();
                                                int width = c5379a3.zcd.getWidth();
                                                if (height == 0) {
                                                    height = C1338a.m2856al(c46650a2.yTx.getContext(), C25738R.dimen.f10296x5);
                                                }
                                                if (width == 0) {
                                                    width = C1338a.m2856al(c46650a2.yTx.getContext(), C25738R.dimen.f10297x6);
                                                }
                                                c5379a3.zcd.setBackgroundDrawable(new BitmapDrawable(C5056d.m7614a(bitmap, (int) C25738R.drawable.b0t, width, height)));
                                                AppMethodBeat.m2505o(32847);
                                                return true;
                                            }
                                        });
                                    }
                                    AppMethodBeat.m2505o(32848);
                                }
                            });
                            obj3 = null;
                            c40814ay2 = c40814ay;
                            break;
                        }
                        c5379a3 = c5379a2;
                        c46650a2 = c46650a;
                        c5379a2.zcd.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                            private boolean zcR = false;

                            public final boolean onPreDraw() {
                                AppMethodBeat.m2504i(32849);
                                if (this.zcR) {
                                    c5379a3.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                    AppMethodBeat.m2505o(32849);
                                } else {
                                    c5379a3.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                    this.zcR = true;
                                    int fromDPToPix = C1338a.fromDPToPix(c46650a2.yTx.getContext(), 24);
                                    Bitmap bitmap = b2;
                                    if (bitmap == null || bitmap.isRecycled()) {
                                        bitmap = C5056d.m7644au(c46650a2.yTx.getContext().getResources().getColor(C25738R.color.f11868k0), fromDPToPix, fromDPToPix);
                                    }
                                    int height = bitmap.getHeight();
                                    if (fromDPToPix <= height) {
                                        height = fromDPToPix;
                                    }
                                    Bitmap e = C5056d.m7660e(C5056d.m7639al(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
                                    height = c5379a3.zcd.getHeight();
                                    int width = c5379a3.zcd.getWidth();
                                    if (height == 0) {
                                        height = C1338a.m2856al(c46650a2.yTx.getContext(), C25738R.dimen.f10296x5);
                                    }
                                    if (width == 0) {
                                        width = C1338a.m2856al(c46650a2.yTx.getContext(), C25738R.dimen.f10297x6);
                                    }
                                    c5379a3.zcd.setBackgroundDrawable(new BitmapDrawable(C5056d.m7614a(e, (int) C25738R.drawable.b0t, width, height)));
                                    AppMethodBeat.m2505o(32849);
                                }
                                return true;
                            }
                        });
                        obj3 = null;
                        c40814ay2 = c40814ay;
                        break;
                        break;
                    case 36:
                        zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(c8910b.fiP);
                        if (zb != null) {
                            charSequence2 = zb.field_nickname;
                        } else {
                            charSequence2 = c8910b.cMh;
                        }
                        if (zb != null) {
                            str3 = zb.field_smallHeadURL;
                        } else {
                            str3 = c8910b.fjb;
                        }
                        c5379a2.zcd.setVisibility(8);
                        c5379a2.zcq.setVisibility(0);
                        c5379a2.zcj.setVisibility(8);
                        c5379a2.zcm.setVisibility(8);
                        c5379a2.zcv.setVisibility(8);
                        c5379a2.zct.setText(c8910b.title);
                        c5379a2.zcm.setText(c8910b.description);
                        c5379a2.zco.setText(charSequence2);
                        C5394d.m8192a(c5379a2.zcp, c8910b);
                        C32291o.ahp().mo43766a(str3, c5379a2.zcn, C30616d.zel);
                        String c = C32291o.ahl().mo73108c(c7620bi.field_imgPath, false, true);
                        c5379a2.zcr.setImageBitmap(null);
                        C37926b.abR().mo60684a(c5379a2.zcr, "file://".concat(String.valueOf(c)), null, null, ((C32809i) C1720g.m3528K(C32809i.class)).mo22292cq(240, C33250az.CTRL_INDEX));
                        if (!C5378c.dHm()) {
                            if (c5379a2.pyf != null) {
                                c5379a2.pyf.setVisibility(0);
                                if (c7620bi.field_status >= 2) {
                                    c5379a2.pyf.setVisibility(8);
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                            }
                        }
                        C5395e.m8195a((C5410c) c5379a2, (C15612h) c46650a.mo74857aF(C15612h.class), c7620bi);
                        if (c5379a2.pyf != null) {
                            c5379a2.pyf.setVisibility(8);
                            obj3 = null;
                            c40814ay2 = c40814ay;
                            break;
                        }
                    case 40:
                        if (mj.fju == 19) {
                            C5410c.m8218a(c46650a, c5379a2, c8910b, z);
                            obj3 = null;
                            c40814ay2 = c40814ay;
                            break;
                        }
                    case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                        if (!c8910b.mo20336cw(false)) {
                            obj3 = 1;
                            c40814ay2 = c40814ay;
                            break;
                        }
                        str3 = c8910b.mo20339p(c46650a.getContext(), false);
                        if (!C5046bo.isNullOrNil(str3)) {
                            c5379a2.zcB.setText(str3);
                            c5379a2.zcd.setVisibility(8);
                            c5379a2.zcq.setVisibility(8);
                            c5379a2.zcj.setVisibility(8);
                            c5379a2.zcv.setVisibility(0);
                            c5379a2.zcw.setText(c8910b.title);
                            c5379a2.zcx.setText(c8910b.description);
                            if (C8913a.BUSINESS_MY_LIFE_AROUND.ordinal() == c8910b.fiW) {
                                c5379a2.zcA.setImageResource(C1318a.my_life_around_default_icon);
                            } else if (C8913a.BUSINESS_OTHER.ordinal() == c8910b.fiW) {
                                c5379a3 = c5379a2;
                                C32291o.aho().mo53003a(c8910b.fjb, new C32293a() {
                                    /* renamed from: i */
                                    public final void mo11044i(String str, final Bitmap bitmap) {
                                        AppMethodBeat.m2504i(32843);
                                        C5004al.m7441d(new Runnable() {
                                            public final void run() {
                                                AppMethodBeat.m2504i(32842);
                                                c5379a3.zcA.setImageBitmap(bitmap);
                                                AppMethodBeat.m2505o(32842);
                                            }
                                        });
                                        AppMethodBeat.m2505o(32843);
                                    }
                                });
                            }
                            str3 = C32291o.ahl().mo73123so(c7620bi.mo14770HF());
                            c5379a2.zcz.setImageBitmap(null);
                            c5379a3 = c5379a2;
                            C37926b.abR().mo60686a(new C9676i() {
                                public final void abU() {
                                    AppMethodBeat.m2504i(32844);
                                    c5379a3.zcz.setVisibility(4);
                                    c5379a3.zcy.setVisibility(0);
                                    AppMethodBeat.m2505o(32844);
                                }

                                /* renamed from: x */
                                public final void mo6524x(Bitmap bitmap) {
                                    AppMethodBeat.m2504i(32845);
                                    if (!(bitmap == null || bitmap.isRecycled())) {
                                        c5379a3.zcz.setImageBitmap(bitmap);
                                        c5379a3.zcz.setVisibility(0);
                                        c5379a3.zcy.setVisibility(4);
                                    }
                                    AppMethodBeat.m2505o(32845);
                                }

                                /* renamed from: mr */
                                public final void mo6522mr() {
                                }

                                /* renamed from: wP */
                                public final String mo6523wP() {
                                    AppMethodBeat.m2504i(32846);
                                    String str = "CHAT#" + C38496n.m65148bE(this);
                                    AppMethodBeat.m2505o(32846);
                                    return str;
                                }
                            }, "file://".concat(String.valueOf(str3)), null, ((C32809i) C1720g.m3528K(C32809i.class)).mo22287a(240, 120, C32807a.DECODE_TYPE_ORIGIN));
                            obj3 = null;
                            c40814ay2 = c40814ay;
                            break;
                        }
                        obj3 = 1;
                        c40814ay2 = c40814ay;
                        break;
                    default:
                        obj3 = 1;
                        c40814ay2 = c40814ay;
                        break;
                }
                if (obj3 != null) {
                    if (c8910b.title == null || c8910b.title.length() <= 0) {
                        c5379a2.zbN.setVisibility(8);
                    } else {
                        c5379a2.zbN.setVisibility(0);
                        c5379a2.zbN.setMaxLines(2);
                        c5379a2.zbN.setText(c8910b.title);
                    }
                    c5379a2.gnB.setVisibility(8);
                    if (z) {
                        if (c8910b.type == 33 || c8910b.type == 36 || c8910b.type == 44) {
                            String so = C32291o.ahl().mo73123so(c7620bi.mo14770HF());
                            c5379a2.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                            C37926b.abR().mo60684a(c5379a2.zbI, "file://".concat(String.valueOf(so)), null, null, ((C32809i) C1720g.m3528K(C32809i.class)).mo22292cq(50, 50));
                            obj = c40814ay2;
                        } else {
                            b = C32291o.ahl().mo73104b(c7620bi.mo14770HF(), C1338a.getDensity(c46650a.getContext()), false);
                            if (b == null || b.isRecycled()) {
                                b = C32291o.ahl().mo73111e(c7620bi.mo14770HF(), C1338a.getDensity(c46650a.getContext()));
                            }
                            if (b == null || b.isRecycled()) {
                                c5379a2.zbI.setImageResource(C25738R.drawable.aay);
                            } else {
                                c5379a2.zbI.setImageBitmap(b);
                                c40814ay = c40814ay2;
                            }
                        }
                    }
                }
                c40814ay = c40814ay2;
            }
            if (obj2 == null) {
                c5379a2.zcc.setTag(obj);
                c5379a2.zcc.setOnClickListener(mo11022d(c46650a));
            }
            if (this.kuU) {
                c5379a2.zcc.setOnLongClickListener(mo11021c(c46650a));
                c5379a2.zcc.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
            }
            mo11007a(i, c5379a2, c7620bi, c46650a.dFu(), c46650a.dFx(), c46650a, (C5365n) this);
            AppMethodBeat.m2505o(32853);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32855);
            int i = ((C40814ay) view.getTag()).position;
            if (c7620bi.field_content == null) {
                AppMethodBeat.m2505o(32855);
                return true;
            }
            C8910b me = C8910b.m16064me(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
            if (me == null) {
                AppMethodBeat.m2505o(32855);
                return true;
            }
            boolean aex;
            C40439f bT = C46494g.m87739bT(me.appId, false);
            if (C46494g.m87750i(bT) && !C40788j.m70653aA(c7620bi)) {
                contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.dr1));
            }
            if ((c7620bi.field_status == 2 || c7620bi.dJz == 1) && C5378c.m8135a(c7620bi, this.yJI) && C5378c.arB(c7620bi.field_talker) && !C7616ad.m13549mg(this.yJI.getTalkerUserName())) {
                contextMenu.add(i, 123, 0, view.getContext().getString(C25738R.string.ami));
            }
            switch (me.type) {
                case 1:
                    aex = C17903f.aex();
                    break;
                case 2:
                    aex = C17903f.aey();
                    break;
                case 3:
                    aex = C17903f.aeH();
                    break;
                case 4:
                    aex = C17903f.aez();
                    break;
                case 5:
                    aex = C17903f.aeD();
                    break;
                case 6:
                    aex = C17903f.aeF();
                    if (!C5046bo.any(me.fgp)) {
                        contextMenu.add(i, 150, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.amd));
                        break;
                    }
                    break;
                case 8:
                    aex = C17903f.aeB();
                    break;
                case 16:
                    if (me.fhD != 5 && me.fhD != 6 && me.fhD != 2) {
                        aex = false;
                        break;
                    }
                    if (me.fhD != 2) {
                        contextMenu.clear();
                    }
                    contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
                    AppMethodBeat.m2505o(32855);
                    return false;
                    break;
                case 34:
                    contextMenu.clear();
                    contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
                    AppMethodBeat.m2505o(32855);
                    return false;
                default:
                    aex = false;
                    break;
            }
            if (aex && !this.yJI.dFy()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(C25738R.string.am3));
            }
            if (C25985d.afj("favorite") && (bT == null || !bT.mo63847xy())) {
                switch (me.type) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 10:
                    case 13:
                    case 19:
                    case 20:
                    case 24:
                        contextMenu.add(i, 116, 0, view.getContext().getString(C25738R.string.dcq));
                        break;
                }
            }
            C9321dq c9321dq = new C9321dq();
            c9321dq.cxc.cvx = c7620bi.field_msgId;
            C4879a.xxA.mo10055m(c9321dq);
            if (c9321dq.cxd.cwB || C5406b.m8211a(this.yJI.yTx.getContext(), me)) {
                contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(C25738R.string.amc));
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            }
            AppMethodBeat.m2505o(32855);
            return true;
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32856);
            String str;
            C8910b me;
            switch (menuItem.getItemId()) {
                case 100:
                    AppMethodBeat.m2505o(32856);
                    break;
                case 103:
                    str = c7620bi.field_content;
                    if (str == null) {
                        AppMethodBeat.m2505o(32856);
                        break;
                    }
                    me = C8910b.m16064me(str);
                    if (me != null) {
                        switch (me.type) {
                            case 16:
                                C26165ii c26165ii = new C26165ii();
                                c26165ii.cDs.cDt = me.cDt;
                                c26165ii.cDs.cuQ = c7620bi.field_msgId;
                                c26165ii.cDs.cDu = c7620bi.field_talker;
                                C4879a.xxA.mo10055m(c26165ii);
                        }
                    }
                case 111:
                    C5406b.m8210a(c46650a, c7620bi, mo11017b(c46650a, c7620bi));
                    AppMethodBeat.m2505o(32856);
                    break;
                case 114:
                    str = c7620bi.field_content;
                    if (str != null) {
                        me = C8910b.m16064me(str);
                        if (me != null) {
                            switch (me.type) {
                                case 1:
                                    C44288am.m80035m(C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend), c46650a.yTx.getContext());
                                    break;
                                case 2:
                                    C44288am.m80025a(c7620bi, c46650a.yTx.getContext(), mo11017b(c46650a, c7620bi), c46650a.dFx());
                                    break;
                                case 3:
                                    C44288am.m80026a(c7620bi, C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend), c46650a.yTx.getContext());
                                    break;
                                case 4:
                                    C44288am.m80031c(c7620bi, c46650a.yTx.getContext());
                                    break;
                                case 5:
                                    C44288am.m80032c(c7620bi, C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend), c46650a.yTx.getContext());
                                    break;
                                case 6:
                                    C44288am.m80030b(c7620bi, C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend), c46650a.yTx.getContext());
                                    break;
                                case 8:
                                    C44288am.m80033d(c7620bi, c46650a.yTx.getContext());
                                    break;
                            }
                        }
                        AppMethodBeat.m2505o(32856);
                        break;
                    }
                    AppMethodBeat.m2505o(32856);
                    break;
                default:
                    AppMethodBeat.m2505o(32856);
                    break;
            }
            return false;
        }

        /* JADX WARNING: Missing block: B:14:0x004f, code skipped:
            if (r3.url == null) goto L_0x0cac;
     */
        /* JADX WARNING: Missing block: B:16:0x005a, code skipped:
            if (r3.url.equals("") != false) goto L_0x0cac;
     */
        /* JADX WARNING: Missing block: B:18:0x0062, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r3.canvasPageXml) != false) goto L_0x0a59;
     */
        /* JADX WARNING: Missing block: B:19:0x0064, code skipped:
            r2 = new android.content.Intent();
            r2.putExtra("sns_landig_pages_from_source", 5);
            r2.putExtra("msg_id", r18.field_msgId);
            r2.putExtra("sns_landing_pages_xml", r3.canvasPageXml);
            r2.putExtra("sns_landing_pages_share_thumb_url", r18.field_imgPath);
            r2.addFlags(268435456);
            com.tencent.p177mm.p842bp.C25985d.m41467b(r17.yTx.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", r2);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(32857);
     */
        /* JADX WARNING: Missing block: B:39:0x01c3, code skipped:
            if (mo11015a(r17, r3, r18) == false) goto L_0x01ce;
     */
        /* JADX WARNING: Missing block: B:40:0x01c5, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(32857);
     */
        /* JADX WARNING: Missing block: B:41:0x01ce, code skipped:
            r4 = com.tencent.p177mm.pluginsdk.model.app.C35799p.m58684B(r3.url, com.facebook.share.internal.ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            r5 = com.tencent.p177mm.pluginsdk.model.app.C35799p.m58684B(r3.fgn, com.facebook.share.internal.ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            r2 = com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.getPackageInfo(r17.yTx.getContext(), r3.appId);
     */
        /* JADX WARNING: Missing block: B:42:0x01ee, code skipped:
            if (r2 != null) goto L_0x0210;
     */
        /* JADX WARNING: Missing block: B:43:0x01f0, code skipped:
            r6 = null;
     */
        /* JADX WARNING: Missing block: B:44:0x01f1, code skipped:
            if (r2 != null) goto L_0x0213;
     */
        /* JADX WARNING: Missing block: B:45:0x01f3, code skipped:
            r7 = 0;
     */
        /* JADX WARNING: Missing block: B:46:0x01f4, code skipped:
            mo11008a(r17, r4, r5, r6, r7, r3.appId, true, r18.field_msgId, r18.field_msgSvrId, r18);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(32857);
     */
        /* JADX WARNING: Missing block: B:47:0x0210, code skipped:
            r6 = r2.versionName;
     */
        /* JADX WARNING: Missing block: B:48:0x0213, code skipped:
            r7 = r2.versionCode;
     */
        /* JADX WARNING: Missing block: B:208:0x0a59, code skipped:
            r2 = (com.tencent.p177mm.plugin.websearch.api.C14420ab) r3.mo20333X(com.tencent.p177mm.plugin.websearch.api.C14420ab.class);
     */
        /* JADX WARNING: Missing block: B:209:0x0a61, code skipped:
            if (r2 == null) goto L_0x0aea;
     */
        /* JADX WARNING: Missing block: B:211:0x0a69, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r2.uaa) != false) goto L_0x0aea;
     */
        /* JADX WARNING: Missing block: B:212:0x0a6b, code skipped:
            r3 = new com.tencent.p177mm.protocal.protobuf.cvi();
            r3.uaa = r2.uaa;
            r3.uab = r2.uab;
            r3.uac = r2.uac;
            r3.uad = r2.uad;
            r3.uae = r2.uae;
            r3.uai = r2.uai;
            r3.lvz = r2.lvz;
            r3.lvA = r2.lvA;
            r3.qVw = r2.qVw;
            r3.uaf = r2.uaf;
            r3.uag = r2.uag;
            r3.uah = r2.uah;
            r3.source = r2.source;
            r3.phw = r2.phw;
            r3.uaj = r2.uaj;
            r3.ual = r2.ual;
            r3.uam = r2.uam;
            r3.uan = r2.uan;
            r3.uak = r2.uak;
            com.tencent.p177mm.plugin.websearch.api.C46400aa.m87323a(r17.yTx.getContext(), com.tencent.p177mm.plugin.topstory.p539a.C39964g.m68429a(r3, 32, r17.yTx.getContext().getString(com.tencent.p177mm.C25738R.string.c2a)));
            com.tencent.p177mm.plugin.topstory.p539a.C46297h.m86866a(r3, r18);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(32857);
     */
        /* JADX WARNING: Missing block: B:213:0x0aea, code skipped:
            r4 = r3.url;
     */
        /* JADX WARNING: Missing block: B:214:0x0af0, code skipped:
            if (r17.dFx() == false) goto L_0x0c8f;
     */
        /* JADX WARNING: Missing block: B:215:0x0af2, code skipped:
            r2 = "groupmessage";
     */
        /* JADX WARNING: Missing block: B:216:0x0af5, code skipped:
            r2 = com.tencent.p177mm.pluginsdk.model.app.C35799p.m58684B(r4, r2);
            r4 = r3.url;
            r5 = com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.getPackageInfo(r17.yTx.getContext(), r3.appId);
            r6 = new android.content.Intent();
            r6.putExtra("rawUrl", r2);
            r6.putExtra("webpageTitle", r3.title);
     */
        /* JADX WARNING: Missing block: B:217:0x0b1e, code skipped:
            if (r3.appId == null) goto L_0x0b54;
     */
        /* JADX WARNING: Missing block: B:219:0x0b29, code skipped:
            if ("wx751a1acca5688ba3".equals(r3.appId) != false) goto L_0x0b41;
     */
        /* JADX WARNING: Missing block: B:221:0x0b34, code skipped:
            if ("wxfbc915ff7c30e335".equals(r3.appId) != false) goto L_0x0b41;
     */
        /* JADX WARNING: Missing block: B:223:0x0b3f, code skipped:
            if ("wx482a4001c37e2b74".equals(r3.appId) == false) goto L_0x0b54;
     */
        /* JADX WARNING: Missing block: B:224:0x0b41, code skipped:
            r2 = new android.os.Bundle();
            r2.putString("jsapi_args_appid", r3.appId);
            r6.putExtra("jsapiargs", r2);
     */
        /* JADX WARNING: Missing block: B:226:0x0b58, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r4) != false) goto L_0x0c94;
     */
        /* JADX WARNING: Missing block: B:227:0x0b5a, code skipped:
            r6.putExtra("shortUrl", r4);
     */
        /* JADX WARNING: Missing block: B:228:0x0b60, code skipped:
            r4 = "version_name";
     */
        /* JADX WARNING: Missing block: B:229:0x0b63, code skipped:
            if (r5 != null) goto L_0x0c9e;
     */
        /* JADX WARNING: Missing block: B:230:0x0b65, code skipped:
            r2 = null;
     */
        /* JADX WARNING: Missing block: B:231:0x0b66, code skipped:
            r6.putExtra(r4, r2);
            r4 = "version_code";
     */
        /* JADX WARNING: Missing block: B:232:0x0b6c, code skipped:
            if (r5 != null) goto L_0x0ca2;
     */
        /* JADX WARNING: Missing block: B:233:0x0b6e, code skipped:
            r2 = 0;
     */
        /* JADX WARNING: Missing block: B:234:0x0b6f, code skipped:
            r6.putExtra(r4, r2);
     */
        /* JADX WARNING: Missing block: B:235:0x0b78, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r3.cMg) != false) goto L_0x0b8a;
     */
        /* JADX WARNING: Missing block: B:236:0x0b7a, code skipped:
            r6.putExtra("srcUsername", r3.cMg);
            r6.putExtra("srcDisplayname", r3.cMh);
     */
        /* JADX WARNING: Missing block: B:237:0x0b8a, code skipped:
            r6.putExtra("msg_id", r18.field_msgId);
            r6.putExtra("KPublisherId", "msg_" + java.lang.Long.toString(r18.field_msgSvrId));
            r6.putExtra("KAppId", r3.appId);
            r6.putExtra("geta8key_username", r17.getTalkerUserName());
            r6.putExtra("pre_username", mo11017b(r17, r18));
            r6.putExtra("from_scence", 2);
            r6.putExtra("expid_str", r18.dJE);
            r2 = com.tencent.p177mm.model.C32798u.m53583ad(mo11017b(r17, r18), r17.getTalkerUserName());
            r6.putExtra("prePublishId", "msg_" + java.lang.Long.toString(r18.field_msgSvrId));
            r6.putExtra("preUsername", mo11017b(r17, r18));
            r6.putExtra("preChatName", r17.getTalkerUserName());
            r6.putExtra("preChatTYPE", r2);
            r6.putExtra("preMsgIndex", 0);
     */
        /* JADX WARNING: Missing block: B:238:0x0c36, code skipped:
            switch(r2) {
                case 1: goto L_0x0ca8;
                case 2: goto L_0x0ca6;
                case 3: goto L_0x0c39;
                case 4: goto L_0x0c39;
                case 5: goto L_0x0c39;
                case 6: goto L_0x0caa;
                case 7: goto L_0x0caa;
                default: goto L_0x0c39;
            };
     */
        /* JADX WARNING: Missing block: B:239:0x0c39, code skipped:
            r2 = 0;
     */
        /* JADX WARNING: Missing block: B:240:0x0c3a, code skipped:
            r6.putExtra("share_report_pre_msg_url", r3.url);
            r6.putExtra("share_report_pre_msg_title", r3.title);
            r6.putExtra("share_report_pre_msg_desc", r3.description);
            r6.putExtra("share_report_pre_msg_icon_url", r3.thumburl);
            r6.putExtra("share_report_pre_msg_appid", r3.appId);
            r6.putExtra("share_report_from_scene", r2);
     */
        /* JADX WARNING: Missing block: B:241:0x0c69, code skipped:
            if (r2 != 5) goto L_0x0c75;
     */
        /* JADX WARNING: Missing block: B:242:0x0c6b, code skipped:
            r6.putExtra("share_report_biz_username", r17.getTalkerUserName());
     */
        /* JADX WARNING: Missing block: B:243:0x0c75, code skipped:
            com.tencent.p177mm.p842bp.C25985d.m41467b(r17.yTx.getContext(), "webview", ".ui.tools.WebViewUI", r6);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(32857);
     */
        /* JADX WARNING: Missing block: B:244:0x0c8f, code skipped:
            r2 = "singlemessage";
     */
        /* JADX WARNING: Missing block: B:245:0x0c94, code skipped:
            r6.putExtra("shortUrl", r3.url);
     */
        /* JADX WARNING: Missing block: B:246:0x0c9e, code skipped:
            r2 = r5.versionName;
     */
        /* JADX WARNING: Missing block: B:247:0x0ca2, code skipped:
            r2 = r5.versionCode;
     */
        /* JADX WARNING: Missing block: B:248:0x0ca6, code skipped:
            r2 = 2;
     */
        /* JADX WARNING: Missing block: B:249:0x0ca8, code skipped:
            r2 = 3;
     */
        /* JADX WARNING: Missing block: B:250:0x0caa, code skipped:
            r2 = 5;
     */
        /* JADX WARNING: Missing block: B:251:0x0cac, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(32857);
     */
        /* JADX WARNING: Missing block: B:254:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:258:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:259:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:281:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:282:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:283:?, code skipped:
            return false;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32857);
            view.getTag();
            String str = c7620bi.field_content;
            if (str == null) {
                AppMethodBeat.m2505o(32857);
                return false;
            }
            C8910b me = C8910b.m16064me(str);
            if (me == null) {
                AppMethodBeat.m2505o(32857);
                return false;
            }
            C40439f bT = C46494g.m87739bT(me.appId, true);
            if (!(bT == null || C5046bo.isNullOrNil(bT.field_appId))) {
                C5378c.m8132a(c46650a, me, C1853r.m3846Yz(), bT, c7620bi.field_msgSvrId, c46650a.getTalkerUserName());
            }
            String B;
            Bundle bundle;
            int ad;
            Intent intent;
            Object obj;
            String talkerUserName;
            Bundle bundle2;
            switch (me.type) {
                case 3:
                    C7060h.pYm.mo8381e(13043, Integer.valueOf(2), me.description, me.appId);
                    break;
                case 4:
                    break;
                case 5:
                    if (C5046bo.isNullOrNil(me.canvasPageXml)) {
                        C14420ab c14420ab = (C14420ab) me.mo20333X(C14420ab.class);
                        if (c14420ab == null || C5046bo.isNullOrNil(c14420ab.uaa)) {
                            if (!(me.url == null || me.url.equals(""))) {
                                B = C35799p.m58684B(me.url, c46650a.dFx() ? "groupmessage" : "singlemessage");
                                str = me.fgn;
                                PackageInfo packageInfo = C5378c.getPackageInfo(c46650a.yTx.getContext(), me.appId);
                                Intent intent2 = new Intent();
                                intent2.putExtra("rawUrl", B);
                                intent2.putExtra("webpageTitle", me.title);
                                bundle = new Bundle();
                                bundle.putString("key_snsad_statextstr", me.cMn);
                                if (me.appId != null && ("wx751a1acca5688ba3".equals(me.appId) || "wxfbc915ff7c30e335".equals(me.appId) || "wx482a4001c37e2b74".equals(me.appId))) {
                                    bundle.putString("jsapi_args_appid", me.appId);
                                }
                                intent2.putExtra("jsapiargs", bundle);
                                if (C5046bo.isNullOrNil(str)) {
                                    intent2.putExtra("shortUrl", me.url);
                                } else {
                                    intent2.putExtra("shortUrl", str);
                                }
                                intent2.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
                                intent2.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
                                if (!C5046bo.isNullOrNil(me.cMg)) {
                                    intent2.putExtra("srcUsername", me.cMg);
                                    intent2.putExtra("srcDisplayname", me.cMh);
                                }
                                intent2.putExtra("msg_id", c7620bi.field_msgId);
                                intent2.putExtra("KPublisherId", "msg_" + Long.toString(c7620bi.field_msgSvrId));
                                intent2.putExtra("KAppId", me.appId);
                                intent2.putExtra("geta8key_username", c46650a.getTalkerUserName());
                                intent2.putExtra("pre_username", mo11017b(c46650a, c7620bi));
                                intent2.putExtra("from_scence", 2);
                                ad = C32798u.m53583ad(mo11017b(c46650a, c7620bi), c46650a.getTalkerUserName());
                                intent2.putExtra("prePublishId", "msg_" + Long.toString(c7620bi.field_msgSvrId));
                                intent2.putExtra("preUsername", mo11017b(c46650a, c7620bi));
                                intent2.putExtra("preChatName", c46650a.getTalkerUserName());
                                intent2.putExtra("preChatTYPE", ad);
                                intent2.putExtra("preMsgIndex", 0);
                                switch (ad) {
                                    case 1:
                                        ad = 3;
                                        break;
                                    case 2:
                                        ad = 2;
                                        break;
                                    case 6:
                                    case 7:
                                        ad = 5;
                                        break;
                                    default:
                                        ad = 0;
                                        break;
                                }
                                intent2.putExtra("share_report_pre_msg_url", me.url);
                                intent2.putExtra("share_report_pre_msg_title", me.title);
                                intent2.putExtra("share_report_pre_msg_desc", me.description);
                                intent2.putExtra("share_report_pre_msg_icon_url", me.thumburl);
                                intent2.putExtra("share_report_pre_msg_appid", me.appId);
                                intent2.putExtra("share_report_from_scene", ad);
                                if (ad == 5) {
                                    intent2.putExtra("share_report_biz_username", c46650a.getTalkerUserName());
                                }
                                C25747e c25747e = (C25747e) me.mo20333X(C25747e.class);
                                int i = c25747e != null ? c25747e.ffZ : -1;
                                intent2.putExtra(C5506m.ygo, i);
                                int intExtra = c46650a.yTx.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", Downloads.MIN_WAIT_FOR_NETWORK);
                                if (c25747e != null && i == 5 && c25747e.fgb == 1 && ((C20023b) C1720g.m3528K(C20023b.class)).aVP()) {
                                    Bundle bundle3 = new Bundle();
                                    bundle3.putInt("biz_video_scene", 1);
                                    bundle3.putInt("biz_video_subscene", intExtra);
                                    bundle3.putInt("geta8key_scene", 1);
                                    C11263c.m18982a(c46650a.yTx.getContext(), c7620bi.field_msgId, c7620bi.field_msgSvrId, 0, view.findViewById(2131822444), bundle3);
                                    AppMethodBeat.m2505o(32857);
                                    return true;
                                } else if (((C20023b) C1720g.m3528K(C20023b.class)).mo6758rW(3) && ((C20023b) C1720g.m3528K(C20023b.class)).mo6750a(c46650a.yTx.getContext(), B, i, 1, intExtra, intent2)) {
                                    C4990ab.m7416i("MicroMsg.ChattingItemAppMsgTo", "jump to TmplWebview");
                                    AppMethodBeat.m2505o(32857);
                                    return true;
                                } else {
                                    C25985d.m41467b(c46650a.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                                }
                            }
                            AppMethodBeat.m2505o(32857);
                            return true;
                        }
                        cvi cvi = new cvi();
                        cvi.uaa = c14420ab.uaa;
                        cvi.uab = c14420ab.uab;
                        cvi.uac = c14420ab.uac;
                        cvi.uad = c14420ab.uad;
                        cvi.uae = c14420ab.uae;
                        cvi.uai = c14420ab.uai;
                        cvi.lvz = c14420ab.lvz;
                        cvi.lvA = c14420ab.lvA;
                        cvi.qVw = c14420ab.qVw;
                        cvi.uaf = c14420ab.uaf;
                        cvi.uag = c14420ab.uag;
                        cvi.uah = c14420ab.uah;
                        cvi.source = c14420ab.source;
                        cvi.phw = c14420ab.phw;
                        cvi.uaj = c14420ab.uaj;
                        cvi.ual = c14420ab.ual;
                        cvi.uam = c14420ab.uam;
                        cvi.uan = c14420ab.uan;
                        cvi.uak = c14420ab.uak;
                        C46400aa.m87323a(c46650a.yTx.getContext(), C39964g.m68429a(cvi, 32, c46650a.yTx.getContext().getString(C25738R.string.c2a)));
                        C46297h.m86866a(cvi, c7620bi);
                        AppMethodBeat.m2505o(32857);
                        return true;
                    }
                    intent = new Intent();
                    intent.putExtra("sns_landig_pages_from_source", 5);
                    intent.putExtra("msg_id", c7620bi.field_msgId);
                    intent.putExtra("sns_landing_pages_xml", me.canvasPageXml);
                    intent.putExtra("sns_landing_pages_share_thumb_url", c7620bi.field_imgPath);
                    intent.addFlags(268435456);
                    C25985d.m41467b(c46650a.yTx.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
                    AppMethodBeat.m2505o(32857);
                    return true;
                case 6:
                    C9638aw.m17190ZK();
                    if (C18628c.isSDCardAvailable()) {
                        if (C5046bo.any(me.fgp)) {
                            long j = c7620bi.field_msgId;
                            C30065b aiE = C14877am.aUq().aiE(me.csD);
                            if (aiE == null || !aiE.bCR()) {
                                obj = null;
                            } else {
                                C9638aw.m17190ZK();
                                if (C18628c.m29080XO().mo15340jf(j).dtH()) {
                                    C4990ab.m7417i("MicroMsg.ChattingItemAppMsgTo", "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s", str, Long.valueOf(j), Long.valueOf(C18628c.m29080XO().mo15340jf(j).field_msgSvrId), C18628c.m29080XO().mo15340jf(j).field_imgPath);
                                    intent = new Intent();
                                    intent.setClassName(this.yJI.yTx.getContext(), "com.tencent.mm.ui.chatting.ResourcesExceedUI");
                                    intent.putExtra("clean_view_type", 1);
                                    this.yJI.startActivity(intent);
                                    obj = 1;
                                } else {
                                    intent = new Intent(this.yJI.yTx.getContext(), ShowImageUI.class);
                                    intent.putExtra("key_image_path", aiE.field_fileFullPath);
                                    intent.putExtra("key_message_id", j);
                                    intent.putExtra("key_favorite", true);
                                    this.yJI.startActivity(intent);
                                    obj = 1;
                                }
                            }
                            if (obj != null) {
                                AppMethodBeat.m2505o(32857);
                                return true;
                            }
                        }
                        intent = new Intent();
                        intent.setClassName(c46650a.yTx.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                        intent.putExtra("app_msg_id", c7620bi.field_msgId);
                        c46650a.startActivity(intent);
                        AppMethodBeat.m2505o(32857);
                        return true;
                    }
                    C23639t.m36492hO(c46650a.yTx.getContext());
                    AppMethodBeat.m2505o(32857);
                    return true;
                case 7:
                    if (bT != null && bT.mo63847xy() && C5378c.m8137a(c46650a, bT)) {
                        AppMethodBeat.m2505o(32857);
                        return true;
                    }
                    final C40439f c40439f = bT;
                    final C46650a c46650a2 = c46650a;
                    final C8910b c8910b = me;
                    final C7620bi c7620bi2 = c7620bi;
                    ((C36133b) c46650a.mo74857aF(C36133b.class)).mo57002a(c7620bi, new C14875aj() {
                        /* renamed from: dR */
                        public final void mo6036dR(boolean z) {
                            AppMethodBeat.m2504i(32850);
                            if (c40439f != null) {
                                if (z) {
                                    C5378c.m8131a(c46650a2, c8910b, C1853r.m3846Yz(), c40439f, c7620bi2.field_msgSvrId, 3, c46650a2.getTalkerUserName());
                                    AppMethodBeat.m2505o(32850);
                                    return;
                                }
                                C5378c.m8131a(c46650a2, c8910b, C1853r.m3846Yz(), c40439f, c7620bi2.field_msgSvrId, 7, c46650a2.getTalkerUserName());
                            }
                            AppMethodBeat.m2505o(32850);
                        }
                    });
                    AppMethodBeat.m2505o(32857);
                    return true;
                case 10:
                    if (C5046bo.isNullOrNil(me.fgQ)) {
                        AppMethodBeat.m2505o(32857);
                        return false;
                    }
                    intent = new Intent();
                    intent.setFlags(65536);
                    intent.putExtra("key_Product_xml", me.fgQ);
                    intent.putExtra("key_ProductUI_getProductInfoScene", 1);
                    if (c7620bi.field_imgPath == null) {
                        intent.putExtra("key_ProductUI_chatting_msgId", c7620bi.field_msgId);
                    }
                    C25985d.m41467b(c46650a.yTx.getContext(), "scanner", ".ui.ProductUI", intent);
                    AppMethodBeat.m2505o(32857);
                    return true;
                case 13:
                    if (C5046bo.isNullOrNil(me.fgW)) {
                        AppMethodBeat.m2505o(32857);
                        return false;
                    }
                    intent = new Intent();
                    intent.setFlags(65536);
                    intent.putExtra("key_product_info", me.fgW);
                    intent.putExtra("key_product_scene", 1);
                    C25985d.m41467b(c46650a.yTx.getContext(), "product", ".ui.MallProductUI", intent);
                    AppMethodBeat.m2505o(32857);
                    return true;
                case 16:
                    if (C5046bo.isNullOrNil(me.cDt)) {
                        AppMethodBeat.m2505o(32857);
                        return false;
                    }
                    intent = new Intent();
                    intent.setFlags(65536);
                    intent.putExtra("key_card_app_msg", me.cDt);
                    intent.putExtra("key_from_scene", me.fhD);
                    C25985d.m41467b(c46650a.yTx.getContext(), "card", ".ui.CardDetailUI", intent);
                    AppMethodBeat.m2505o(32857);
                    return true;
                case 19:
                    intent = new Intent();
                    intent.putExtra("message_id", c7620bi.field_msgId);
                    intent.putExtra("record_xml", me.fgU);
                    int ad2 = C32798u.m53583ad(mo11017b(c46650a, c7620bi), c46650a.getTalkerUserName());
                    intent.putExtra("prePublishId", "msg_" + Long.toString(c7620bi.field_msgSvrId));
                    intent.putExtra("preUsername", mo11017b(c46650a, c7620bi));
                    intent.putExtra("preChatName", c46650a.getTalkerUserName());
                    intent.putExtra("preChatTYPE", ad2);
                    C5405a.m8208a(intent, c46650a, c7620bi, this);
                    C25985d.m41467b(c46650a.yTx.getContext(), "record", ".ui.RecordMsgDetailUI", intent);
                    AppMethodBeat.m2505o(32857);
                    return true;
                case 20:
                    if (C5046bo.isNullOrNil(me.fgT)) {
                        AppMethodBeat.m2505o(32857);
                        return false;
                    }
                    intent = new Intent();
                    intent.setFlags(65536);
                    intent.putExtra("key_TV_xml", me.fgT);
                    intent.putExtra("key_TV_getProductInfoScene", 1);
                    if (c7620bi.field_imgPath == null) {
                        intent.putExtra("key_TVInfoUI_chatting_msgId", c7620bi.field_msgId);
                    }
                    C25985d.m41467b(c46650a.yTx.getContext(), "shake", ".ui.TVInfoUI", intent);
                    AppMethodBeat.m2505o(32857);
                    return true;
                case 24:
                    C32599lz c32599lz = new C32599lz();
                    c32599lz.cHO.context = c46650a.yTx.getContext();
                    c32599lz.cHO.cvx = c7620bi.field_msgId;
                    c32599lz.cHO.cHc = c46650a.dFx();
                    c32599lz.cHO.cHP = me.fgU;
                    c32599lz.cHO.scene = 6;
                    C4879a.xxA.mo10055m(c32599lz);
                    AppMethodBeat.m2505o(32857);
                    return true;
                case 33:
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    C4990ab.m7417i("MicroMsg.ChattingItemAppMsgTo", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", me.fiP, me.fiO, me.fiQ, me.url, Integer.valueOf(me.fiZ), me.fiS);
                    if (44 != me.type || (me.mo20336cw(false) && !C5046bo.isNullOrNil(me.mo20339p(c46650a.yTx.getContext(), false)))) {
                        talkerUserName = c46650a.getTalkerUserName();
                        String b = mo11017b(c46650a, c7620bi);
                        bundle = new Bundle();
                        if (c46650a.yTx instanceof AppBrandServiceChattingFmUI) {
                            B = "stat_scene";
                            ad = 10;
                            bundle2 = bundle;
                        } else if (c46650a.dFx()) {
                            B = "stat_scene";
                            ad = 2;
                            bundle2 = bundle;
                        } else {
                            B = "stat_scene";
                            if (C1855t.m3913mZ(talkerUserName)) {
                                ad = 7;
                                bundle2 = bundle;
                            } else {
                                ad = 1;
                                bundle2 = bundle;
                            }
                        }
                        bundle2.putInt(B, ad);
                        bundle.putString("stat_msg_id", "msg_" + Long.toString(c7620bi.field_msgSvrId));
                        bundle.putString("stat_chat_talker_username", talkerUserName);
                        bundle.putString("stat_send_msg_user", b);
                        switch (me.fiR) {
                            case 0:
                            case 2:
                                if (!(c46650a.yTx instanceof AppBrandServiceChattingFmUI)) {
                                    if (!C1855t.m3913mZ(talkerUserName)) {
                                        C42202a.m74442a(talkerUserName, b, c46650a.dFx(), me, bundle);
                                        obj = null;
                                        break;
                                    }
                                    C42202a.m74441a(talkerUserName, FilterEnum4Shaka.MIC_WEISHI_CHAZHI, me, bundle);
                                    obj = null;
                                    break;
                                }
                                C42202a.m74441a(talkerUserName, FilterEnum4Shaka.MIC_WEISHI_MENGHUANG, me, bundle);
                                obj = null;
                                break;
                            case 1:
                                intent = new Intent();
                                intent.putExtra("key_username", me.fiP);
                                if (c46650a.dFx()) {
                                    intent.putExtra("key_from_scene", 1);
                                    intent.putExtra("key_scene_note", c46650a.getTalkerUserName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + b);
                                } else {
                                    intent.putExtra("key_from_scene", 2);
                                    intent.putExtra("key_scene_note", talkerUserName);
                                }
                                intent.putExtra("_stat_obj", bundle);
                                C19154a c19154a = new C19154a();
                                c19154a.appId = me.fiQ;
                                c19154a.from = 6;
                                c19154a.gVt = me.fiZ;
                                c19154a.gVu = me.fiT;
                                intent.putExtra("key_scene_exposed_params", c19154a.ayP());
                                C25985d.m41467b(c46650a.yTx.getContext(), "appbrand", ".ui.AppBrandProfileUI", intent);
                                obj = null;
                                break;
                            case 3:
                                C42202a.m74444b(talkerUserName, b, c46650a.dFx(), me, bundle);
                                obj = null;
                                break;
                            default:
                                obj = 1;
                                break;
                        }
                        if (obj == null) {
                            AppMethodBeat.m2505o(32857);
                            return true;
                        }
                    }
                    break;
                case 34:
                    intent = new Intent();
                    intent.putExtra("key_biz_uin", me.fhF);
                    intent.putExtra("key_order_id", me.fhG);
                    if (!(c7620bi.field_talker == null || c7620bi.field_talker.equals("") || !C1855t.m3896kH(c7620bi.field_talker))) {
                        intent.putExtra("key_chatroom_name", c7620bi.field_talker);
                    }
                    C25985d.m41467b(c46650a.yTx.getContext(), "card", ".ui.CardGiftAcceptUI", intent);
                    AppMethodBeat.m2505o(32857);
                    return true;
                case 36:
                    if (C5046bo.isNullOrNil(me.fiQ) && C5046bo.isNullOrNil(me.fiP)) {
                        str = C35799p.m58684B(me.url, c46650a.dFx() ? "groupmessage" : "singlemessage");
                        Intent intent3 = new Intent();
                        intent3.putExtra("rawUrl", str);
                        intent3.putExtra("webpageTitle", me.title);
                        intent3.putExtra("shortUrl", me.url);
                        C25985d.m41467b(c46650a.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent3);
                        AppMethodBeat.m2505o(32857);
                        return true;
                    }
                    String talkerUserName2 = c46650a.getTalkerUserName();
                    talkerUserName = mo11017b(c46650a, c7620bi);
                    bundle = new Bundle();
                    if (c46650a.dFx()) {
                        B = "stat_scene";
                        ad = 2;
                        bundle2 = bundle;
                    } else {
                        B = "stat_scene";
                        if (C1855t.m3913mZ(talkerUserName2)) {
                            ad = 7;
                            bundle2 = bundle;
                        } else {
                            ad = 1;
                            bundle2 = bundle;
                        }
                    }
                    bundle2.putInt(B, ad);
                    bundle.putString("stat_msg_id", "msg_" + Long.toString(c7620bi.field_msgSvrId));
                    bundle.putString("stat_chat_talker_username", talkerUserName2);
                    bundle.putString("stat_send_msg_user", talkerUserName);
                    ((C45691e) C1720g.m3528K(C45691e.class)).mo68049a(c46650a.yTx.getContext(), c46650a.getTalkerUserName(), mo11017b(c46650a, c7620bi), c46650a.dFx(), me);
                    AppMethodBeat.m2505o(32857);
                    return true;
            }
        }

        /* renamed from: a */
        private static void m8195a(C5410c c5410c, C15612h c15612h, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32854);
            if (c7620bi.field_status == 2 && C5378c.m8136a(c15612h, c7620bi.field_msgId)) {
                if (c5410c.zci != null) {
                    c5410c.zci.setVisibility(0);
                    AppMethodBeat.m2505o(32854);
                    return;
                }
            } else if (c5410c.zci != null) {
                c5410c.zci.setVisibility(8);
            }
            AppMethodBeat.m2505o(32854);
        }

        /* renamed from: a */
        public final void mo10991a(final C46650a c46650a, final C7620bi c7620bi) {
            AppMethodBeat.m2504i(32858);
            C30379h.m48466d(c46650a.yTx.getContext(), c46650a.yTx.getMMResources().getString(C25738R.string.anu), "", c46650a.yTx.getMMResources().getString(C25738R.string.f9215t_), c46650a.yTx.getMMResources().getString(C25738R.string.f9076or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(32851);
                    if (c7620bi.bAA()) {
                        C4733l.m7097al(c7620bi);
                        c46650a.mo74882qp(true);
                        AppMethodBeat.m2505o(32851);
                        return;
                    }
                    AppMethodBeat.m2505o(32851);
                }
            }, new C54029());
            AppMethodBeat.m2505o(32858);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.d$f */
    public static class C5404f {
        public String cHz;
        public long cvx;
        public String imgPath;
        public int zcZ = -1;
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.d$a */
    static final class C5405a {
        /* renamed from: a */
        static void m8208a(Intent intent, C46650a c46650a, C7620bi c7620bi, C5378c c5378c) {
            String str;
            int i;
            Bundle bundle;
            AppMethodBeat.m2504i(32803);
            String talkerUserName = c46650a.getTalkerUserName();
            String b = c5378c.mo11017b(c46650a, c7620bi);
            Bundle bundle2 = new Bundle();
            if (c46650a.dFx()) {
                str = "stat_scene";
                i = 2;
                bundle = bundle2;
            } else {
                str = "stat_scene";
                if (C1855t.m3913mZ(talkerUserName)) {
                    i = 7;
                    bundle = bundle2;
                } else {
                    i = 1;
                    bundle = bundle2;
                }
            }
            bundle.putInt(str, i);
            bundle2.putString("stat_msg_id", "msg_" + Long.toString(c7620bi.field_msgSvrId));
            bundle2.putString("stat_chat_talker_username", talkerUserName);
            bundle2.putString("stat_send_msg_user", b);
            intent.putExtra("_stat_obj", bundle2);
            AppMethodBeat.m2505o(32803);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.d$b */
    static class C5406b {

        /* renamed from: com.tencent.mm.ui.chatting.viewitems.d$b$2 */
        static class C54072 implements OnClickListener {
            C54072() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: a */
        static boolean m8211a(Context context, C8910b c8910b) {
            AppMethodBeat.m2504i(32805);
            boolean o;
            if (c8910b == null || context == null) {
                AppMethodBeat.m2505o(32805);
                return false;
            } else if (c8910b.type == 3) {
                o = C46494g.m87754o(context, 16);
                AppMethodBeat.m2505o(32805);
                return o;
            } else if (c8910b.type == 4) {
                o = C46494g.m87754o(context, 8);
                AppMethodBeat.m2505o(32805);
                return o;
            } else if (c8910b.type == 5) {
                o = C46494g.m87754o(context, 32);
                AppMethodBeat.m2505o(32805);
                return o;
            } else if (c8910b.type == 6) {
                Long aik = C23234a.aik(c8910b.fgp);
                if (aik == null) {
                    AppMethodBeat.m2505o(32805);
                    return false;
                }
                o = C46494g.m87754o(context, aik.longValue());
                AppMethodBeat.m2505o(32805);
                return o;
            } else {
                AppMethodBeat.m2505o(32805);
                return false;
            }
        }

        /* renamed from: a */
        static void m8210a(final C46650a c46650a, final C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(32806);
            String b = C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend);
            final Intent intent = new Intent(c46650a.yTx.getContext(), MsgRetransmitUI.class);
            intent.putExtra("Retr_Msg_content", b);
            intent.putExtra("Retr_MsgFromScene", 2);
            C8910b me = C8910b.m16064me(b);
            if (me != null && 19 == me.type) {
                intent.putExtra("Retr_Msg_Type", 10);
            } else if (me != null && 24 == me.type) {
                intent.putExtra("Retr_Msg_Type", 10);
            } else if (me == null || 16 != me.type) {
                intent.putExtra("Retr_Msg_Type", 2);
                b = c7620bi.field_talker;
                String nW = C37922v.m64078nW(c7620bi.field_msgSvrId);
                intent.putExtra("reportSessionId", nW);
                C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
                y.mo53356j("prePublishId", "msg_" + c7620bi.field_msgSvrId);
                y.mo53356j("preUsername", str);
                y.mo53356j("preChatName", b);
                if (!(me == null || me.mo20333X(C41728a.class) == null)) {
                    y.mo53356j("appservicetype", Integer.valueOf(((C41728a) me.mo20333X(C41728a.class)).ffa));
                    intent.putExtra("Retr_MsgAppBrandServiceType", ((C41728a) me.mo20333X(C41728a.class)).ffa);
                }
                if (me != null && 33 == me.type) {
                    if (c46650a.dFx()) {
                        y.mo53356j("fromScene", Integer.valueOf(2));
                        intent.putExtra("Retr_MsgAppBrandFromScene", 2);
                    } else {
                        y.mo53356j("fromScene", Integer.valueOf(1));
                        intent.putExtra("Retr_MsgAppBrandFromScene", 1);
                    }
                    intent.putExtra("Retr_MsgFromUserName", str);
                    intent.putExtra("Retr_MsgTalker", c7620bi.field_talker);
                }
                y.mo53356j("sendAppMsgScene", Integer.valueOf(1));
                ((C46210i) C1720g.m3528K(C46210i.class)).mo55530a("adExtStr", y, c7620bi);
            } else {
                intent.putExtra("Retr_Msg_Type", 14);
            }
            intent.putExtra("Retr_Msg_Id", c7620bi.field_msgId);
            if (me == null || me.type != 6) {
                c46650a.startActivity(intent);
                AppMethodBeat.m2505o(32806);
                return;
            }
            int i;
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[6];
            objArr[0] = me.fgD;
            if (me.fgs == 1) {
                i = 7;
            } else {
                i = 5;
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(me.fgo);
            objArr[3] = Integer.valueOf(2);
            objArr[4] = Long.valueOf((System.currentTimeMillis() - c7620bi.field_createTime) / 1000);
            objArr[5] = me.fgp;
            c7060h.mo8381e(14665, objArr);
            boolean z = me.fgs != 0 || me.fgo > 26214400;
            intent.putExtra("Retr_Big_File", z);
            final C30065b aiM = C4733l.aiM(me.csD);
            if (aiM != null) {
                File file = new File(aiM.field_fileFullPath);
                if (file.exists() && file.length() == aiM.field_totalLen) {
                    c46650a.startActivity(intent);
                    AppMethodBeat.m2505o(32806);
                    return;
                } else if (aiM.field_offset > 0 && aiM.field_totalLen > aiM.field_offset) {
                    C5406b.m8209a(c46650a, intent, c7620bi, aiM.field_fileFullPath);
                    AppMethodBeat.m2505o(32806);
                    return;
                }
            }
            C4990ab.m7417i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", Integer.valueOf(me.fgo), me.fgD, C5046bo.anv(me.eyr));
            if (z) {
                intent.putExtra("Retr_Big_File", z);
                C42130g c42130g = new C42130g();
                c42130g.egl = new C1628a() {

                    /* renamed from: com.tencent.mm.ui.chatting.viewitems.d$b$1$1 */
                    class C54091 implements OnClickListener {
                        C54091() {
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    }

                    /* renamed from: a */
                    public final int mo5082a(String str, int i, C18496c c18496c, C9545d c9545d, boolean z) {
                        AppMethodBeat.m2504i(32804);
                        String str2 = "MicroMsg.AppMessageUtil";
                        String str3 = "summerbig cdnCallback mediaId:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]";
                        Object[] objArr = new Object[7];
                        objArr[0] = str;
                        objArr[1] = Integer.valueOf(i);
                        objArr[2] = c18496c;
                        objArr[3] = c9545d;
                        objArr[4] = Boolean.valueOf(c18496c != null);
                        objArr[5] = Boolean.valueOf(c9545d != null);
                        objArr[6] = Boolean.valueOf(z);
                        C4990ab.m7417i(str2, str3, objArr);
                        if (c9545d != null) {
                            if (c9545d.field_exist_whencheck) {
                                c46650a.startActivity(intent);
                            } else if (c7620bi.dtH() || (aiM != null && C5406b.m8212e(c7620bi, aiM.field_fileFullPath))) {
                                C4990ab.m7416i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                                C30379h.m48438a(c46650a.yTx.getContext(), c46650a.yTx.getContext().getString(C25738R.string.bt0), c46650a.yTx.getContext().getString(C25738R.string.f9238tz), new C54091());
                            } else {
                                C30379h.m48461b(c46650a.yTx.getContext(), c46650a.yTx.getMMResources().getString(C25738R.string.b30), "", true);
                            }
                        }
                        AppMethodBeat.m2505o(32804);
                        return 0;
                    }

                    /* renamed from: a */
                    public final void mo5083a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                    }

                    /* renamed from: l */
                    public final byte[] mo5084l(String str, byte[] bArr) {
                        return new byte[0];
                    }
                };
                c42130g.field_mediaId = C37458c.m63162a("checkExist", C5046bo.anU(), str, c7620bi.field_msgId);
                c42130g.field_fileId = me.fgD;
                c42130g.field_aesKey = me.eyr;
                c42130g.field_filemd5 = me.filemd5;
                c42130g.field_fileType = C42129a.efE;
                c42130g.field_talker = str;
                c42130g.field_priority = C42129a.efC;
                c42130g.field_svr_signature = "";
                c42130g.field_onlycheckexist = true;
                C4990ab.m7417i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", Boolean.valueOf(C37461f.afx().mo51225e(c42130g)), c42130g.field_fileId, c42130g.field_mediaId, C5046bo.anv(c42130g.field_aesKey));
                if (!C37461f.afx().mo51225e(c42130g)) {
                    C5406b.m8209a(c46650a, intent, c7620bi, null);
                }
                AppMethodBeat.m2505o(32806);
                return;
            }
            C5406b.m8209a(c46650a, intent, c7620bi, null);
            AppMethodBeat.m2505o(32806);
        }

        /* renamed from: a */
        private static void m8209a(C46650a c46650a, Intent intent, C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(32807);
            if (c7620bi.dtH() || C5406b.m8212e(c7620bi, str)) {
                C4990ab.m7416i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                C30379h.m48438a(c46650a.yTx.getContext(), c46650a.yTx.getContext().getString(C25738R.string.bt0), c46650a.yTx.getContext().getString(C25738R.string.f9238tz), new C54072());
                AppMethodBeat.m2505o(32807);
                return;
            }
            c46650a.startActivity(intent);
            AppMethodBeat.m2505o(32807);
        }

        /* renamed from: e */
        public static boolean m8212e(C7620bi c7620bi, String str) {
            AppMethodBeat.m2504i(32808);
            if (System.currentTimeMillis() - c7620bi.field_createTime <= 259200000 || (!C5046bo.isNullOrNil(str) && C5730e.m8628ct(str))) {
                AppMethodBeat.m2505o(32808);
                return false;
            }
            AppMethodBeat.m2505o(32808);
            return true;
        }

        public static boolean arC(String str) {
            boolean z = false;
            AppMethodBeat.m2504i(32809);
            String c = C32291o.ahl().mo73108c(str, false, true);
            if (C5730e.m8628ct(c)) {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                Bitmap decodeFile = C5056d.decodeFile(c, options);
                if (options.outWidth * options.outHeight > 1048576) {
                    C4990ab.m7417i("MicroMsg.AppMessageUtil", "Bitmap to big:%d/%d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                    z = true;
                }
                if (decodeFile != null) {
                    decodeFile.recycle();
                }
                AppMethodBeat.m2505o(32809);
            } else {
                AppMethodBeat.m2505o(32809);
            }
            return z;
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.d$c */
    static final class C5410c extends C5379a {
        public static int[] mqq = new int[]{2131822651, 2131822652, 2131822653, 2131822654, 2131822655};
        protected TextView gnB;
        protected TextView gnC;
        protected TextView moL;
        private ArrayList<MMImageView> rlN = new ArrayList();
        protected MMImageView zbI;
        protected ImageView zbJ;
        protected ImageView zbK;
        protected TextView zbL;
        protected LinearLayout zbM;
        protected TextView zbN;
        protected ImageView zbO;
        protected MMPinProgressBtn zbP;
        protected ImageView zbQ;
        protected ImageView zbR;
        protected ImageView zbS;
        protected ImageView zbT;
        protected TextView zbU;
        protected ChattingItemFooter zbV;
        protected ImageView zbW;
        protected LinearLayout zbX;
        protected ViewGroup zbY;
        protected TextView zbZ;
        ImageView zcA;
        TextView zcB;
        LinearLayout zcC;
        MMNeat7extView zcD;
        ImageView zcE;
        ImageView zcF;
        ImageView zcG;
        TextView zcH;
        TextView zcI;
        public int zcJ = 0;
        private int zcK = BaseClientBuilder.API_PRIORITY_OTHER;
        protected LinearLayout zca;
        protected RelativeLayout zcb;
        protected FrameLayout zcc;
        protected LinearLayout zcd;
        protected LinearLayout zce;
        protected ViewStub zcf;
        protected ImageView zcg;
        protected ImageView zch;
        ImageView zci;
        protected LinearLayout zcj;
        protected ImageView zck;
        protected TextView zcl;
        protected TextView zcm;
        protected ImageView zcn;
        protected TextView zco;
        protected TextView zcp;
        protected LinearLayout zcq;
        protected ImageView zcr;
        protected ImageView zcs;
        protected TextView zct;
        protected LinearLayout zcu;
        LinearLayout zcv;
        TextView zcw;
        TextView zcx;
        ImageView zcy;
        ImageView zcz;

        C5410c() {
            AppMethodBeat.m2504i(32813);
            AppMethodBeat.m2505o(32813);
        }

        /* renamed from: y */
        public final C5410c mo11055y(View view, boolean z) {
            AppMethodBeat.m2504i(32814);
            super.mo11031eP(view);
            this.zcu = (LinearLayout) view.findViewById(2131822523);
            this.zbI = (MMImageView) view.findViewById(2131822536);
            this.gnB = (TextView) view.findViewById(2131822533);
            this.zbN = (TextView) view.findViewById(2131822531);
            this.gnC = (TextView) view.findViewById(2131822534);
            this.moL = (TextView) view.findViewById(2131822543);
            this.zbJ = (ImageView) view.findViewById(2131822542);
            this.zbL = (TextView) view.findViewById(2131822545);
            this.zbK = (ImageView) view.findViewById(2131822544);
            this.zbM = (LinearLayout) view.findViewById(2131822541);
            this.zbO = (ImageView) view.findViewById(2131822557);
            this.zbP = (MMPinProgressBtn) view.findViewById(2131822537);
            this.zbQ = (ImageView) this.mRR.findViewById(2131822538);
            this.zbR = (ImageView) this.mRR.findViewById(2131822556);
            this.zbS = (ImageView) this.mRR.findViewById(2131822555);
            this.zbT = (ImageView) view.findViewById(2131822539);
            this.zbU = (TextView) view.findViewById(2131822454);
            this.zbW = (ImageView) view.findViewById(2131822558);
            this.moo = (CheckBox) view.findViewById(2131820580);
            this.iVh = view.findViewById(2131820586);
            this.qkY = (TextView) view.findViewById(2131821102);
            this.zbV = (ChattingItemFooter) view.findViewById(2131822554);
            this.zbX = (LinearLayout) view.findViewById(2131822514);
            this.zbY = (ViewGroup) view.findViewById(2131822511);
            this.zbZ = (TextView) view.findViewById(2131822513);
            this.zca = (LinearLayout) view.findViewById(2131821893);
            this.zcc = (FrameLayout) view.findViewById(2131822515);
            this.zcd = (LinearLayout) view.findViewById(2131822530);
            this.zch = (ImageView) view.findViewById(2131822553);
            this.zcb = (RelativeLayout) view.findViewById(2131822535);
            this.zcf = (ViewStub) view.findViewById(2131822540);
            this.zcg = (ImageView) view.findViewById(2131822532);
            if (!z) {
                this.zci = (ImageView) this.mRR.findViewById(2131822661);
                this.pyf = (ProgressBar) this.mRR.findViewById(2131822660);
            }
            this.zcq = (LinearLayout) view.findViewById(2131822516);
            this.zcn = (ImageView) view.findViewById(2131822517);
            this.zco = (TextView) view.findViewById(2131822518);
            this.zct = (TextView) view.findViewById(2131822519);
            this.zcm = (TextView) view.findViewById(2131822520);
            this.zcs = (ImageView) view.findViewById(2131822521);
            this.zcr = (ImageView) view.findViewById(2131822522);
            this.zcj = (LinearLayout) view.findViewById(2131822525);
            this.zck = (ImageView) view.findViewById(2131822526);
            this.zcl = (TextView) view.findViewById(2131822527);
            this.zcp = (TextView) view.findViewById(2131822524);
            this.zcv = (LinearLayout) view.findViewById(2131822546);
            this.zcw = (TextView) view.findViewById(2131822547);
            this.zcx = (TextView) view.findViewById(2131822548);
            this.zcy = (ImageView) view.findViewById(2131822549);
            this.zcz = (ImageView) view.findViewById(2131822550);
            this.zcA = (ImageView) view.findViewById(2131822551);
            this.zcB = (TextView) view.findViewById(2131822552);
            this.zcC = (LinearLayout) view.findViewById(2131822441);
            this.zcG = (ImageView) view.findViewById(2131822445);
            this.zcD = (MMNeat7extView) view.findViewById(2131822442);
            this.zcE = (ImageView) view.findViewById(2131822444);
            this.zcF = (ImageView) view.findViewById(2131822447);
            this.zcH = (TextView) view.findViewById(2131822448);
            this.zcI = (TextView) view.findViewById(2131822446);
            if (this.zbN != null && VERSION.SDK_INT >= 16) {
                this.zcK = this.zbN.getMaxLines();
            }
            this.zcJ = C5378c.m8144hU(C4996ah.getContext());
            AppMethodBeat.m2505o(32814);
            return this;
        }

        public final void reset() {
            AppMethodBeat.m2504i(32815);
            if (this.zbN != null) {
                this.zbN.setMaxLines(this.zcK);
            }
            AppMethodBeat.m2505o(32815);
        }

        /* renamed from: a */
        public static void m8220a(C5410c c5410c, String str, int i) {
            AppMethodBeat.m2504i(32816);
            int aiL = C4733l.aiL(str);
            if (aiL == -1 || aiL >= 100 || i <= 0) {
                c5410c.zbP.setVisibility(8);
                c5410c.zbQ.setVisibility(8);
                AppMethodBeat.m2505o(32816);
                return;
            }
            c5410c.zbP.setVisibility(0);
            c5410c.zbQ.setVisibility(0);
            c5410c.zbP.setProgress(aiL);
            AppMethodBeat.m2505o(32816);
        }

        /* renamed from: a */
        static void m8218a(C46650a c46650a, C5410c c5410c, C8910b c8910b, boolean z) {
            String str;
            String str2;
            AppMethodBeat.m2504i(32818);
            c5410c.gnB.setVisibility(8);
            if (c8910b.title == null || c8910b.title.trim().length() <= 0) {
                c5410c.zbN.setVisibility(8);
                str = null;
            } else {
                str = c8910b.title;
                c5410c.zbN.setVisibility(0);
                c5410c.zbN.setMaxLines(2);
            }
            c5410c.gnC.setMaxLines(4);
            c5410c.zbT.setVisibility(8);
            c5410c.zbO.setVisibility(4);
            if (z) {
                c5410c.zbI.setVisibility(8);
            }
            C18348nt c18348nt = new C18348nt();
            c18348nt.cJY.type = 0;
            c18348nt.cJY.cKa = c8910b.fgU;
            C4879a.xxA.mo10055m(c18348nt);
            C44099c c44099c = c18348nt.cJZ.cKi;
            if (c44099c != null) {
                c5410c.zbN.setText(C44089j.m79293b(c5410c.zbN.getContext(), C5046bo.m7532bc(c44099c.title, c8910b.title), c5410c.zbN.getTextSize()));
                String str3 = c44099c.desc;
                if (str3 == null) {
                    C4990ab.m7413e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", c8910b.fgU);
                } else {
                    str3 = str3.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                }
                if (str3 != null && str3.length() > 100) {
                    str3 = str3.substring(0, 100);
                }
                c5410c.gnC.setText(C44089j.m79293b(c5410c.gnC.getContext(), C5046bo.m7532bc(str3, c8910b.description), c5410c.gnC.getTextSize()));
                Iterator it = c44099c.fjr.iterator();
                int i = 0;
                Object obj = null;
                String str4 = null;
                str2 = str;
                while (it.hasNext()) {
                    aar aar = (aar) it.next();
                    if (C5046bo.isNullOrNil(aar.wgo) || !aar.wgo.equals(".htm") || C5046bo.isNullOrNil(aar.whb) || !aar.whb.equals("WeNoteHtmlFile")) {
                        int i2;
                        if (aar.wgT.whw.whU != null) {
                            i2 = 1;
                            str2 = c46650a.yTx.getContext().getString(C25738R.string.dja);
                        } else {
                            if (aar.wgT.whw.cEV != null) {
                                if (str4 == null) {
                                    str4 = aar.wgV;
                                    i2 = i;
                                } else if (str4 != aar.wgV) {
                                    obj = aar.wgV;
                                    i2 = i;
                                }
                            }
                            i2 = i;
                        }
                        switch (aar.dataType) {
                            case 1:
                                i = i2;
                                continue;
                            case 2:
                                if (z) {
                                    c5410c.zbI.setVisibility(0);
                                    c5410c.zbI.setImageResource(C25738R.drawable.avp);
                                }
                                i = i2;
                                continue;
                            case 3:
                                if (z) {
                                    c5410c.zbI.setVisibility(0);
                                    c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_voice);
                                }
                                i = i2;
                                continue;
                            case 4:
                                if (z) {
                                    c5410c.zbI.setVisibility(0);
                                    c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_video);
                                }
                                c5410c.zbT.setVisibility(0);
                                c5410c.zbT.setImageResource(C25738R.drawable.a4k);
                                i = i2;
                                continue;
                            case 5:
                                if (z) {
                                    c5410c.zbI.setVisibility(0);
                                    c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                                }
                                i = i2;
                                continue;
                            case 6:
                                c5410c.zbI.setVisibility(0);
                                c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_location);
                                i = i2;
                                continue;
                            case 7:
                                if (z) {
                                    c5410c.zbI.setVisibility(0);
                                    c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_music);
                                }
                                c5410c.zbT.setVisibility(0);
                                c5410c.zbT.setImageResource(C25738R.drawable.f6932vs);
                                i = i2;
                                continue;
                            case 8:
                                if (z) {
                                    c5410c.zbI.setVisibility(0);
                                    c5410c.zbI.setImageResource(C30034d.ail(aar.wgo));
                                }
                                i = i2;
                                continue;
                            case 10:
                            case 11:
                            case 14:
                                if (z) {
                                    c5410c.zbI.setVisibility(0);
                                    c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_unknow);
                                }
                                i = i2;
                                continue;
                            case 16:
                                if (z) {
                                    c5410c.zbI.setVisibility(0);
                                    c5410c.zbI.setImageResource(C25738R.drawable.ad2);
                                    break;
                                }
                                break;
                        }
                        i = i2;
                    }
                }
                if (str4 != null && obj == null && i == 0) {
                    str2 = c46650a.yTx.getContext().getString(C25738R.string.bqj, new Object[]{str4});
                } else if (!(str4 == null || obj == null || str4.equals(obj) || i != 0)) {
                    str2 = c46650a.yTx.getContext().getString(C25738R.string.bqi, new Object[]{str4, obj});
                }
            } else {
                str2 = str;
            }
            if (!C5046bo.isNullOrNil(str2)) {
                c5410c.zbN.setText(str2);
                c5410c.zbN.setVisibility(0);
            }
            c5410c.zbI.setVisibility(8);
            c5410c.zcb.setVisibility(8);
            AppMethodBeat.m2505o(32818);
        }

        /* renamed from: a */
        static void m8217a(C46650a c46650a, C5410c c5410c, C8910b c8910b, C7620bi c7620bi, boolean z) {
            int i;
            CharSequence charSequence;
            AppMethodBeat.m2504i(GLType.GL_UNSIGNED_SHORT_4_4_4_4);
            c5410c.zcd.setVisibility(8);
            c5410c.zcC.setVisibility(0);
            if (c8910b.title == null || c8910b.title.length() <= 0) {
                c5410c.zcD.setVisibility(8);
            } else {
                c5410c.zcD.setMaxLines(2);
                c5410c.zcD.setVisibility(0);
                c5410c.zcD.mo15921ah(c8910b.getTitle());
            }
            C25747e c25747e = (C25747e) c8910b.mo20333X(C25747e.class);
            if (c25747e != null) {
                i = c25747e.duration;
            } else {
                i = 0;
            }
            String kr = C1192l.m2623kr(i);
            if (C5046bo.isNullOrNil(kr)) {
                c5410c.zcI.setVisibility(8);
            } else {
                c5410c.zcI.setVisibility(0);
                c5410c.zcI.setText(kr);
            }
            c5410c.zcG.setVisibility(0);
            if (c25747e != null && C37436r.m63099ks(c25747e.fgc)) {
                c5410c.zcI.setVisibility(8);
                c5410c.zcG.setVisibility(8);
            }
            C40460b.m69437r(c5410c.zcF, c8910b.cMg);
            C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c8910b.cMg);
            if (aoO == null || ((int) aoO.ewQ) <= 0) {
                charSequence = c8910b.cMh;
                c5410c.zcF.setTag(c8910b.cMg);
                final WeakReference weakReference = new WeakReference(c5410c.zcF);
                C26417a.flu.mo20966a(c8910b.cMg, "", new C9636a() {
                    /* renamed from: o */
                    public final void mo6218o(String str, boolean z) {
                        AppMethodBeat.m2504i(32812);
                        ImageView imageView = (ImageView) weakReference.get();
                        if (imageView == null) {
                            AppMethodBeat.m2505o(32812);
                            return;
                        }
                        C7616ad aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(str);
                        if (aoO != null && ((int) aoO.ewQ) > 0 && (imageView.getTag() instanceof String) && C5046bo.isEqual((String) imageView.getTag(), str)) {
                            C17880h qo = C17884o.act().mo33392qo(str);
                            if (qo == null || C5046bo.isNullOrNil(qo.acl())) {
                                C40460b.m69437r(imageView, str);
                            } else {
                                C11188a.m18894a(imageView, aoO, qo.acl(), true);
                                AppMethodBeat.m2505o(32812);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(32812);
                    }
                });
            } else {
                if (!C7486a.m12942jh(aoO.field_type) && C41730b.m73490a(c8910b.cMg, false, -1) == null) {
                    C17880h qo = C17884o.act().mo33392qo(c8910b.cMg);
                    if (!(qo == null || C5046bo.isNullOrNil(qo.acl()))) {
                        C11188a.m18894a(c5410c.zcF, aoO, qo.acl(), true);
                    }
                }
                String charSequence2 = C1854s.m3866mJ(c8910b.cMg);
                if (C5046bo.isEqual(charSequence2, c8910b.cMg) && !C5046bo.isNullOrNil(c8910b.cMh)) {
                    charSequence2 = c8910b.cMh;
                }
            }
            c5410c.zcH.setText(C44089j.m79293b(c46650a.yTx.getContext(), charSequence2, c5410c.zcH.getTextSize()));
            c5410c.zbO.setVisibility(4);
            int al = C1338a.m2856al(c46650a.yTx.getContext(), C25738R.dimen.f10298x7) - C1338a.fromDPToPix(c46650a.yTx.getContext(), 24);
            i = (al * 9) / 16;
            if (z || !C5046bo.isNullOrNil(c8910b.thumburl)) {
                String str = c8910b.thumburl;
                C17927a c17927a = new C17927a();
                c17927a.ePT = C25738R.color.f11875k8;
                c17927a.ePG = true;
                c17927a.ePJ = C30080q.m47642v(str, c7620bi.getType(), "@T");
                C17927a ct = c17927a.mo33448ct(al, i);
                ct.fGV = new C35838f();
                ct.ePF = true;
                C32291o.ahp().mo43766a(str, c5410c.zcE, c17927a.ahG());
                AppMethodBeat.m2505o(GLType.GL_UNSIGNED_SHORT_4_4_4_4);
                return;
            }
            Bitmap bitmap = null;
            if (!C5406b.arC(c7620bi.field_imgPath)) {
                bitmap = C32291o.ahl().mo73087a(c7620bi.field_imgPath, C1338a.getDensity(c46650a.yTx.getContext()), false);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                c5410c.zcE.setImageResource(C25738R.color.f11875k8);
                AppMethodBeat.m2505o(GLType.GL_UNSIGNED_SHORT_4_4_4_4);
                return;
            }
            c5410c.zcE.setImageBitmap(bitmap);
            AppMethodBeat.m2505o(GLType.GL_UNSIGNED_SHORT_4_4_4_4);
        }

        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: b */
        static void m8221b(C46650a c46650a, C5410c c5410c, C8910b c8910b, C7620bi c7620bi, boolean z) {
            AppMethodBeat.m2504i(GLType.GL_UNSIGNED_SHORT_5_5_5_1);
            C18348nt c18348nt = new C18348nt();
            c18348nt.cJY.type = 0;
            c18348nt.cJY.cKa = c8910b.fgU;
            C4879a.xxA.mo10055m(c18348nt);
            C44099c c44099c = c18348nt.cJZ.cKi;
            c5410c.zcb.setVisibility(8);
            String[] strArr = new String[4];
            String[] strArr2 = new String[4];
            int[] iArr = new int[4];
            String[] strArr3 = new String[4];
            String[] strArr4 = new String[4];
            int[] iArr2 = new int[4];
            String[] strArr5 = new String[4];
            if (c44099c != null) {
                String str;
                Object obj;
                String trim;
                CharSequence replaceAll;
                Object replaceAll2;
                String str2 = null;
                String bc = C5046bo.m7532bc(c44099c.desc, c8910b.description);
                Object obj2 = null;
                Iterator it = c44099c.fjr.iterator();
                int i = 0;
                while (it.hasNext()) {
                    aar aar = (aar) it.next();
                    if (C5046bo.isNullOrNil(aar.wgo) || !aar.wgo.equals(".htm") || C5046bo.isNullOrNil(aar.whb) || !aar.whb.equals("WeNoteHtmlFile")) {
                        switch (aar.dataType) {
                            case 1:
                                if (obj2 == null) {
                                    String str3 = aar.desc;
                                    if (!C5046bo.isNullOrNil(str3)) {
                                        if (C5046bo.isNullOrNil(str3.replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "").trim())) {
                                            str = str2;
                                        } else {
                                            str = aar.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                                        }
                                        obj2 = 1;
                                        str2 = str;
                                        continue;
                                    }
                                }
                            case 2:
                                if (z) {
                                    c5410c.zcb.setVisibility(0);
                                    c5410c.zbI.setVisibility(0);
                                    c5410c.zbI.setImageResource(C25738R.drawable.avp);
                                }
                                if (i < 4) {
                                    strArr[i] = aar.fgE;
                                    strArr2[i] = aar.wfV;
                                    iArr[i] = (int) aar.wgF;
                                    strArr3[i] = aar.wfZ;
                                    strArr4[i] = aar.wgb;
                                    iArr2[i] = (int) aar.wgu;
                                    strArr5[i] = aar.mnd;
                                }
                                i++;
                                continue;
                            case 3:
                            case 6:
                                break;
                            case 8:
                                if (C5046bo.isNullOrNil(bc)) {
                                    bc = C4996ah.getContext().getString(C25738R.string.f9140qr) + aar.title;
                                }
                                bc = bc;
                                break;
                        }
                        bc = bc;
                    }
                }
                if (str2 != null) {
                    String[] split = str2.split(IOUtils.LINE_SEPARATOR_UNIX, 2);
                    ArrayList arrayList = new ArrayList();
                    if (split.length > 0) {
                        for (String str4 : split) {
                            if (str4.length() > 0) {
                                arrayList.add(str4);
                            }
                        }
                    }
                    if (arrayList.size() == 1) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (arrayList.size() == 1 && c44099c.fjr.size() == 2) {
                        str = C4996ah.getContext().getString(C25738R.string.bsc);
                    } else if (i > 0) {
                        str = (String) arrayList.get(0);
                        if (arrayList.size() > 1) {
                            str2 = (String) arrayList.get(1);
                        } else {
                            str2 = null;
                        }
                    } else {
                        str = (String) arrayList.get(0);
                        String[] split2 = bc.split(Pattern.quote(str), 2);
                        str2 = split2[0].trim();
                        if (split2.length > 1) {
                            str2 = new StringBuilder(split2[0].trim()).append(IOUtils.LINE_SEPARATOR_UNIX).append(split2[1].trim()).toString().trim();
                        }
                    }
                    trim = str.trim();
                } else {
                    trim = C4996ah.getContext().getString(C25738R.string.bsc);
                    obj = null;
                    str2 = bc;
                }
                if (trim != null) {
                    replaceAll2 = trim.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                } else {
                    replaceAll2 = trim;
                }
                c5410c.zbN.setText(C44089j.m79294b(c5410c.zbN.getContext(), replaceAll2, (int) c5410c.zbN.getTextSize()));
                if (str2 == null || str2.length() <= 100) {
                    replaceAll2 = str2;
                } else {
                    replaceAll2 = str2.substring(0, 100).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                }
                c5410c.gnC.setText(C44089j.m79294b(c5410c.gnC.getContext(), replaceAll2, (int) c5410c.gnC.getTextSize()));
                if (i > 0) {
                    int i2;
                    c5410c.zcb.setVisibility(8);
                    if (obj != null || obj2 == null || C5046bo.isNullOrNil(replaceAll2)) {
                        c5410c.gnC.setVisibility(8);
                        c5410c.zbN.setMaxLines(2);
                    } else {
                        c5410c.gnC.setMaxLines(1);
                        c5410c.gnC.setVisibility(0);
                        c5410c.zbN.setMaxLines(1);
                    }
                    c5410c.zcg.setVisibility(8);
                    c5410c.zcf.setLayoutResource(2130969079);
                    try {
                        if (c5410c.zce == null) {
                            c5410c.zce = (LinearLayout) c5410c.zcf.inflate();
                        } else {
                            c5410c.zce.setVisibility(0);
                        }
                    } catch (Exception e) {
                        c5410c.zcf.setVisibility(0);
                    }
                    if (i > 4) {
                        i2 = 4;
                    } else {
                        i2 = i;
                    }
                    C5410c.m8216a(c46650a, c5410c, i2, strArr5, strArr2, strArr, iArr, strArr4, strArr3, iArr2, c7620bi.field_talker);
                    ImageView imageView = (ImageView) c5410c.zce.findViewById(2131822656);
                    TextView textView = (TextView) c5410c.zce.findViewById(2131822657);
                    if (textView != null) {
                        textView.setTextSize(0, (float) C4996ah.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f10011nc));
                    }
                    if (i > 4) {
                        if (imageView != null) {
                            imageView.setVisibility(0);
                        }
                        if (textView != null) {
                            textView.setText("(" + i + ")");
                            textView.setVisibility(0);
                        }
                    }
                    AppMethodBeat.m2505o(GLType.GL_UNSIGNED_SHORT_5_5_5_1);
                    return;
                }
                c5410c.zcf.setVisibility(8);
                c5410c.zcg.setVisibility(0);
            }
            AppMethodBeat.m2505o(GLType.GL_UNSIGNED_SHORT_5_5_5_1);
        }

        /* renamed from: a */
        private static void m8216a(C46650a c46650a, C5410c c5410c, int i, String[] strArr, String[] strArr2, String[] strArr3, int[] iArr, String[] strArr4, String[] strArr5, int[] iArr2, String str) {
            MMImageView mMImageView;
            AppMethodBeat.m2504i(32821);
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 > 4) {
                    break;
                }
                mMImageView = (MMImageView) c5410c.zce.findViewById(mqq[i3]);
                if (mMImageView != null) {
                    mMImageView.setImageDrawable(null);
                    mMImageView.setVisibility(8);
                }
                i2 = i3 + 1;
            }
            ImageView imageView = (ImageView) c5410c.zce.findViewById(2131822656);
            TextView textView = (TextView) c5410c.zce.findViewById(2131822657);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (textView != null) {
                textView.setVisibility(8);
            }
            for (int i4 = 0; i4 < i; i4++) {
                if (i == 1) {
                    imageView = (MMImageView) c5410c.zce.findViewById(mqq[i4]);
                    imageView.setImageResource(C1318a.chatting_note_default_img_one);
                } else {
                    mMImageView = (MMImageView) c5410c.zce.findViewById(mqq[i4 + 1]);
                    mMImageView.setImageResource(C1318a.chatting_note_default_img);
                }
                imageView.setVisibility(0);
                C14877am.dhM().mo15610a((C7238a) c46650a.mo74857aF(C15612h.class), strArr[i4], C5046bo.anU(), strArr2[i4], strArr3[i4], iArr[i4], str);
                String q = C32291o.ahl().mo73118q("Note_" + strArr[i4], "", "");
                C17927a c17927a = new C17927a();
                c17927a.fHe = 1;
                c17927a.eQa = true;
                c17927a.ePV = C1318a.chatting_note_default_img;
                c17927a.ePN = (int) c46650a.yTx.getMMResources().getDimension(C25738R.dimen.f9748ee);
                c17927a.ePO = (int) c46650a.yTx.getMMResources().getDimension(C25738R.dimen.f9748ee);
                C25814c ahG = c17927a.ahG();
                if (C5730e.m8628ct(q)) {
                    C32291o.ahp().mo43766a(q, imageView, ahG);
                } else {
                    C14877am.dhM().mo15610a((C7238a) c46650a.mo74857aF(C15612h.class), strArr[i4], C5046bo.anU(), strArr4[i4], strArr5[i4], iArr2[i4], str);
                    C32291o.ahl().mo73118q("Note_" + strArr[i4], "", "");
                    C1338a.fromDPToPix(c46650a.yTx.getContext(), 45);
                    if (C5730e.m8628ct(q)) {
                        C32291o.ahp().mo43766a(q, imageView, ahG);
                    } else {
                        C4990ab.m7416i("MicroMsg.AppMsgViewHolder", "thumb file not exist!");
                    }
                }
            }
            AppMethodBeat.m2505o(32821);
        }

        /* renamed from: a */
        public static void m8219a(C5410c c5410c, Boolean bool, C7620bi c7620bi, String str, String str2) {
            AppMethodBeat.m2504i(32817);
            final long j = c7620bi.field_msgId;
            C30065b lZ = C14877am.aUq().mo48329lZ(j);
            if (lZ == null) {
                C4990ab.m7421w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", Long.valueOf(j), str2);
                AppMethodBeat.m2505o(32817);
                return;
            }
            if (bool.booleanValue()) {
                if (lZ.field_status == 101) {
                    c5410c.zbS.setVisibility(0);
                    c5410c.zbP.setVisibility(0);
                    c5410c.zbQ.setVisibility(0);
                } else if (lZ.field_status == 102) {
                    c5410c.zbS.setVisibility(8);
                    c5410c.zbP.setVisibility(8);
                    c5410c.zbQ.setVisibility(8);
                } else {
                    c5410c.zbS.setVisibility(8);
                    c5410c.zbP.setVisibility(8);
                    c5410c.zbQ.setVisibility(8);
                }
            } else if (lZ.field_status == 101) {
                c5410c.zbS.setVisibility(0);
                c5410c.zbR.setVisibility(8);
            } else if (lZ.field_status == 105) {
                c5410c.zbS.setVisibility(8);
                c5410c.zbR.setVisibility(0);
            } else {
                c5410c.zbS.setVisibility(8);
                c5410c.zbR.setVisibility(8);
            }
            if (c7620bi.field_status == 5) {
                c5410c.zbS.setVisibility(8);
                c5410c.zbR.setVisibility(8);
            }
            final Boolean bool2 = bool;
            final String str3 = str;
            final String str4 = str2;
            final C7620bi c7620bi2 = c7620bi;
            c5410c.zbS.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(32810);
                    long j;
                    String str;
                    C30065b lZ;
                    if (bool2.booleanValue()) {
                        j = j;
                        str = str4;
                        lZ = C14877am.aUq().mo48329lZ(j);
                        if (lZ == null) {
                            C4990ab.m7412e("MicroMsg.AppMsgLogic", "ERR:" + C1447g.m3075Mq() + " getinfo failed: " + str);
                            AppMethodBeat.m2505o(32810);
                            return;
                        } else if (lZ.field_status != 101) {
                            C4990ab.m7412e("MicroMsg.AppMsgLogic", "ERR:" + C1447g.m3075Mq() + " get status failed: " + str + " status:" + lZ.field_status);
                            AppMethodBeat.m2505o(32810);
                            return;
                        } else {
                            lZ.field_status = 102;
                            lZ.field_lastModifyTime = C5046bo.anT();
                            C14877am.aUq().mo48326a(lZ, new String[0]);
                            AppMethodBeat.m2505o(32810);
                            return;
                        }
                    }
                    j = j;
                    str = str4;
                    lZ = C14877am.aUq().mo48329lZ(j);
                    if (lZ == null) {
                        C4990ab.m7412e("MicroMsg.AppMsgLogic", "ERR:" + C1447g.m3075Mq() + " getinfo failed: " + str);
                    } else if (lZ.field_status != 101) {
                        C4990ab.m7412e("MicroMsg.AppMsgLogic", "ERR:" + C1447g.m3075Mq() + " get status failed: " + str + " status:" + lZ.field_status);
                    } else {
                        if (!C5046bo.isNullOrNil(lZ.field_clientAppDataId) || C5046bo.isNullOrNil(lZ.field_mediaSvrId)) {
                            lZ.field_status = 105;
                        } else {
                            lZ.field_status = 102;
                        }
                        lZ.field_lastModifyTime = C5046bo.anT();
                        C14877am.aUq().mo48326a(lZ, new String[0]);
                    }
                    c7620bi2.setStatus(5);
                    C9638aw.m17190ZK();
                    C18628c.m29080XO().mo15340jf(j);
                    AppMethodBeat.m2505o(32810);
                }
            });
            bool2 = bool;
            str3 = str2;
            final C7620bi c7620bi3 = c7620bi;
            c5410c.zbR.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(32811);
                    if (!bool2.booleanValue()) {
                        long j = j;
                        String str = str3;
                        C30065b lZ = C14877am.aUq().mo48329lZ(j);
                        if (lZ == null) {
                            C4990ab.m7412e("MicroMsg.AppMsgLogic", "ERR:" + C1447g.m3075Mq() + " getinfo failed: " + str);
                        } else if (lZ.field_status == 105 || lZ.field_status == 101) {
                            lZ.field_status = 101;
                            lZ.field_lastModifyTime = C5046bo.anT();
                            C14877am.aUq().mo48326a(lZ, new String[0]);
                            C14877am.dhP().run();
                        } else {
                            C4990ab.m7412e("MicroMsg.AppMsgLogic", "ERR:" + C1447g.m3075Mq() + " get status failed: " + str + " status:" + lZ.field_status);
                        }
                        c7620bi3.setStatus(1);
                        C9638aw.m17190ZK();
                        C18628c.m29080XO().mo15340jf(j);
                    }
                    AppMethodBeat.m2505o(32811);
                }
            });
            AppMethodBeat.m2505o(32817);
        }
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.d$d */
    public static class C5414d extends C5378c {
        private boolean mgQ;
        private C46650a yJI;
        protected C40802i zcO;
        protected C40803l zcP;
        protected C36201j zcQ;

        public final boolean dHk() {
            return false;
        }

        /* renamed from: aH */
        public final boolean mo11016aH(int i, boolean z) {
            if (z || (i != 49 && i != 335544369 && i != 402653233 && i != 369098801)) {
                return false;
            }
            return true;
        }

        /* renamed from: a */
        public final View mo11005a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.m2504i(32834);
            if (view == null || view.getTag() == null) {
                view = new C44341v(layoutInflater, 2130969047);
                view.setTag(new C5410c().mo11055y(view, true));
            }
            AppMethodBeat.m2505o(32834);
            return view;
        }

        /* JADX WARNING: Removed duplicated region for block: B:110:0x0474  */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x0076  */
        /* JADX WARNING: Removed duplicated region for block: B:104:0x042d  */
        /* JADX WARNING: Removed duplicated region for block: B:107:0x0449  */
        /* JADX WARNING: Missing block: B:450:0x15cf, code skipped:
            r7 = null;
            r12 = r6;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: a */
        public final void mo11010a(C5379a c5379a, int i, C46650a c46650a, C7620bi c7620bi, String str) {
            String substring;
            C8910b c8910b;
            C40814ay c40814ay;
            Object obj;
            AppMethodBeat.m2504i(32835);
            C5410c c5410c = (C5410c) c5379a;
            this.yJI = c46650a;
            c5410c.reset();
            String str2 = c7620bi.field_content;
            C36137j c36137j = (C36137j) c46650a.mo74857aF(C36137j.class);
            c36137j.mo57028be(c7620bi);
            c36137j.mo57029bf(c7620bi);
            c36137j.mo57030bg(c7620bi);
            if (this.mgQ) {
                int indexOf = c7620bi.field_content.indexOf(58);
                if (indexOf != -1) {
                    C32222n mj;
                    Object obj2;
                    substring = c7620bi.field_content.substring(indexOf + 1);
                    if (substring == null) {
                        C8910b X = C8910b.m16058X(substring, c7620bi.field_reserved);
                        mj = C32222n.m52572mj(substring);
                        c8910b = X;
                    } else {
                        C4990ab.m7413e("MicroMsg.ChattingItemAppMsgFrom", "amessage, msgid:%s, user:%s", Long.valueOf(c7620bi.field_msgId), str);
                        mj = null;
                        c8910b = null;
                    }
                    c40814ay = new C40814ay(c7620bi, c46650a.dFx(), i, null, 0);
                    obj = null;
                    if (c8910b != null) {
                        List list;
                        Object obj3;
                        Object obj4;
                        final C5410c c5410c2;
                        final C46650a c46650a2;
                        boolean z;
                        C40814ay c40814ay2;
                        Bitmap b;
                        String str3;
                        c5410c.gnB.setText(c8910b.getTitle());
                        c5410c.gnC.setText(c8910b.getDescription());
                        c5410c.zbN.setMaxLines(1);
                        c5410c.gnB.setTextColor(c46650a.yTx.getContext().getResources().getColor(C25738R.color.f12212w4));
                        c5410c.gnC.setTextColor(c46650a.yTx.getContext().getResources().getColor(C25738R.color.f12092s0));
                        c5410c.zcd.setBackgroundResource(C25738R.drawable.b0k);
                        c5410c.zcd.setPadding(0, c46650a.yTx.getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9966lo), 0, 0);
                        c5410c.zbI.setVisibility(0);
                        c5410c.zcb.setVisibility(0);
                        c5410c.gnC.setVisibility(0);
                        c5410c.zbP.setVisibility(8);
                        c5410c.zbS.setVisibility(8);
                        c5410c.zbR.setVisibility(8);
                        c5410c.zcf.setVisibility(8);
                        c5410c.zcg.setVisibility(8);
                        c5410c.zbK.setVisibility(8);
                        c5410c.zbL.setVisibility(8);
                        c5410c.zcq.setVisibility(8);
                        c5410c.zcj.setVisibility(8);
                        c5410c.zcd.setVisibility(0);
                        c5410c.zcv.setVisibility(8);
                        c5410c.zcC.setVisibility(8);
                        C5379a.m8170an(c5410c.zcc, c5410c.zcJ);
                        C45138g c45138g = (C45138g) c8910b.mo20333X(C45138g.class);
                        ChattingItemFooter chattingItemFooter = c5410c.zbV;
                        if (c45138g == null) {
                            list = null;
                        } else {
                            list = c45138g.fgf;
                        }
                        if (chattingItemFooter.mo70214l(list, c7620bi.field_talker)) {
                            c5410c.zcc.setBackgroundResource(C25738R.drawable.f6559i4);
                        } else {
                            c5410c.zcc.setBackgroundResource(C25738R.drawable.f6555i0);
                        }
                        C40439f dX = C46494g.m87742dX(c8910b.appId, c8910b.axy);
                        if (dX != null) {
                            C5378c.m8138b(c46650a, c8910b, c7620bi);
                        }
                        if (dX == null || dX.field_appName == null || dX.field_appName.trim().length() <= 0) {
                            str2 = c8910b.appName;
                        } else {
                            str2 = dX.field_appName;
                        }
                        boolean z2 = true;
                        C1338a.fromDPToPix(c46650a.yTx.getContext(), 12);
                        if (c8910b.type == 20 || "wxaf060266bfa9a35c".equals(c8910b.appId)) {
                            z2 = C14896a.dgQ().cjQ();
                        }
                        if (z2 && c8910b.appId != null && c8910b.appId.length() > 0 && C46494g.m87743dg(str2)) {
                            c5410c.moL.setText(C46494g.m87733b(c46650a.yTx.getContext(), dX, str2));
                            c5410c.moL.setVisibility(0);
                            c5410c.moL.setCompoundDrawables(null, null, null, null);
                            c5410c.zbM.setVisibility(0);
                            c5410c.zbJ.setVisibility(0);
                            if (dX == null || !dX.mo63847xy()) {
                                C5378c.m8126a(c46650a, (View) c5410c.moL, c8910b.appId);
                            } else {
                                C5378c.m8124a(c46650a, (View) c5410c.moL, c7620bi, c8910b, dX.field_packageName, c7620bi.field_msgSvrId);
                            }
                            c5410c.zbJ.setImageResource(C25738R.drawable.f6579ir);
                            C5378c.m8128a(c46650a, c5410c.zbJ, c8910b.appId);
                        } else if (c8910b.type == 24) {
                            c5410c.moL.setText(C4996ah.getContext().getString(C25738R.string.bnl));
                            c5410c.zbM.setVisibility(0);
                            c5410c.moL.setVisibility(0);
                            c5410c.zbJ.setVisibility(8);
                        } else if (c8910b.type == 19 || mj.fju == 19) {
                            c5410c.moL.setText(C4996ah.getContext().getString(C25738R.string.alu));
                            c5410c.zbM.setVisibility(0);
                            c5410c.moL.setVisibility(0);
                            c5410c.zbJ.setVisibility(8);
                        } else if (!C5394d.m8193a(c8910b, c5410c)) {
                            c5410c.zbM.setVisibility(8);
                            c5410c.moL.setVisibility(8);
                            c5410c.zbJ.setVisibility(8);
                        }
                        if (c8910b.fgl == null || c8910b.fgl.fjm == 0) {
                            obj3 = null;
                        } else {
                            obj3 = 1;
                        }
                        if (obj3 != null) {
                            c5410c.zbM.setVisibility(8);
                        }
                        boolean z3 = false;
                        c5410c.zbI.setVisibility(0);
                        if (c8910b.fgl == null || c8910b.fgl.fjj != 1) {
                            obj4 = null;
                        } else {
                            obj4 = 1;
                        }
                        if (obj4 == null && this.kuU) {
                            Bitmap bitmap = null;
                            if (!(c8910b.type == 33 || c8910b.type == 36 || c8910b.type == 44 || C5406b.arC(c7620bi.field_imgPath))) {
                                bitmap = C32291o.ahl().mo73087a(c7620bi.field_imgPath, C1338a.getDensity(c46650a.yTx.getContext()), false);
                            }
                            if (bitmap == null || bitmap.isRecycled()) {
                                z3 = true;
                            } else {
                                c5410c.zbI.setImageBitmap(bitmap);
                            }
                            if (c8910b.type == 3) {
                                c5410c2 = c5410c;
                                c46650a2 = c46650a;
                                c5410c.zcd.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                                    private boolean zcR = false;

                                    public final boolean onPreDraw() {
                                        AppMethodBeat.m2504i(32822);
                                        if (this.zcR) {
                                            c5410c2.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                            AppMethodBeat.m2505o(32822);
                                        } else {
                                            c5410c2.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                            this.zcR = true;
                                            int fromDPToPix = C1338a.fromDPToPix(c46650a2.yTx.getContext(), 24);
                                            Bitmap bitmap = bitmap;
                                            if (bitmap == null || bitmap.isRecycled()) {
                                                bitmap = C5056d.m7644au(c46650a2.yTx.getContext().getResources().getColor(C25738R.color.f11868k0), fromDPToPix, fromDPToPix);
                                            }
                                            int height = bitmap.getHeight();
                                            if (fromDPToPix <= height) {
                                                height = fromDPToPix;
                                            }
                                            Bitmap e = C5056d.m7660e(C5056d.m7639al(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
                                            height = c5410c2.zcd.getHeight();
                                            int width = c5410c2.zcd.getWidth();
                                            if (height == 0) {
                                                height = C1338a.m2856al(c46650a2.yTx.getContext(), C25738R.dimen.f10296x5);
                                            }
                                            if (width == 0) {
                                                width = C1338a.m2856al(c46650a2.yTx.getContext(), C25738R.dimen.f10297x6);
                                            }
                                            c5410c2.zcd.setBackgroundDrawable(new BitmapDrawable(C5056d.m7614a(e, (int) C25738R.drawable.b0k, width, height)));
                                            AppMethodBeat.m2505o(32822);
                                        }
                                        return true;
                                    }
                                });
                            }
                            z = z3;
                        } else {
                            c5410c.zbI.setImageBitmap(BitmapFactory.decodeResource(c46650a.yTx.getMMResources(), C25738R.drawable.ak9));
                            z = false;
                        }
                        if (c8910b.dJv == null || c8910b.dJv.length() == 0) {
                            c5410c.zbU.setVisibility(8);
                        } else {
                            c5410c.zbU.setVisibility(0);
                            mo11018b(c46650a, (View) c5410c.zbU, (Object) C40814ay.arL(c8910b.dJv));
                        }
                        c5410c.zbT.setOnClickListener(null);
                        c5410c.zbX.setVisibility(0);
                        c5410c.zbO.setVisibility(8);
                        c5410c.zca.setVisibility(0);
                        c5410c.zbY.setVisibility(8);
                        Bitmap b2;
                        WxaAttributes zb;
                        CharSequence charSequence;
                        switch (c8910b.type) {
                            case 0:
                                if (c8910b.title == null || c8910b.title.length() <= 0) {
                                    c5410c.gnB.setVisibility(8);
                                } else {
                                    c5410c.gnB.setVisibility(0);
                                }
                                c5410c.gnC.setVisibility(0);
                                c5410c.zbN.setVisibility(8);
                                c5410c.zbT.setVisibility(8);
                                c5410c.zbO.setVisibility(4);
                                c5410c.gnC.setMaxLines(2);
                                if (z) {
                                    b2 = C46494g.m87732b(c8910b.appId, 1, C1338a.getDensity(c46650a.yTx.getContext()));
                                    if (b2 != null && !b2.isRecycled()) {
                                        c5410c.zbI.setImageBitmap(b2);
                                        obj3 = null;
                                        c40814ay2 = c40814ay;
                                        break;
                                    }
                                    c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                                break;
                            case 3:
                                if (c8910b.title == null || c8910b.title.length() <= 0) {
                                    c5410c.gnB.setVisibility(8);
                                } else {
                                    c5410c.gnB.setVisibility(0);
                                    c5410c.gnB.setTextColor(c46650a.yTx.getContext().getResources().getColor(C25738R.color.a69));
                                }
                                c5410c.gnC.setVisibility(0);
                                c5410c.gnC.setTextColor(c46650a.yTx.getContext().getResources().getColor(C25738R.color.a69));
                                c5410c.zbN.setVisibility(8);
                                c5410c.zbO.setVisibility(4);
                                c5410c.zbT.setVisibility(0);
                                if ((c7620bi.field_msgId).equals(c5379a.zbz)) {
                                    c5410c.zbT.setImageResource(C25738R.drawable.f6930vq);
                                } else {
                                    c5410c.zbT.setImageResource(C25738R.drawable.f6932vs);
                                }
                                c5410c.gnC.setMaxLines(2);
                                if (z) {
                                    b2 = C46494g.m87732b(c8910b.appId, 1, C1338a.getDensity(c46650a.yTx.getContext()));
                                    if (b2 == null || b2.isRecycled()) {
                                        c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_music);
                                    } else {
                                        c5410c.zbI.setImageBitmap(b2);
                                    }
                                }
                                C5404f c5404f = new C5404f();
                                c5404f.cvx = c7620bi.field_msgId;
                                c5404f.cHz = c7620bi.field_content;
                                c5404f.imgPath = c7620bi.field_imgPath;
                                c5410c.zbT.setTag(c5404f);
                                c5410c.zbT.setOnClickListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dDa());
                                obj3 = null;
                                c40814ay2 = c40814ay;
                                break;
                            case 4:
                                if (c8910b.title == null || c8910b.title.length() <= 0) {
                                    c5410c.gnB.setVisibility(8);
                                } else {
                                    c5410c.gnB.setVisibility(0);
                                }
                                c5410c.gnC.setVisibility(0);
                                c5410c.zbN.setVisibility(8);
                                c5410c.zbT.setVisibility(0);
                                c5410c.zbT.setImageResource(C25738R.drawable.a4k);
                                c5410c.zbO.setVisibility(4);
                                c5410c.gnC.setMaxLines(2);
                                if (z) {
                                    b2 = C46494g.m87732b(c8910b.appId, 1, C1338a.getDensity(c46650a.yTx.getContext()));
                                    if (b2 == null || b2.isRecycled()) {
                                        c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_video);
                                    } else {
                                        c5410c.zbI.setImageBitmap(b2);
                                    }
                                    c5410c.zbT.setVisibility(8);
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                                break;
                            case 5:
                                C25747e c25747e = (C25747e) c8910b.mo20333X(C25747e.class);
                                if (c25747e == null || c25747e.fgb != 1 || c25747e.ffZ != 5 || !((C20023b) C1720g.m3528K(C20023b.class)).aVP()) {
                                    c5410c.gnB.setVisibility(8);
                                    if (c8910b.title == null || c8910b.title.length() <= 0) {
                                        c5410c.zbN.setVisibility(8);
                                    } else {
                                        c5410c.zbN.setMaxLines(2);
                                        c5410c.zbN.setVisibility(0);
                                        c5410c.zbN.setText(c8910b.getTitle());
                                    }
                                    c5410c.gnC.setMaxLines(3);
                                    if (C5394d.m8194h(c8910b)) {
                                        c5410c.zbT.setVisibility(0);
                                        c5410c.zbT.setImageResource(C25738R.drawable.a4k);
                                    } else {
                                        c5410c.zbT.setVisibility(8);
                                    }
                                    c5410c.zbO.setVisibility(4);
                                    if (z) {
                                        b2 = C46494g.m87732b(c8910b.appId, 1, C1338a.getDensity(c46650a.yTx.getContext()));
                                        if (b2 != null && !b2.isRecycled()) {
                                            c5410c.zbI.setImageBitmap(b2);
                                            obj3 = null;
                                            c40814ay2 = c40814ay;
                                            break;
                                        }
                                        C17927a c17927a = new C17927a();
                                        c17927a.ePT = C1318a.app_attach_file_icon_webpage;
                                        c17927a.ePG = true;
                                        c17927a.ePK = C43217c.bGF();
                                        c17927a.mo33448ct(C1338a.fromDPToPix(C4996ah.getContext(), 50), C1338a.fromDPToPix(C4996ah.getContext(), 50)).ePF = true;
                                        C32291o.ahp().mo43766a(C5046bo.isNullOrNil(c8910b.thumburl) ? c8910b.fgv : c8910b.thumburl, c5410c.zbI, c17927a.ahG());
                                        obj3 = null;
                                        c40814ay2 = c40814ay;
                                        break;
                                    }
                                }
                                C5410c.m8217a(c46650a, c5410c, c8910b, c7620bi, z);
                                obj3 = null;
                                c40814ay2 = c40814ay;
                                break;
                                break;
                            case 6:
                                if (c8910b.title == null || c8910b.title.length() <= 0) {
                                    c5410c.gnB.setVisibility(8);
                                } else {
                                    c5410c.gnB.setVisibility(0);
                                    c5410c.gnB.setMaxLines(2);
                                }
                                c5410c.gnC.setVisibility(0);
                                c5410c.zbN.setVisibility(8);
                                c5410c.zbT.setVisibility(8);
                                c5410c.zbO.setVisibility(4);
                                c5410c.gnC.setMaxLines(2);
                                c5410c.gnC.setText(C5046bo.m7565ga((long) c8910b.fgo));
                                C5410c.m8220a(c5410c, substring, c8910b.fgo);
                                C5410c.m8219a(c5410c, Boolean.TRUE, c7620bi, c8910b.csD, c8910b.title);
                                if (z) {
                                    if (!C5046bo.any(c8910b.fgp)) {
                                        c5410c.zbI.setImageResource(C44065o.aiD(c8910b.fgp));
                                        obj3 = null;
                                        c40814ay2 = c40814ay;
                                        break;
                                    }
                                    c5410c.zbI.setImageResource(C25738R.drawable.aay);
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                                break;
                            case 7:
                                c5410c.gnB.setVisibility(8);
                                if (c8910b.title == null || c8910b.title.trim().length() <= 0) {
                                    c5410c.zbN.setVisibility(8);
                                } else {
                                    c5410c.zbN.setMaxLines(2);
                                    c5410c.zbN.setVisibility(0);
                                    c5410c.zbN.setText(c8910b.getTitle());
                                }
                                c5410c.gnC.setMaxLines(3);
                                c5410c.zbT.setVisibility(8);
                                c5410c.zbO.setVisibility(4);
                                if (z) {
                                    b2 = C46494g.m87732b(c8910b.appId, 1, C1338a.getDensity(c46650a.yTx.getContext()));
                                    if (b2 != null && !b2.isRecycled()) {
                                        c5410c.zbI.setImageBitmap(b2);
                                        obj3 = null;
                                        c40814ay2 = c40814ay;
                                        break;
                                    }
                                    c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                                break;
                            case 10:
                                c5410c.zbN.setVisibility(0);
                                if (c8910b.fgP == 1) {
                                    c5410c.zbN.setText(C25738R.string.dyb);
                                } else if (c8910b.fgP == 2) {
                                    c5410c.zbN.setText(C25738R.string.dyd);
                                } else if (c8910b.fgP == 3) {
                                    c5410c.zbN.setText(C25738R.string.dyc);
                                } else {
                                    c5410c.zbN.setText(C25738R.string.dye);
                                }
                                if (c8910b.title != null && c8910b.title.length() > 0) {
                                    c5410c.gnB.setVisibility(0);
                                    c5410c.gnB.setText(c8910b.getTitle());
                                }
                                c5410c.gnC.setMaxLines(4);
                                c5410c.zbO.setVisibility(4);
                                c5410c.zbT.setVisibility(8);
                                if (z) {
                                    b2 = C32291o.ahl().mo73104b(c7620bi.field_imgPath, C1338a.getDensity(c46650a.yTx.getContext()), false);
                                    if (b2 != null && !b2.isRecycled()) {
                                        c5410c.zbI.setImageBitmap(b2);
                                        obj3 = null;
                                        c40814ay2 = c40814ay;
                                        break;
                                    }
                                    c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                                break;
                            case 13:
                                c5410c.gnB.setVisibility(0);
                                c5410c.gnB.setText(c8910b.getTitle());
                                c5410c.zbN.setVisibility(0);
                                c5410c.zbN.setText(C25738R.string.amu);
                                c5410c.gnC.setMaxLines(4);
                                c5410c.zbO.setVisibility(4);
                                c5410c.zbT.setVisibility(8);
                                if (z) {
                                    b2 = C32291o.ahl().mo73104b(c7620bi.field_imgPath, C1338a.getDensity(c46650a.yTx.getContext()), false);
                                    if (b2 != null && !b2.isRecycled()) {
                                        c5410c.zbI.setImageBitmap(b2);
                                        obj3 = null;
                                        c40814ay2 = c40814ay;
                                        break;
                                    }
                                    c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                                break;
                            case 15:
                                if (c8910b.title == null || c8910b.title.length() <= 0) {
                                    c5410c.gnB.setVisibility(8);
                                } else {
                                    c5410c.gnB.setVisibility(0);
                                }
                                c5410c.gnC.setVisibility(0);
                                c5410c.zbN.setVisibility(8);
                                c5410c.zbT.setVisibility(8);
                                c5410c.zbO.setVisibility(4);
                                c5410c.gnC.setMaxLines(2);
                                if (z) {
                                    b = C32291o.ahl().mo73104b(c7620bi.field_imgPath, C1338a.getDensity(c46650a.yTx.getContext()), false);
                                    if (b == null || b.isRecycled()) {
                                        c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                                    } else {
                                        c5410c.zbI.setImageBitmap(b);
                                    }
                                }
                                c40814ay = new C40814ay(c7620bi, false, i, "", false, c8910b.title, c8910b.cMg, c8910b.cMh, c8910b.title, c8910b.fgX, c8910b.url, false, false);
                                c5410c.zcc.setTag(c40814ay);
                                c5410c.zcc.setOnClickListener(mo11030i(c46650a));
                                obj = 1;
                                obj3 = null;
                                c40814ay2 = c40814ay;
                                break;
                            case 16:
                                c5410c.gnB.setVisibility(0);
                                c5410c.gnB.setText(c8910b.description);
                                c5410c.gnC.setText(c8910b.fhC);
                                if (c8910b.title == null || c8910b.title.length() <= 0) {
                                    c5410c.zbN.setVisibility(8);
                                } else {
                                    c5410c.zbN.setVisibility(0);
                                    c5410c.zbN.setText(c8910b.title);
                                }
                                c5410c.gnC.setMaxLines(4);
                                c5410c.zbO.setVisibility(4);
                                c5410c.zbT.setVisibility(8);
                                if (z) {
                                    b2 = C32291o.ahl().mo73104b(c7620bi.field_imgPath, C1338a.getDensity(c46650a.yTx.getContext()), false);
                                    if (b2 == null) {
                                        c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                                        obj3 = null;
                                        c40814ay2 = c40814ay;
                                        break;
                                    }
                                    c5410c.zbI.setImageBitmap(b2);
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                                break;
                            case 19:
                                C5410c.m8218a(c46650a, c5410c, c8910b, z);
                                obj3 = null;
                                c40814ay2 = c40814ay;
                                break;
                            case 20:
                                if (c8910b.title != null && c8910b.title.length() > 0) {
                                    c5410c.gnB.setVisibility(0);
                                    c5410c.gnB.setText(c8910b.getTitle());
                                    c5410c.zbN.setVisibility(8);
                                }
                                c5410c.gnC.setMaxLines(4);
                                c5410c.zbO.setVisibility(4);
                                c5410c.zbT.setVisibility(8);
                                if (z) {
                                    b2 = C32291o.ahl().mo73104b(c7620bi.field_imgPath, C1338a.getDensity(c46650a.yTx.getContext()), false);
                                    if (b2 != null && !b2.isRecycled()) {
                                        c5410c.zbI.setImageBitmap(b2);
                                        obj3 = null;
                                        c40814ay2 = c40814ay;
                                        break;
                                    }
                                    c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                                break;
                            case 24:
                                c5410c.gnB.setVisibility(8);
                                c5410c.zbN.setVisibility(0);
                                if (c8910b.title == null || c8910b.title.trim().length() <= 0) {
                                    c5410c.zbN.setText(C44089j.m79293b(c5410c.zbN.getContext(), C4996ah.getContext().getString(C25738R.string.bsc), c5410c.zbN.getTextSize()));
                                } else {
                                    c5410c.zbN.setText(C44089j.m79293b(c5410c.zbN.getContext(), c8910b.title, c5410c.zbN.getTextSize()));
                                }
                                c5410c.gnC.setMaxLines(3);
                                c5410c.zbT.setVisibility(8);
                                c5410c.zbO.setVisibility(4);
                                if (z) {
                                    c5410c.zbI.setVisibility(8);
                                    c5410c.zcb.setVisibility(8);
                                }
                                C5410c.m8221b(c46650a, c5410c, c8910b, c7620bi, z);
                                obj3 = null;
                                c40814ay2 = c40814ay;
                                break;
                            case 25:
                                if (c8910b.title == null || c8910b.title.length() <= 0) {
                                    c5410c.gnB.setVisibility(8);
                                } else {
                                    c5410c.gnB.setVisibility(0);
                                }
                                c5410c.gnC.setVisibility(0);
                                c5410c.zbN.setVisibility(8);
                                c5410c.zbT.setVisibility(8);
                                c5410c.zbO.setVisibility(4);
                                c5410c.gnC.setMaxLines(2);
                                if (z) {
                                    b = C32291o.ahl().mo73104b(c7620bi.field_imgPath, C1338a.getDensity(c46650a.yTx.getContext()), false);
                                    if (b == null || b.isRecycled()) {
                                        c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                                    } else {
                                        c5410c.zbI.setImageBitmap(b);
                                    }
                                }
                                c40814ay = new C40814ay(c7620bi, i, "", c46650a.dDw(), c8910b.cMg, c8910b.cMh, c8910b.title, c8910b.fiD, c8910b.designerName, c8910b.designerRediretctUrl, c8910b.url);
                                c5410c.zcc.setTag(c40814ay);
                                FrameLayout frameLayout = c5410c.zcc;
                                if (this.zcO == null) {
                                    this.zcO = new C40802i(c46650a);
                                }
                                frameLayout.setOnClickListener(this.zcO);
                                obj = 1;
                                obj3 = null;
                                c40814ay2 = c40814ay;
                                break;
                            case 26:
                            case 27:
                                if (c8910b.title == null || c8910b.title.length() <= 0) {
                                    c5410c.gnB.setVisibility(8);
                                } else {
                                    c5410c.gnB.setVisibility(0);
                                }
                                c5410c.gnC.setVisibility(0);
                                c5410c.zbN.setVisibility(8);
                                c5410c.zbT.setVisibility(8);
                                c5410c.zbO.setVisibility(4);
                                c5410c.gnC.setMaxLines(2);
                                if (z) {
                                    b = C32291o.ahl().mo73104b(c7620bi.field_imgPath, C1338a.getDensity(c46650a.yTx.getContext()), false);
                                    if (b == null || b.isRecycled()) {
                                        c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                                    } else {
                                        c5410c.zbI.setImageBitmap(b);
                                    }
                                }
                                c40814ay2 = new C40814ay();
                                c40814ay2.cKd = c7620bi;
                                c40814ay2.yFW = false;
                                c40814ay2.position = i;
                                c40814ay2.zis = false;
                                c40814ay2.title = c46650a.dDw();
                                c40814ay2.cMg = c8910b.cMg;
                                c40814ay2.cMh = c8910b.cMh;
                                c40814ay2.zit = c8910b.title;
                                FrameLayout frameLayout2;
                                if (c8910b.type == 26) {
                                    c40814ay2.tid = c8910b.tid;
                                    c40814ay2.fiE = c8910b.fiE;
                                    c40814ay2.desc = c8910b.desc;
                                    c40814ay2.iconUrl = c8910b.iconUrl;
                                    c40814ay2.secondUrl = c8910b.secondUrl;
                                    c40814ay2.pageType = c8910b.pageType;
                                    frameLayout2 = c5410c.zcc;
                                    if (this.zcP == null) {
                                        this.zcP = new C40803l(c46650a);
                                    }
                                    frameLayout2.setOnClickListener(this.zcP);
                                    obj2 = 1;
                                } else if (c8910b.type == 27) {
                                    c40814ay2.tid = c8910b.tid;
                                    c40814ay2.fiE = c8910b.fiE;
                                    c40814ay2.desc = c8910b.desc;
                                    c40814ay2.iconUrl = c8910b.iconUrl;
                                    c40814ay2.secondUrl = c8910b.secondUrl;
                                    c40814ay2.pageType = c8910b.pageType;
                                    frameLayout2 = c5410c.zcc;
                                    if (this.zcQ == null) {
                                        this.zcQ = new C36201j(c46650a);
                                    }
                                    frameLayout2.setOnClickListener(this.zcQ);
                                    obj2 = 1;
                                } else {
                                    obj2 = null;
                                }
                                c5410c.zcc.setTag(c40814ay2);
                                obj3 = null;
                                obj = obj2;
                                break;
                            case 33:
                                zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(c8910b.fiP);
                                switch (c8910b.fiR) {
                                    case 0:
                                        c5410c.zbM.setVisibility(0);
                                        c5410c.zbJ.setVisibility(0);
                                        c5410c.zbJ.setBackground(null);
                                        c5410c.zbJ.setImageResource(C1318a.app_brand_we_app_logo_share);
                                        C5394d.m8192a(c5410c.moL, c8910b);
                                    case 1:
                                        if (zb != null) {
                                            charSequence = zb.field_nickname;
                                        } else {
                                            obj4 = c8910b.title;
                                        }
                                        str2 = zb != null ? zb.field_smallHeadURL : null;
                                        c5410c.zcd.setVisibility(8);
                                        c5410c.zcq.setVisibility(8);
                                        c5410c.zcj.setVisibility(0);
                                        c5410c.zcl.setText(charSequence);
                                        c5410c.zcv.setVisibility(8);
                                        if (!C5046bo.isNullOrNil(str2)) {
                                            C37926b.abR().mo60683a(c5410c.zck, str2, C32804a.abQ(), C42201f.fqH);
                                            obj3 = null;
                                            c40814ay2 = c40814ay;
                                            break;
                                        }
                                        C37926b.abR().mo60683a(c5410c.zck, "file://".concat(String.valueOf(C32291o.ahl().mo73108c(c7620bi.field_imgPath, false, true))), C32804a.abQ(), C42201f.fqH);
                                        obj3 = null;
                                        c40814ay2 = c40814ay;
                                        break;
                                    case 2:
                                    case 3:
                                        if (zb != null) {
                                            charSequence = zb.field_nickname;
                                        } else {
                                            obj4 = c8910b.cMh;
                                        }
                                        if (zb != null) {
                                            str2 = zb.field_smallHeadURL;
                                        } else {
                                            str2 = c8910b.fjb;
                                        }
                                        c5410c.zcd.setVisibility(8);
                                        c5410c.zcq.setVisibility(0);
                                        c5410c.zcj.setVisibility(8);
                                        c5410c.zcm.setVisibility(8);
                                        c5410c.zcv.setVisibility(8);
                                        c5410c.zct.setText(c8910b.title);
                                        c5410c.zcm.setText(c8910b.description);
                                        c5410c.zco.setText(charSequence);
                                        C5394d.m8192a(c5410c.zcp, c8910b);
                                        C32291o.ahp().mo43766a(str2, c5410c.zcn, C30616d.zel);
                                        str2 = C32291o.ahl().mo73108c(c7620bi.field_imgPath, false, true);
                                        c5410c.zcr.setImageBitmap(null);
                                        c5410c.zcr.setVisibility(4);
                                        c5410c.zcs.setVisibility(0);
                                        c5410c2 = c5410c;
                                        C37926b.abR().mo60686a(new C9676i() {
                                            public final void abU() {
                                            }

                                            /* renamed from: x */
                                            public final void mo6524x(Bitmap bitmap) {
                                                AppMethodBeat.m2504i(32823);
                                                if (bitmap == null || bitmap.isRecycled()) {
                                                    c5410c2.zcr.setVisibility(4);
                                                    c5410c2.zcs.setVisibility(0);
                                                    AppMethodBeat.m2505o(32823);
                                                    return;
                                                }
                                                c5410c2.zcr.setImageBitmap(bitmap);
                                                c5410c2.zcr.setVisibility(0);
                                                c5410c2.zcs.setVisibility(4);
                                                AppMethodBeat.m2505o(32823);
                                            }

                                            /* renamed from: mr */
                                            public final void mo6522mr() {
                                            }

                                            /* renamed from: wP */
                                            public final String mo6523wP() {
                                                AppMethodBeat.m2504i(32824);
                                                String str = "CHAT#" + C38496n.m65148bE(this);
                                                AppMethodBeat.m2505o(32824);
                                                return str;
                                            }
                                        }, "file://".concat(String.valueOf(str2)), null, ((C32809i) C1720g.m3528K(C32809i.class)).mo22292cq(240, C33250az.CTRL_INDEX));
                                        obj3 = null;
                                        c40814ay2 = c40814ay;
                                        break;
                                    default:
                                        obj3 = 1;
                                        c40814ay2 = c40814ay;
                                        break;
                                }
                            case 34:
                                if (c8910b.title == null || c8910b.title.length() <= 0) {
                                    c5410c.gnB.setVisibility(8);
                                } else {
                                    c5410c.gnB.setVisibility(0);
                                    if (C5046bo.isNullOrNil(c8910b.fhL)) {
                                        c5410c.gnB.setTextColor(c46650a.yTx.getContext().getResources().getColor(C25738R.color.f11782h4));
                                    } else {
                                        c5410c.gnB.setTextColor(C5046bo.m7530bS(c8910b.fhL, c46650a.yTx.getContext().getResources().getColor(C25738R.color.f11782h4)));
                                    }
                                }
                                c5410c.gnC.setMaxLines(2);
                                c5410c.gnC.setVisibility(0);
                                if (C5046bo.isNullOrNil(c8910b.fhM)) {
                                    c5410c.gnC.setTextColor(c46650a.yTx.getContext().getResources().getColor(C25738R.color.f12073rb));
                                } else {
                                    c5410c.gnC.setTextColor(C5046bo.m7530bS(c8910b.fhM, c46650a.yTx.getContext().getResources().getColor(C25738R.color.f12073rb)));
                                }
                                c5410c.zbN.setVisibility(8);
                                c5410c.zbO.setVisibility(4);
                                c5410c.zbT.setVisibility(8);
                                c5410c.zbM.setVisibility(0);
                                c5410c.moL.setVisibility(0);
                                if (C5046bo.isNullOrNil(c8910b.fhH)) {
                                    c5410c.moL.setText(C25738R.string.als);
                                } else {
                                    c5410c.moL.setText(c8910b.fhH);
                                }
                                if (!this.kuU) {
                                    c5410c.zbI.setImageBitmap(BitmapFactory.decodeResource(c46650a.yTx.getMMResources(), C25738R.drawable.ak9));
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                                b2 = C32291o.ahl().mo73087a(c7620bi.field_imgPath, C1338a.getDensity(c46650a.yTx.getContext()), false);
                                if (!(b2 == null || b2.isRecycled())) {
                                    c5410c.zbI.setImageBitmap(C5056d.m7616a(b2, false, (float) (b2.getWidth() / 2)));
                                }
                                if (!C5046bo.isNullOrNil(c8910b.fhK)) {
                                    C25815a ahp = C32291o.ahp();
                                    str3 = c8910b.fhK;
                                    ImageView imageView = new ImageView(c46650a.yTx.getContext());
                                    C17927a c17927a2 = new C17927a();
                                    c17927a2.ePH = true;
                                    c5410c2 = c5410c;
                                    c46650a2 = c46650a;
                                    ahp.mo43767a(str3, imageView, c17927a2.ahG(), new C9014g() {
                                        /* renamed from: sH */
                                        public final void mo7596sH(String str) {
                                        }

                                        /* renamed from: a */
                                        public final Bitmap mo7594a(String str, View view, C37477b c37477b) {
                                            return null;
                                        }

                                        /* renamed from: b */
                                        public final void mo7595b(String str, View view, C37477b c37477b) {
                                            AppMethodBeat.m2504i(32831);
                                            if (c37477b.bitmap != null) {
                                                final Bitmap bitmap = c37477b.bitmap;
                                                c5410c2.zcd.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                                                    public final boolean onPreDraw() {
                                                        AppMethodBeat.m2504i(32830);
                                                        c5410c2.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                                        int height = c5410c2.zcd.getHeight();
                                                        int width = c5410c2.zcd.getWidth();
                                                        if (height == 0) {
                                                            height = C1338a.m2856al(c46650a2.yTx.getContext(), C25738R.dimen.f10296x5);
                                                        }
                                                        if (width == 0) {
                                                            width = C1338a.m2856al(c46650a2.yTx.getContext(), C25738R.dimen.f10297x6);
                                                        }
                                                        c5410c2.zcd.setBackgroundDrawable(new BitmapDrawable(C5056d.m7614a(bitmap, (int) C25738R.drawable.b0k, width, height)));
                                                        AppMethodBeat.m2505o(32830);
                                                        return true;
                                                    }
                                                });
                                            }
                                            AppMethodBeat.m2505o(32831);
                                        }
                                    });
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                                c5410c2 = c5410c;
                                c46650a2 = c46650a;
                                c5410c.zcd.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
                                    private boolean zcR = false;

                                    public final boolean onPreDraw() {
                                        AppMethodBeat.m2504i(32832);
                                        if (this.zcR) {
                                            c5410c2.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                            AppMethodBeat.m2505o(32832);
                                        } else {
                                            c5410c2.zcd.getViewTreeObserver().removeOnPreDrawListener(this);
                                            this.zcR = true;
                                            int fromDPToPix = C1338a.fromDPToPix(c46650a2.yTx.getContext(), 24);
                                            Bitmap bitmap = b2;
                                            if (bitmap == null || bitmap.isRecycled()) {
                                                bitmap = C5056d.m7644au(c46650a2.yTx.getContext().getResources().getColor(C25738R.color.f11868k0), fromDPToPix, fromDPToPix);
                                            }
                                            int height = bitmap.getHeight();
                                            if (fromDPToPix <= height) {
                                                height = fromDPToPix;
                                            }
                                            Bitmap e = C5056d.m7660e(C5056d.m7639al(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
                                            height = c5410c2.zcd.getHeight();
                                            int width = c5410c2.zcd.getWidth();
                                            if (height == 0) {
                                                height = C1338a.m2856al(c46650a2.yTx.getContext(), C25738R.dimen.f10296x5);
                                            }
                                            if (width == 0) {
                                                width = C1338a.m2856al(c46650a2.yTx.getContext(), C25738R.dimen.f10297x6);
                                            }
                                            c5410c2.zcd.setBackgroundDrawable(new BitmapDrawable(C5056d.m7614a(e, (int) C25738R.drawable.b0k, width, height)));
                                            AppMethodBeat.m2505o(32832);
                                        }
                                        return true;
                                    }
                                });
                                obj3 = null;
                                c40814ay2 = c40814ay;
                                break;
                                break;
                            case 36:
                                zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(c8910b.fiP);
                                if (zb != null) {
                                    charSequence = zb.field_nickname;
                                } else {
                                    obj4 = c8910b.cMh;
                                }
                                if (zb != null) {
                                    str2 = zb.field_smallHeadURL;
                                } else {
                                    str2 = c8910b.fjb;
                                }
                                c5410c.zcd.setVisibility(8);
                                c5410c.zcq.setVisibility(0);
                                c5410c.zcj.setVisibility(8);
                                c5410c.zcm.setVisibility(8);
                                c5410c.zcv.setVisibility(8);
                                c5410c.zct.setText(c8910b.title);
                                c5410c.zcm.setText(c8910b.description);
                                c5410c.zco.setText(charSequence);
                                C5394d.m8192a(c5410c.zcp, c8910b);
                                C32291o.ahp().mo43766a(str2, c5410c.zcn, C30616d.zel);
                                String c = C32291o.ahl().mo73108c(c7620bi.field_imgPath, false, true);
                                c5410c.zcr.setImageBitmap(null);
                                C37926b.abR().mo60684a(c5410c.zcr, "file://".concat(String.valueOf(c)), null, null, ((C32809i) C1720g.m3528K(C32809i.class)).mo22292cq(240, C33250az.CTRL_INDEX));
                                obj3 = null;
                                c40814ay2 = c40814ay;
                                break;
                            case 40:
                                if (mj.fju == 19) {
                                    C5410c.m8218a(c46650a, c5410c, c8910b, z);
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                            case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                                if (!c8910b.mo20336cw(false)) {
                                    obj3 = 1;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                                str2 = c8910b.mo20339p(c46650a.yTx.getContext(), false);
                                if (!C5046bo.isNullOrNil(str2)) {
                                    c5410c.zcB.setText(str2);
                                    c5410c.zcd.setVisibility(8);
                                    c5410c.zcq.setVisibility(8);
                                    c5410c.zcj.setVisibility(8);
                                    c5410c.zcv.setVisibility(0);
                                    c5410c.zcw.setText(c8910b.title);
                                    c5410c.zcx.setText(c8910b.description);
                                    if (C8913a.BUSINESS_MY_LIFE_AROUND.ordinal() == c8910b.fiW) {
                                        c5410c.zcA.setImageResource(C1318a.my_life_around_default_icon);
                                    } else if (C8913a.BUSINESS_OTHER.ordinal() == c8910b.fiW) {
                                        c5410c2 = c5410c;
                                        C32291o.aho().mo53003a(c8910b.fjb, new C32293a() {
                                            /* renamed from: i */
                                            public final void mo11044i(String str, final Bitmap bitmap) {
                                                AppMethodBeat.m2504i(32826);
                                                C5004al.m7441d(new Runnable() {
                                                    public final void run() {
                                                        AppMethodBeat.m2504i(32825);
                                                        c5410c2.zcA.setImageBitmap(bitmap);
                                                        AppMethodBeat.m2505o(32825);
                                                    }
                                                });
                                                AppMethodBeat.m2505o(32826);
                                            }
                                        });
                                    }
                                    str2 = C32291o.ahl().mo73108c(c7620bi.field_imgPath, false, true);
                                    c5410c.zcz.setImageBitmap(null);
                                    c5410c2 = c5410c;
                                    C37926b.abR().mo60686a(new C9676i() {
                                        public final void abU() {
                                            AppMethodBeat.m2504i(32827);
                                            c5410c2.zcz.setVisibility(4);
                                            c5410c2.zcy.setVisibility(0);
                                            AppMethodBeat.m2505o(32827);
                                        }

                                        /* renamed from: x */
                                        public final void mo6524x(Bitmap bitmap) {
                                            AppMethodBeat.m2504i(32828);
                                            if (!(bitmap == null || bitmap.isRecycled())) {
                                                c5410c2.zcz.setImageBitmap(bitmap);
                                                c5410c2.zcz.setVisibility(0);
                                                c5410c2.zcy.setVisibility(4);
                                            }
                                            AppMethodBeat.m2505o(32828);
                                        }

                                        /* renamed from: mr */
                                        public final void mo6522mr() {
                                        }

                                        /* renamed from: wP */
                                        public final String mo6523wP() {
                                            AppMethodBeat.m2504i(32829);
                                            String str = "CHAT#" + C38496n.m65148bE(this);
                                            AppMethodBeat.m2505o(32829);
                                            return str;
                                        }
                                    }, "file://".concat(String.valueOf(str2)), null, ((C32809i) C1720g.m3528K(C32809i.class)).mo22287a(240, 120, C32807a.DECODE_TYPE_ORIGIN));
                                    obj3 = null;
                                    c40814ay2 = c40814ay;
                                    break;
                                }
                                obj3 = 1;
                                c40814ay2 = c40814ay;
                                break;
                            default:
                                obj3 = 1;
                                c40814ay2 = c40814ay;
                                break;
                        }
                        if (obj3 != null) {
                            if (c8910b.title == null || c8910b.title.length() <= 0) {
                                c5410c.zbN.setVisibility(8);
                            } else {
                                c5410c.zbN.setVisibility(0);
                                c5410c.zbN.setMaxLines(2);
                                c5410c.zbN.setText(c8910b.title);
                            }
                            c5410c.gnB.setVisibility(8);
                            if (z) {
                                if (c8910b.type == 33 || c8910b.type == 36 || c8910b.type == 44) {
                                    str3 = C32291o.ahl().mo73108c(c7620bi.field_imgPath, false, true);
                                    c5410c.zbI.setImageResource(C1318a.app_attach_file_icon_webpage);
                                    C37926b.abR().mo60684a(c5410c.zbI, "file://".concat(String.valueOf(str3)), null, null, ((C32809i) C1720g.m3528K(C32809i.class)).mo22292cq(50, 50));
                                } else {
                                    b = C32291o.ahl().mo73104b(c7620bi.field_imgPath, C1338a.getDensity(c46650a.yTx.getContext()), false);
                                    if (b == null || b.isRecycled()) {
                                        b = C32291o.ahl().mo73087a(c7620bi.field_imgPath, C1338a.getDensity(c46650a.yTx.getContext()), false);
                                    }
                                    if (b == null || b.isRecycled()) {
                                        c5410c.zbI.setImageResource(C25738R.drawable.aay);
                                    } else {
                                        c5410c.zbI.setImageBitmap(b);
                                    }
                                }
                            }
                        }
                        if (c46650a.dFx()) {
                            c5410c.zbW.setVisibility(8);
                            c40814ay = c40814ay2;
                        } else if (C46494g.m87749h(dX)) {
                            c5410c.zbW.setVisibility(0);
                            C5378c.m8140c(c46650a, c5410c.zbW, C40814ay.m70729a(c8910b, c7620bi));
                            obj2 = c40814ay2;
                        } else {
                            c5410c.zbW.setVisibility(8);
                            c40814ay = c40814ay2;
                        }
                    }
                    if (obj == null) {
                        c5410c.zcc.setTag(obj2);
                        c5410c.zcc.setOnClickListener(mo11022d(c46650a));
                    }
                    if (this.kuU) {
                        c5410c.zcc.setOnLongClickListener(mo11021c(c46650a));
                        c5410c.zcc.setOnTouchListener(((C15612h) c46650a.mo74857aF(C15612h.class)).dCZ());
                    }
                    AppMethodBeat.m2505o(32835);
                }
            }
            substring = str2;
            if (substring == null) {
            }
            c40814ay = new C40814ay(c7620bi, c46650a.dFx(), i, null, 0);
            obj = null;
            if (c8910b != null) {
            }
            if (obj == null) {
            }
            if (this.kuU) {
            }
            AppMethodBeat.m2505o(32835);
        }

        /* renamed from: a */
        public final boolean mo11013a(ContextMenu contextMenu, View view, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32836);
            int i = ((C40814ay) view.getTag()).position;
            int aiL = C4733l.aiL(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
            C8910b me = C8910b.m16064me(C1829bf.m3745b(this.yJI.dFx(), c7620bi.field_content, c7620bi.field_isSend));
            C40439f bT = C46494g.m87739bT(me.appId, false);
            if (C46494g.m87750i(bT) && !C40788j.m70653aA(c7620bi)) {
                if (me.type == 6) {
                    C30065b aiM = C4733l.aiM(me.csD);
                    if ((aiM == null || !C5406b.m8212e(c7620bi, aiM.field_fileFullPath)) && !c7620bi.dtH()) {
                        contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.dr1));
                    }
                } else {
                    contextMenu.add(i, 111, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.dr1));
                }
            }
            if (me.fgo <= 0 || (me.fgo > 0 && aiL >= 100)) {
                boolean aex;
                switch (me.type) {
                    case 1:
                        aex = C17903f.aex();
                        break;
                    case 2:
                        aex = C17903f.aey();
                        break;
                    case 3:
                        aex = C17903f.aeH();
                        break;
                    case 4:
                        aex = C17903f.aez();
                        break;
                    case 5:
                        aex = C17903f.aeD();
                        break;
                    case 6:
                        aex = C17903f.aeF();
                        if (!C5046bo.any(me.fgp)) {
                            contextMenu.add(i, 150, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.amd));
                            break;
                        }
                        break;
                    case 8:
                        aex = C17903f.aeB();
                        break;
                    case 16:
                        if (me.fhD != 5 && me.fhD != 6 && me.fhD != 2) {
                            aex = false;
                            break;
                        }
                        if (me.fhD != 2 || C1831bh.m3770o(c7620bi)) {
                            contextMenu.clear();
                        }
                        contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
                        AppMethodBeat.m2505o(32836);
                        return false;
                        break;
                    case 34:
                        contextMenu.clear();
                        contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
                        AppMethodBeat.m2505o(32836);
                        return false;
                    default:
                        aex = false;
                        break;
                }
                if (aex && !this.yJI.dFy()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(C25738R.string.am3));
                }
            }
            if (C25985d.afj("favorite") && (bT == null || !bT.mo63847xy())) {
                switch (me.type) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 10:
                    case 13:
                    case 19:
                    case 20:
                    case 24:
                        contextMenu.add(i, 116, 0, view.getContext().getString(C25738R.string.dcq));
                        break;
                }
            }
            C9321dq c9321dq = new C9321dq();
            c9321dq.cxc.cvx = c7620bi.field_msgId;
            C4879a.xxA.mo10055m(c9321dq);
            if (c9321dq.cxd.cwB || C5406b.m8211a(this.yJI.yTx.getContext(), me)) {
                contextMenu.add(i, GmsClientSupervisor.DEFAULT_BIND_FLAGS, 0, view.getContext().getString(C25738R.string.amc));
            }
            if (C1831bh.m3770o(c7620bi)) {
                contextMenu.clear();
            }
            if (!this.yJI.dFy()) {
                contextMenu.add(i, 100, 0, this.yJI.yTx.getMMResources().getString(C25738R.string.am7));
            }
            AppMethodBeat.m2505o(32836);
            return true;
        }

        /* renamed from: a */
        public final boolean mo11014a(MenuItem menuItem, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32837);
            switch (menuItem.getItemId()) {
                case 100:
                    AppMethodBeat.m2505o(32837);
                    break;
                case 111:
                    C5406b.m8210a(c46650a, c7620bi, mo11017b(c46650a, c7620bi));
                    AppMethodBeat.m2505o(32837);
                    break;
                case 114:
                    String str = c7620bi.field_content;
                    if (str != null) {
                        C8910b me = C8910b.m16064me(str);
                        if (me != null) {
                            switch (me.type) {
                                case 1:
                                    C44288am.m80035m(C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend), c46650a.yTx.getContext());
                                    break;
                                case 2:
                                    C44288am.m80025a(c7620bi, c46650a.yTx.getContext(), mo11017b(c46650a, c7620bi), c46650a.dFx());
                                    break;
                                case 3:
                                    C44288am.m80026a(c7620bi, C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend), c46650a.yTx.getContext());
                                    break;
                                case 4:
                                    C44288am.m80031c(c7620bi, c46650a.yTx.getContext());
                                    break;
                                case 5:
                                    C44288am.m80032c(c7620bi, C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend), c46650a.yTx.getContext());
                                    break;
                                case 6:
                                    C44288am.m80030b(c7620bi, C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend), c46650a.yTx.getContext());
                                    break;
                                case 8:
                                    C44288am.m80033d(c7620bi, c46650a.yTx.getContext());
                                    break;
                            }
                        }
                        AppMethodBeat.m2505o(32837);
                        break;
                    }
                    AppMethodBeat.m2505o(32837);
                    break;
                default:
                    AppMethodBeat.m2505o(32837);
                    break;
            }
            return false;
        }

        /* JADX WARNING: Missing block: B:15:0x006b, code skipped:
            if (r2 == null) goto L_0x09fe;
     */
        /* JADX WARNING: Missing block: B:17:0x006f, code skipped:
            if (r3.url == null) goto L_0x09fe;
     */
        /* JADX WARNING: Missing block: B:19:0x007a, code skipped:
            if (r3.url.equals("") != false) goto L_0x09fe;
     */
        /* JADX WARNING: Missing block: B:21:0x0082, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r3.canvasPageXml) != false) goto L_0x06eb;
     */
        /* JADX WARNING: Missing block: B:22:0x0084, code skipped:
            r2 = new android.content.Intent();
            r2.putExtra("sns_landig_pages_from_source", 5);
            r2.putExtra("msg_id", r18.field_msgId);
            r2.putExtra("sns_landing_pages_xml", r3.canvasPageXml);
            r2.putExtra("sns_landing_pages_share_thumb_url", r18.field_imgPath);
            r2.addFlags(268435456);
            com.tencent.p177mm.p842bp.C25985d.m41467b(r17.yTx.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", r2);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(32838);
     */
        /* JADX WARNING: Missing block: B:25:0x00f3, code skipped:
            if (com.tencent.p177mm.p1510r.C35973a.m59179bJ(r17.yTx.getContext()) != false) goto L_0x0103;
     */
        /* JADX WARNING: Missing block: B:27:0x0101, code skipped:
            if (com.tencent.p177mm.p1510r.C35973a.m59177bH(r17.yTx.getContext()) == false) goto L_0x0115;
     */
        /* JADX WARNING: Missing block: B:28:0x0103, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.ChattingItemAppMsgFrom", "Voip is running, can't do this");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(32838);
     */
        /* JADX WARNING: Missing block: B:30:0x011d, code skipped:
            if (mo11015a(r17, r3, r18) == false) goto L_0x0128;
     */
        /* JADX WARNING: Missing block: B:31:0x011f, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(32838);
     */
        /* JADX WARNING: Missing block: B:32:0x0128, code skipped:
            r4 = com.tencent.p177mm.pluginsdk.model.app.C35799p.m58684B(r3.url, com.facebook.share.internal.ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            r5 = com.tencent.p177mm.pluginsdk.model.app.C35799p.m58684B(r3.fgn, com.facebook.share.internal.ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            r2 = com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.getPackageInfo(r17.yTx.getContext(), r3.appId);
     */
        /* JADX WARNING: Missing block: B:33:0x0148, code skipped:
            if (r2 != null) goto L_0x016a;
     */
        /* JADX WARNING: Missing block: B:34:0x014a, code skipped:
            r6 = null;
     */
        /* JADX WARNING: Missing block: B:35:0x014b, code skipped:
            if (r2 != null) goto L_0x016d;
     */
        /* JADX WARNING: Missing block: B:36:0x014d, code skipped:
            r7 = 0;
     */
        /* JADX WARNING: Missing block: B:37:0x014e, code skipped:
            mo11008a(r17, r4, r5, r6, r7, r3.appId, true, r18.field_msgId, r18.field_msgSvrId, r18);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(32838);
     */
        /* JADX WARNING: Missing block: B:38:0x016a, code skipped:
            r6 = r2.versionName;
     */
        /* JADX WARNING: Missing block: B:39:0x016d, code skipped:
            r7 = r2.versionCode;
     */
        /* JADX WARNING: Missing block: B:144:0x06eb, code skipped:
            r2 = (com.tencent.p177mm.plugin.websearch.api.C14420ab) r3.mo20333X(com.tencent.p177mm.plugin.websearch.api.C14420ab.class);
     */
        /* JADX WARNING: Missing block: B:145:0x06f3, code skipped:
            if (r2 == null) goto L_0x077c;
     */
        /* JADX WARNING: Missing block: B:147:0x06fb, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r2.uaa) != false) goto L_0x077c;
     */
        /* JADX WARNING: Missing block: B:148:0x06fd, code skipped:
            r3 = new com.tencent.p177mm.protocal.protobuf.cvi();
            r3.uaa = r2.uaa;
            r3.uab = r2.uab;
            r3.uac = r2.uac;
            r3.uad = r2.uad;
            r3.uae = r2.uae;
            r3.uai = r2.uai;
            r3.lvz = r2.lvz;
            r3.lvA = r2.lvA;
            r3.qVw = r2.qVw;
            r3.uaf = r2.uaf;
            r3.uag = r2.uag;
            r3.uah = r2.uah;
            r3.source = r2.source;
            r3.phw = r2.phw;
            r3.uaj = r2.uaj;
            r3.ual = r2.ual;
            r3.uam = r2.uam;
            r3.uan = r2.uan;
            r3.uak = r2.uak;
            r2 = com.tencent.p177mm.plugin.topstory.p539a.C39964g.m68429a(r3, 32, r17.yTx.getContext().getString(com.tencent.p177mm.C25738R.string.c2a));
            com.tencent.p177mm.plugin.topstory.p539a.C46297h.m86866a(r3, r18);
            com.tencent.p177mm.plugin.websearch.api.C46400aa.m87323a(r17.yTx.getContext(), r2);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(32838);
     */
        /* JADX WARNING: Missing block: B:149:0x077c, code skipped:
            r4 = r3.url;
     */
        /* JADX WARNING: Missing block: B:150:0x0782, code skipped:
            if (r17.dFx() == false) goto L_0x0989;
     */
        /* JADX WARNING: Missing block: B:151:0x0784, code skipped:
            r2 = "groupmessage";
     */
        /* JADX WARNING: Missing block: B:152:0x0787, code skipped:
            r4 = com.tencent.p177mm.pluginsdk.model.app.C35799p.m58684B(r4, r2);
            r2 = r3.url;
            r5 = com.tencent.p177mm.p612ui.chatting.viewitems.C5378c.getPackageInfo(r17.yTx.getContext(), r3.appId);
            r8 = new android.content.Intent();
            r8.putExtra("rawUrl", r4);
            r8.putExtra("webpageTitle", r3.title);
     */
        /* JADX WARNING: Missing block: B:153:0x07b0, code skipped:
            if (r3.appId == null) goto L_0x07e6;
     */
        /* JADX WARNING: Missing block: B:155:0x07bb, code skipped:
            if ("wx751a1acca5688ba3".equals(r3.appId) != false) goto L_0x07d3;
     */
        /* JADX WARNING: Missing block: B:157:0x07c6, code skipped:
            if ("wxfbc915ff7c30e335".equals(r3.appId) != false) goto L_0x07d3;
     */
        /* JADX WARNING: Missing block: B:159:0x07d1, code skipped:
            if ("wx482a4001c37e2b74".equals(r3.appId) == false) goto L_0x07e6;
     */
        /* JADX WARNING: Missing block: B:160:0x07d3, code skipped:
            r6 = new android.os.Bundle();
            r6.putString("jsapi_args_appid", r3.appId);
            r8.putExtra("jsapiargs", r6);
     */
        /* JADX WARNING: Missing block: B:162:0x07ea, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r2) != false) goto L_0x098e;
     */
        /* JADX WARNING: Missing block: B:163:0x07ec, code skipped:
            r8.putExtra("shortUrl", r2);
     */
        /* JADX WARNING: Missing block: B:164:0x07f2, code skipped:
            r6 = "version_name";
     */
        /* JADX WARNING: Missing block: B:165:0x07f5, code skipped:
            if (r5 != null) goto L_0x0998;
     */
        /* JADX WARNING: Missing block: B:166:0x07f7, code skipped:
            r2 = null;
     */
        /* JADX WARNING: Missing block: B:167:0x07f8, code skipped:
            r8.putExtra(r6, r2);
            r6 = "version_code";
     */
        /* JADX WARNING: Missing block: B:168:0x07fe, code skipped:
            if (r5 != null) goto L_0x099c;
     */
        /* JADX WARNING: Missing block: B:169:0x0800, code skipped:
            r2 = 0;
     */
        /* JADX WARNING: Missing block: B:170:0x0801, code skipped:
            r8.putExtra(r6, r2);
     */
        /* JADX WARNING: Missing block: B:171:0x080a, code skipped:
            if (com.tencent.p177mm.sdk.platformtools.C5046bo.isNullOrNil(r3.cMg) != false) goto L_0x081c;
     */
        /* JADX WARNING: Missing block: B:172:0x080c, code skipped:
            r8.putExtra("srcUsername", r3.cMg);
            r8.putExtra("srcDisplayname", r3.cMh);
     */
        /* JADX WARNING: Missing block: B:173:0x081c, code skipped:
            r8.putExtra("msg_id", r18.field_msgId);
            r8.putExtra("KPublisherId", "msg_" + java.lang.Long.toString(r18.field_msgSvrId));
            r8.putExtra("KAppId", r3.appId);
            r8.putExtra("geta8key_username", r17.getTalkerUserName());
            r8.putExtra("pre_username", mo11017b(r17, r18));
            r8.putExtra("from_scence", 2);
            r8.putExtra("expid_str", r18.dJE);
            r2 = com.tencent.p177mm.model.C32798u.m53583ad(mo11017b(r17, r18), r17.getTalkerUserName());
            r8.putExtra("prePublishId", "msg_" + java.lang.Long.toString(r18.field_msgSvrId));
            r8.putExtra("preUsername", mo11017b(r17, r18));
            r8.putExtra("preChatName", r17.getTalkerUserName());
            r8.putExtra("preChatTYPE", r2);
            r8.putExtra("preMsgIndex", 0);
     */
        /* JADX WARNING: Missing block: B:174:0x08c8, code skipped:
            switch(r2) {
                case 1: goto L_0x09a3;
                case 2: goto L_0x09a0;
                case 3: goto L_0x08cb;
                case 4: goto L_0x08cb;
                case 5: goto L_0x08cb;
                case 6: goto L_0x09a6;
                case 7: goto L_0x09a6;
                default: goto L_0x08cb;
            };
     */
        /* JADX WARNING: Missing block: B:175:0x08cb, code skipped:
            r2 = 0;
     */
        /* JADX WARNING: Missing block: B:176:0x08cc, code skipped:
            r8.putExtra("share_report_pre_msg_url", r3.url);
            r8.putExtra("share_report_pre_msg_title", r3.title);
            r8.putExtra("share_report_pre_msg_desc", r3.description);
            r8.putExtra("share_report_pre_msg_icon_url", r3.thumburl);
            r8.putExtra("share_report_pre_msg_appid", r3.appId);
            r8.putExtra("share_report_from_scene", r2);
     */
        /* JADX WARNING: Missing block: B:177:0x08fb, code skipped:
            if (r2 != 5) goto L_0x0907;
     */
        /* JADX WARNING: Missing block: B:178:0x08fd, code skipped:
            r8.putExtra("share_report_biz_username", r17.getTalkerUserName());
     */
        /* JADX WARNING: Missing block: B:179:0x0907, code skipped:
            r2 = (com.tencent.p177mm.p181af.C25747e) r3.mo20333X(com.tencent.p177mm.p181af.C25747e.class);
     */
        /* JADX WARNING: Missing block: B:180:0x090f, code skipped:
            if (r2 == null) goto L_0x09a9;
     */
        /* JADX WARNING: Missing block: B:181:0x0911, code skipped:
            r5 = r2.ffZ;
     */
        /* JADX WARNING: Missing block: B:182:0x0913, code skipped:
            r8.putExtra(com.tencent.p177mm.p612ui.C5510e.C5506m.ygo, r5);
            r8.addFlags(536870912);
            r7 = r17.yTx.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", com.tencent.tmassistantsdk.downloadservice.Downloads.MIN_WAIT_FOR_NETWORK);
     */
        /* JADX WARNING: Missing block: B:183:0x0932, code skipped:
            if (r2 == null) goto L_0x09ac;
     */
        /* JADX WARNING: Missing block: B:185:0x0935, code skipped:
            if (r5 != 5) goto L_0x09ac;
     */
        /* JADX WARNING: Missing block: B:187:0x093a, code skipped:
            if (r2.fgb != 1) goto L_0x09ac;
     */
        /* JADX WARNING: Missing block: B:189:0x0948, code skipped:
            if (((com.tencent.p177mm.plugin.brandservice.p1241a.C20023b) com.tencent.p177mm.kernel.C1720g.m3528K(com.tencent.p177mm.plugin.brandservice.p1241a.C20023b.class)).aVP() == false) goto L_0x09ac;
     */
        /* JADX WARNING: Missing block: B:190:0x094a, code skipped:
            r10 = new android.os.Bundle();
            r10.putInt("biz_video_scene", 1);
            r10.putInt("biz_video_subscene", r7);
            r10.putInt("geta8key_scene", 1);
            com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a.C11263c.m18982a(r17.yTx.getContext(), r18.field_msgId, r18.field_msgSvrId, 0, r16.findViewById(2131822444), r10);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(32838);
     */
        /* JADX WARNING: Missing block: B:191:0x0989, code skipped:
            r2 = "singlemessage";
     */
        /* JADX WARNING: Missing block: B:192:0x098e, code skipped:
            r8.putExtra("shortUrl", r3.url);
     */
        /* JADX WARNING: Missing block: B:193:0x0998, code skipped:
            r2 = r5.versionName;
     */
        /* JADX WARNING: Missing block: B:194:0x099c, code skipped:
            r2 = r5.versionCode;
     */
        /* JADX WARNING: Missing block: B:195:0x09a0, code skipped:
            r2 = 2;
     */
        /* JADX WARNING: Missing block: B:196:0x09a3, code skipped:
            r2 = 3;
     */
        /* JADX WARNING: Missing block: B:197:0x09a6, code skipped:
            r2 = 5;
     */
        /* JADX WARNING: Missing block: B:198:0x09a9, code skipped:
            r5 = -1;
     */
        /* JADX WARNING: Missing block: B:200:0x09b9, code skipped:
            if (((com.tencent.p177mm.plugin.brandservice.p1241a.C20023b) com.tencent.p177mm.kernel.C1720g.m3528K(com.tencent.p177mm.plugin.brandservice.p1241a.C20023b.class)).mo6758rW(3) == false) goto L_0x09e4;
     */
        /* JADX WARNING: Missing block: B:202:0x09d0, code skipped:
            if (((com.tencent.p177mm.plugin.brandservice.p1241a.C20023b) com.tencent.p177mm.kernel.C1720g.m3528K(com.tencent.p177mm.plugin.brandservice.p1241a.C20023b.class)).mo6750a(r17.yTx.getContext(), r4, r5, 1, r7, r8) == false) goto L_0x09e4;
     */
        /* JADX WARNING: Missing block: B:203:0x09d2, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7416i("MicroMsg.ChattingItemAppMsgFrom", "jump to TmplWebview");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(32838);
     */
        /* JADX WARNING: Missing block: B:204:0x09e4, code skipped:
            com.tencent.p177mm.p842bp.C25985d.m41467b(r17.yTx.getContext(), "webview", ".ui.tools.WebViewUI", r8);
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(32838);
     */
        /* JADX WARNING: Missing block: B:205:0x09fe, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(32838);
     */
        /* JADX WARNING: Missing block: B:208:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:209:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:210:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:211:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:231:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:232:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:233:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:234:?, code skipped:
            return true;
     */
        /* JADX WARNING: Missing block: B:235:?, code skipped:
            return false;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: b */
        public final boolean mo11019b(View view, C46650a c46650a, C7620bi c7620bi) {
            AppMethodBeat.m2504i(32838);
            C42219a.m74510a(c7620bi, C32832a.Click);
            String str = c7620bi.field_content;
            Boolean bool = Boolean.FALSE;
            if (str != null) {
                C8910b me = C8910b.m16064me(C1829bf.m3745b(c46650a.dFx(), c7620bi.field_content, c7620bi.field_isSend));
                C32222n mj = C32222n.m52572mj(str);
                if (me != null) {
                    if (mj.fju != 0) {
                        bool = Boolean.TRUE;
                        me.type = mj.fju;
                    }
                    Boolean bool2 = bool;
                    C40439f bT = C46494g.m87739bT(me.appId, false);
                    str = C5378c.m8141d(c46650a, c7620bi);
                    if (bT != null) {
                        C5378c.m8132a(c46650a, me, str, bT, c7620bi.field_msgSvrId, c46650a.getTalkerUserName());
                    }
                    Intent intent;
                    Object obj;
                    String talkerUserName;
                    Bundle bundle;
                    int i;
                    Bundle bundle2;
                    switch (me.type) {
                        case 3:
                            C7060h.pYm.mo8381e(13043, Integer.valueOf(2), me.description, me.appId);
                            break;
                        case 4:
                            break;
                        case 6:
                            if (this.kuU) {
                                intent = new Intent();
                                intent.setClassName(c46650a.yTx.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                                intent.putExtra("app_msg_id", c7620bi.field_msgId);
                                c46650a.startActivity(intent);
                                AppMethodBeat.m2505o(32838);
                                return true;
                            }
                            C23639t.m36492hO(c46650a.yTx.getContext());
                            AppMethodBeat.m2505o(32838);
                            return true;
                        case 7:
                            if (bT != null && bT.mo63847xy() && C5378c.m8137a(c46650a, bT)) {
                                AppMethodBeat.m2505o(32838);
                                return true;
                            }
                            if (me.csD == null || me.csD.length() == 0) {
                                final C40439f c40439f = bT;
                                final C46650a c46650a2 = c46650a;
                                final C8910b c8910b = me;
                                final String str2 = str;
                                final C7620bi c7620bi2 = c7620bi;
                                ((C36133b) c46650a.mo74857aF(C36133b.class)).mo57002a(c7620bi, new C14875aj() {
                                    /* renamed from: dR */
                                    public final void mo6036dR(boolean z) {
                                        AppMethodBeat.m2504i(32833);
                                        if (c40439f != null) {
                                            if (z) {
                                                C5378c.m8131a(c46650a2, c8910b, str2, c40439f, c7620bi2.field_msgSvrId, 3, c46650a2.getTalkerUserName());
                                                AppMethodBeat.m2505o(32833);
                                                return;
                                            }
                                            C5378c.m8131a(c46650a2, c8910b, str2, c40439f, c7620bi2.field_msgSvrId, 7, c46650a2.getTalkerUserName());
                                        }
                                        AppMethodBeat.m2505o(32833);
                                    }
                                });
                            } else if (this.kuU) {
                                intent = new Intent();
                                intent.setClassName(c46650a.yTx.getContext(), "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                                intent.putExtra("app_msg_id", c7620bi.field_msgId);
                                c46650a.yTx.startActivityForResult(intent, 210);
                            } else {
                                C23639t.m36492hO(c46650a.yTx.getContext());
                                AppMethodBeat.m2505o(32838);
                                return true;
                            }
                            AppMethodBeat.m2505o(32838);
                            return true;
                        case 10:
                            if (C5046bo.isNullOrNil(me.fgQ)) {
                                AppMethodBeat.m2505o(32838);
                                return false;
                            }
                            intent = new Intent();
                            intent.setFlags(65536);
                            intent.putExtra("key_Product_xml", me.fgQ);
                            intent.putExtra("key_ProductUI_getProductInfoScene", 1);
                            if (c7620bi.field_imgPath == null) {
                                intent.putExtra("key_ProductUI_chatting_msgId", c7620bi.field_msgId);
                            }
                            C25985d.m41467b(c46650a.yTx.getContext(), "scanner", ".ui.ProductUI", intent);
                            AppMethodBeat.m2505o(32838);
                            return true;
                        case 13:
                            if (C5046bo.isNullOrNil(me.fgW)) {
                                AppMethodBeat.m2505o(32838);
                                return false;
                            }
                            intent = new Intent();
                            intent.setFlags(65536);
                            intent.putExtra("key_product_info", me.fgW);
                            intent.putExtra("key_product_scene", 1);
                            C25985d.m41467b(c46650a.yTx.getContext(), "product", ".ui.MallProductUI", intent);
                            AppMethodBeat.m2505o(32838);
                            return true;
                        case 16:
                            if (C5046bo.isNullOrNil(me.cDt)) {
                                AppMethodBeat.m2505o(32838);
                                return false;
                            }
                            intent = new Intent();
                            intent.setFlags(65536);
                            intent.putExtra("key_card_app_msg", me.cDt);
                            intent.putExtra("key_from_scene", me.fhD);
                            C25985d.m41467b(c46650a.yTx.getContext(), "card", ".ui.CardDetailUI", intent);
                            AppMethodBeat.m2505o(32838);
                            return true;
                        case 19:
                            intent = new Intent();
                            intent.putExtra("message_id", c7620bi.field_msgId);
                            intent.putExtra("record_xml", me.fgU);
                            intent.putExtra("big_appmsg", bool2);
                            int ad = C32798u.m53583ad(mo11017b(c46650a, c7620bi), c46650a.getTalkerUserName());
                            intent.putExtra("prePublishId", "msg_" + Long.toString(c7620bi.field_msgSvrId));
                            intent.putExtra("preUsername", mo11017b(c46650a, c7620bi));
                            intent.putExtra("preChatName", c46650a.getTalkerUserName());
                            intent.putExtra("preChatTYPE", ad);
                            C5405a.m8208a(intent, c46650a, c7620bi, this);
                            C25985d.m41467b(c46650a.yTx.getContext(), "record", ".ui.RecordMsgDetailUI", intent);
                            AppMethodBeat.m2505o(32838);
                            return true;
                        case 20:
                            if (C5046bo.isNullOrNil(me.fgT)) {
                                AppMethodBeat.m2505o(32838);
                                return false;
                            }
                            intent = new Intent();
                            intent.setFlags(65536);
                            intent.putExtra("key_TV_xml", me.fgT);
                            intent.putExtra("key_TV_getProductInfoScene", 1);
                            if (c7620bi.field_imgPath == null) {
                                intent.putExtra("key_TVInfoUI_chatting_msgId", c7620bi.field_msgId);
                            }
                            C25985d.m41467b(c46650a.yTx.getContext(), "shake", ".ui.TVInfoUI", intent);
                            AppMethodBeat.m2505o(32838);
                            return true;
                        case 24:
                            C32599lz c32599lz = new C32599lz();
                            c32599lz.cHO.context = c46650a.yTx.getContext();
                            c32599lz.cHO.cvx = c7620bi.field_msgId;
                            c32599lz.cHO.cHc = c46650a.dFx();
                            c32599lz.cHO.cHP = me.fgU;
                            c32599lz.cHO.scene = 6;
                            C4879a.xxA.mo10055m(c32599lz);
                            AppMethodBeat.m2505o(32838);
                            return true;
                        case 33:
                        case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                            C4990ab.m7417i("MicroMsg.ChattingItemAppMsgFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", me.fiP, me.fiO, me.fiQ, me.url, Integer.valueOf(me.fiZ), me.fiS);
                            if (44 == me.type && (!me.mo20336cw(false) || C5046bo.isNullOrNil(me.mo20339p(c46650a.yTx.getContext(), false)))) {
                                obj = 1;
                                break;
                            }
                            talkerUserName = c46650a.getTalkerUserName();
                            String b = mo11017b(c46650a, c7620bi);
                            bundle = new Bundle();
                            if (c46650a.yTx instanceof AppBrandServiceChattingFmUI) {
                                str = "stat_scene";
                                i = 10;
                                bundle2 = bundle;
                            } else if (c46650a.dFx()) {
                                str = "stat_scene";
                                i = 2;
                                bundle2 = bundle;
                            } else {
                                str = "stat_scene";
                                if (C1855t.m3913mZ(talkerUserName)) {
                                    i = 7;
                                    bundle2 = bundle;
                                } else {
                                    i = 1;
                                    bundle2 = bundle;
                                }
                            }
                            bundle2.putInt(str, i);
                            bundle.putString("stat_msg_id", "msg_" + Long.toString(c7620bi.field_msgSvrId));
                            bundle.putString("stat_chat_talker_username", talkerUserName);
                            bundle.putString("stat_send_msg_user", b);
                            switch (me.fiR) {
                                case 0:
                                case 2:
                                    if (!(c46650a.yTx instanceof AppBrandServiceChattingFmUI)) {
                                        if (!C1855t.m3913mZ(talkerUserName)) {
                                            C42202a.m74442a(talkerUserName, b, c46650a.dFx(), me, bundle);
                                            obj = null;
                                            break;
                                        }
                                        C42202a.m74441a(talkerUserName, FilterEnum4Shaka.MIC_WEISHI_CHAZHI, me, bundle);
                                        obj = null;
                                        break;
                                    }
                                    C42202a.m74441a(talkerUserName, FilterEnum4Shaka.MIC_WEISHI_MENGHUANG, me, bundle);
                                    obj = null;
                                    break;
                                case 1:
                                    intent = new Intent();
                                    intent.putExtra("key_username", me.fiP);
                                    if (c46650a.dFx()) {
                                        intent.putExtra("key_from_scene", 1);
                                        intent.putExtra("key_scene_note", talkerUserName + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + b);
                                    } else {
                                        intent.putExtra("key_from_scene", 2);
                                        intent.putExtra("key_scene_note", talkerUserName);
                                    }
                                    C19154a c19154a = new C19154a();
                                    c19154a.appId = me.fiQ;
                                    c19154a.from = 6;
                                    c19154a.gVt = me.fiZ;
                                    c19154a.gVu = me.fiT;
                                    intent.putExtra("key_scene_exposed_params", c19154a.ayP());
                                    intent.putExtra("_stat_obj", bundle);
                                    C25985d.m41467b(c46650a.yTx.getContext(), "appbrand", ".ui.AppBrandProfileUI", intent);
                                    obj = null;
                                    break;
                                case 3:
                                    C42202a.m74444b(talkerUserName, b, c46650a.dFx(), me, bundle);
                                    obj = null;
                                    break;
                                default:
                                    obj = 1;
                                    break;
                            }
                            if (obj == null) {
                                AppMethodBeat.m2505o(32838);
                                return true;
                            }
                            break;
                        case 34:
                            intent = new Intent();
                            intent.putExtra("key_from_user_name", mo11017b(c46650a, c7620bi));
                            intent.putExtra("key_biz_uin", me.fhF);
                            intent.putExtra("key_order_id", me.fhG);
                            if (!(c7620bi.field_talker == null || c7620bi.field_talker.equals("") || !C1855t.m3896kH(c7620bi.field_talker))) {
                                intent.putExtra("key_chatroom_name", c7620bi.field_talker);
                            }
                            C25985d.m41467b(c46650a.yTx.getContext(), "card", ".ui.CardGiftAcceptUI", intent);
                            AppMethodBeat.m2505o(32838);
                            return true;
                        case 36:
                            if (C5046bo.isNullOrNil(me.fiQ) && C5046bo.isNullOrNil(me.fiP)) {
                                String B = C35799p.m58684B(me.url, c46650a.dFx() ? "groupmessage" : "singlemessage");
                                Intent intent2 = new Intent();
                                intent2.putExtra("rawUrl", B);
                                intent2.putExtra("webpageTitle", me.title);
                                intent2.putExtra("shortUrl", me.url);
                                C25985d.m41467b(c46650a.yTx.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                                AppMethodBeat.m2505o(32838);
                                return true;
                            }
                            String talkerUserName2 = c46650a.getTalkerUserName();
                            talkerUserName = mo11017b(c46650a, c7620bi);
                            bundle = new Bundle();
                            if (c46650a.dFx()) {
                                str = "stat_scene";
                                i = 2;
                                bundle2 = bundle;
                            } else {
                                str = "stat_scene";
                                if (C1855t.m3913mZ(talkerUserName2)) {
                                    i = 7;
                                    bundle2 = bundle;
                                } else {
                                    i = 1;
                                    bundle2 = bundle;
                                }
                            }
                            bundle2.putInt(str, i);
                            bundle.putString("stat_msg_id", "msg_" + Long.toString(c7620bi.field_msgSvrId));
                            bundle.putString("stat_chat_talker_username", talkerUserName2);
                            bundle.putString("stat_send_msg_user", talkerUserName);
                            ((C45691e) C1720g.m3528K(C45691e.class)).mo68049a(c46650a.yTx.getContext(), c46650a.getTalkerUserName(), mo11017b(c46650a, c7620bi), c46650a.dFx(), me);
                            AppMethodBeat.m2505o(32838);
                            return true;
                        default:
                            obj = 1;
                            break;
                    }
                }
                AppMethodBeat.m2505o(32838);
                return false;
            }
            AppMethodBeat.m2505o(32838);
            return false;
        }
    }

    /* renamed from: a */
    protected static void m8192a(TextView textView, C8910b c8910b) {
        AppMethodBeat.m2504i(32859);
        switch (c8910b.fiZ) {
            case 1:
                textView.setText(C25738R.string.f9057o1);
                break;
            case 2:
                textView.setText(C25738R.string.f9056o0);
                break;
            default:
                textView.setText(C25738R.string.f8887i9);
                break;
        }
        textView.setVisibility(0);
        AppMethodBeat.m2505o(32859);
    }

    /* renamed from: h */
    static boolean m8194h(C8910b c8910b) {
        AppMethodBeat.m2504i(32860);
        C14420ab c14420ab = (C14420ab) c8910b.mo20333X(C14420ab.class);
        if (c14420ab == null || C5046bo.isNullOrNil(c14420ab.uaa)) {
            AppMethodBeat.m2505o(32860);
            return false;
        }
        AppMethodBeat.m2505o(32860);
        return true;
    }
}
