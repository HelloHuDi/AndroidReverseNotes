package com.tencent.p177mm.plugin.wallet_ecard.p562b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.Exif;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.wallet.balance.p550a.p551a.C14105ad;
import com.tencent.p177mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C35503o.C35502a;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletCheckPwdUI;
import com.tencent.p177mm.plugin.wallet_core.p561ui.WalletVerifyCodeUI;
import com.tencent.p177mm.plugin.wallet_core.p749c.C14225t;
import com.tencent.p177mm.plugin.wallet_ecard.p1315a.C22672b;
import com.tencent.p177mm.plugin.wallet_ecard.p1315a.C22677c;
import com.tencent.p177mm.plugin.wallet_ecard.p1315a.C22678d;
import com.tencent.p177mm.plugin.wallet_ecard.p1315a.C35523e;
import com.tencent.p177mm.plugin.wallet_ecard.p1315a.C43818a;
import com.tencent.p177mm.plugin.wallet_ecard.p563ui.WalletECardBindCardListUI;
import com.tencent.p177mm.plugin.wallet_ecard.p563ui.WalletECardCheckOtherCardUI;
import com.tencent.p177mm.plugin.wallet_ecard.p563ui.WalletECardElementInputUI;
import com.tencent.p177mm.plugin.wallet_ecard.p563ui.WalletECardFinishUI;
import com.tencent.p177mm.plugin.wallet_ecard.p563ui.WalletOpenECardProxyUI;
import com.tencent.p177mm.plugin.wallet_ecard.p563ui.WalletOpenLqbProxyUI;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.protocal.protobuf.C30240wx;
import com.tencent.p177mm.protocal.protobuf.C35922hb;
import com.tencent.p177mm.protocal.protobuf.aur;
import com.tencent.p177mm.protocal.protobuf.bfx;
import com.tencent.p177mm.protocal.protobuf.bhd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C44432g;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b */
public class C22680b extends C40931c {

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b$c */
    class C4472c extends C44432g {

        /* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b$c$1 */
        class C44731 implements OnClickListener {
            C44731() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(48080);
                C22680b.this.mo8125b(C4472c.this.hwd, null);
                AppMethodBeat.m2505o(48080);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b$c$2 */
        class C44742 implements OnClickListener {
            C44742() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(48081);
                C22680b.this.mo8125b(C4472c.this.hwd, null);
                AppMethodBeat.m2505o(48081);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b$c$3 */
        class C44753 implements OnClickListener {
            C44753() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(48082);
                C22680b.this.mo8125b(C4472c.this.hwd, null);
                AppMethodBeat.m2505o(48082);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b$c$4 */
        class C44764 implements OnClickListener {
            C44764() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(48083);
                C22680b.this.mo8125b(C4472c.this.hwd, null);
                AppMethodBeat.m2505o(48083);
            }
        }

        public C4472c(MMActivity mMActivity, C30868i c30868i) {
            super(mMActivity, c30868i);
        }

        /* renamed from: p */
        public final boolean mo9366p(Object... objArr) {
            AppMethodBeat.m2504i(48084);
            if (((Integer) objArr[0]).intValue() == 1) {
                C4990ab.m7416i("MicroMsg.OpenECardProcess", "onNext do ecard auth");
                int intValue = ((Integer) objArr[1]).intValue();
                String str = (String) objArr[2];
                this.Agm.mo49372nf(1958);
                this.Agm.mo36581a(new C35523e(C22680b.m34380b(C22680b.this), null, intValue, str), true);
            } else {
                C4990ab.m7416i("MicroMsg.OpenECardProcess", "onNext do ecard open");
                int intValue2 = ((Integer) objArr[1]).intValue();
                this.Agm.mo49372nf(Exif.PARSE_EXIF_ERROR_CORRUPT);
                this.Agm.mo36581a(new C22678d(C22680b.m34380b(C22680b.this), C22680b.m34383e(C22680b.this), intValue2), true);
            }
            AppMethodBeat.m2505o(48084);
            return true;
        }

        /* renamed from: c */
        public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(48085);
            C1207m c1207m2;
            if (c1207m instanceof C35523e) {
                this.Agm.mo49373ng(1958);
                c1207m2 = (C35523e) c1207m;
                if (i != 0 || i2 != 0) {
                    C4990ab.m7421w("MicroMsg.OpenECardProcess", "net error: %s", c1207m2);
                    C30379h.m48448a(this.hwd, C22672b.m34359d(this.hwd, str), "", false, new C44742());
                } else if (c1207m2.tQm.kdT == 0) {
                    Bundle bundle = new Bundle();
                    C4990ab.m7417i("MicroMsg.OpenECardProcess", "req_serial: %s", c1207m2.tQm.vLa);
                    C22680b.this.mqu.putString(C43818a.tPJ, c1207m2.tQm.vLa);
                    C4990ab.m7417i("MicroMsg.OpenECardProcess", "authScene.token: %s, is_token_invalid: %s, is_reuse_existing_ecard: %s", c1207m2.token, Boolean.valueOf(c1207m2.tQm.wJI), Boolean.valueOf(c1207m2.tQm.wJJ));
                    if (!C5046bo.isNullOrNil(c1207m2.token)) {
                        bundle.putBoolean(C43818a.tPK, c1207m2.tQm.wJI);
                    }
                    if (c1207m2.tQm.wJJ) {
                        bundle.putBoolean(C43818a.tPZ, true);
                    }
                    bundle.putInt("key_ecard_proxy_action", 1);
                    C22680b.this.mo8124a(this.hwd, 0, bundle);
                } else if (!(C22672b.m34358a((WalletBaseUI) this.hwd, c1207m2.tQm.vLc) || C22672b.m34357a((WalletBaseUI) this.hwd, c1207m2, c1207m2.kCl, c1207m2.kCm, c1207m2.tQm.kdT, c1207m2.tQm.kdU))) {
                    C30379h.m48448a(this.hwd, C22672b.m34359d(this.hwd, c1207m2.tQm.kdU, c1207m2.kCm, str), "", false, new C44731());
                }
                AppMethodBeat.m2505o(48085);
                return true;
            } else if (c1207m instanceof C22678d) {
                this.Agm.mo49373ng(Exif.PARSE_EXIF_ERROR_CORRUPT);
                c1207m2 = (C22678d) c1207m;
                if (i != 0 || i2 != 0) {
                    C4990ab.m7421w("MicroMsg.OpenECardProcess", "net error: %s", c1207m2);
                    C30379h.m48448a(this.hwd, C22672b.m34359d(this.hwd, str), "", false, new C44764());
                } else if (c1207m2.tQi.kdT == 0) {
                    C22680b.this.mqu.putInt(C43818a.tPL, C43818a.tQc);
                    C22680b.this.mqu.putString(C43818a.tPO, c1207m2.tQj);
                    C22680b.this.mqu.putString(C43818a.tPP, c1207m2.tQk);
                    C22680b.this.mqu.putString(C43818a.tPQ, c1207m2.tQl);
                    Bundle bundle2 = new Bundle();
                    if (c1207m2.tQi.vLd != null) {
                        C4990ab.m7416i("MicroMsg.OpenECardProcess", "no need verify sms");
                        bundle2.putBoolean(C43818a.tPW, false);
                        try {
                            C22680b.this.mqu.putByteArray(C43818a.tQa, c1207m2.tQi.vLd.toByteArray());
                        } catch (IOException e) {
                            C4990ab.printErrStackTrace("MicroMsg.OpenECardProcess", e, "", new Object[0]);
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.OpenECardProcess", "need verfiy sms");
                        bundle2.putBoolean(C43818a.tPW, true);
                        bundle2.putString(C43818a.tPU, c1207m2.tQi.vLb);
                        bundle2.putString(C43818a.tPV, c1207m2.tQi.wJO);
                    }
                    bundle2.putInt("key_ecard_proxy_action", 2);
                    C22680b.this.mo8124a(this.hwd, 0, bundle2);
                } else if (!(C22672b.m34358a((WalletBaseUI) this.hwd, c1207m2.tQi.vLc) || C22672b.m34357a((WalletBaseUI) this.hwd, c1207m2, c1207m2.kCl, c1207m2.kCm, c1207m2.tQi.kdT, c1207m2.tQi.kdU))) {
                    C30379h.m48448a(this.hwd, C22672b.m34359d(this.hwd, c1207m2.tQi.kdU, c1207m2.kCm, str), "", false, new C44753());
                }
                AppMethodBeat.m2505o(48085);
                return true;
            } else {
                AppMethodBeat.m2505o(48085);
                return false;
            }
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(48086);
            super.onActivityResult(i, i2, intent);
            C4990ab.m7417i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
            Bundle bundle = new Bundle();
            bundle.putInt("key_process_result_code", 0);
            C22680b.this.mo8125b(this.hwd, bundle);
            AppMethodBeat.m2505o(48086);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b$d */
    class C4477d extends C44432g {
        C5653c gLj;

        /* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b$d$1 */
        class C44781 implements C35502a {
            C44781() {
            }

            /* renamed from: df */
            public final void mo9537df(View view) {
                AppMethodBeat.m2504i(48087);
                C4990ab.m7410d("MicroMsg.OpenECardProcess", "click span");
                C4477d.this.gLj.dismiss();
                if (C4477d.this.hwd instanceof WalletECardBindCardListUI) {
                    ((WalletECardBindCardListUI) C4477d.this.hwd).cST();
                }
                AppMethodBeat.m2505o(48087);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b$d$3 */
        class C44803 implements OnDismissListener {
            C44803() {
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(48089);
                C4990ab.m7416i("MicroMsg.OpenECardProcess", "dismiss alert");
                C4477d.this.gLj = null;
                AppMethodBeat.m2505o(48089);
            }
        }

        public C4477d(MMActivity mMActivity, C30868i c30868i) {
            super(mMActivity, c30868i);
        }

        /* renamed from: p */
        public final boolean mo9366p(Object... objArr) {
            AppMethodBeat.m2504i(48091);
            C35922hb c35922hb = (C35922hb) objArr[0];
            String string = C22680b.this.mqu.getString(C43818a.tPJ, "");
            if (c35922hb == null) {
                C4990ab.m7420w("MicroMsg.OpenECardProcess", "empty bank item");
                AppMethodBeat.m2505o(48091);
                return false;
            }
            this.Agm.mo49372nf(Exif.PARSE_EXIF_ERROR_CORRUPT);
            this.Agm.mo49367a(new C22678d(C22680b.m34380b(C22680b.this), string, c35922hb.vJH, c35922hb.tuk, c35922hb.pbn, C22680b.m34392m(C22680b.this), true, 1, String.format("%s %s(%s)", new Object[]{c35922hb.nuL, c35922hb.kmu, c35922hb.vJG})), true, 1);
            AppMethodBeat.m2505o(48091);
            return true;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final void mo9536a(aur aur, TextView textView) {
            AppMethodBeat.m2504i(48092);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!(aur.wyP == null || C5046bo.isNullOrNil(aur.wyP.desc))) {
                spannableStringBuilder.append(aur.wyP.desc);
                if (!C5046bo.isNullOrNil(aur.wyP.color)) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(aur.wyP.color)), 0, spannableStringBuilder.length(), 18);
                }
            }
            if (!(aur.wyQ == null || C5046bo.isNullOrNil(aur.wyQ.desc))) {
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append(aur.wyQ.desc);
                spannableStringBuilder.setSpan(new C35503o(aur.wyQ.color, new C44781()), length, spannableStringBuilder.length(), 18);
            }
            textView.setText(spannableStringBuilder);
            AppMethodBeat.m2505o(48092);
        }

        /* renamed from: c */
        public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(48093);
            if (c1207m instanceof C22678d) {
                this.Agm.mo49373ng(Exif.PARSE_EXIF_ERROR_CORRUPT);
                final C1207m c1207m2 = (C22678d) c1207m;
                if (i != 0 || i2 != 0) {
                    C4990ab.m7421w("MicroMsg.OpenECardProcess", "net error: %s", c1207m2);
                    C30379h.m48461b(this.hwd, C22672b.m34359d(this.hwd, str), "", false);
                } else if (c1207m2.tQi.kdT == 0) {
                    if (c1207m2.tQi.wJP != null) {
                        C4990ab.m7416i("MicroMsg.OpenECardProcess", "show input alert");
                        aur aur = c1207m2.tQi.wJP;
                        if (this.gLj == null) {
                            View inflate = View.inflate(this.hwd, 2130969314, null);
                            final EditText editText = (EditText) inflate.findViewById(2131823380);
                            final TextView textView = (TextView) inflate.findViewById(2131823381);
                            textView.setClickable(true);
                            textView.setOnTouchListener(new C30132m(this.hwd));
                            if (!C5046bo.isNullOrNil(aur.wyO)) {
                                editText.setHint(c1207m2.tQi.wJP.wyO);
                            }
                            C5652a c5652a = new C5652a(this.hwd);
                            c5652a.asD(c1207m2.tQi.wJP.wyN);
                            c5652a.mo11448PX(4);
                            c5652a.mo11479fn(inflate);
                            if (!C5046bo.isNullOrNil(aur.wyS)) {
                                c5652a.asJ(aur.wyS);
                            }
                            if (!C5046bo.isNullOrNil(aur.wyR)) {
                                c5652a.asK(aur.wyR);
                            }
                            c5652a.mo11462a(false, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(48088);
                                    C4990ab.m7416i("MicroMsg.OpenECardProcess", "click verify btn");
                                    String obj = editText.getText().toString();
                                    if (obj.length() == 11) {
                                        C4477d.this.Agm.mo49372nf(Exif.PARSE_EXIF_ERROR_CORRUPT);
                                        bfx bfx = (bfx) ((C7472b) c1207m2.ftl).fsG.fsP;
                                        C4477d.this.Agm.mo49367a(new C22678d(C22680b.m34380b(C22680b.this), bfx.vLa, bfx.wJK, obj, bfx.pbn, C22680b.m34392m(C22680b.this), true, 2, bfx.wJN), true, 1);
                                        AppMethodBeat.m2505o(48088);
                                        return;
                                    }
                                    aur aur = new aur();
                                    aur.wyP = new C30240wx();
                                    aur.wyP.desc = C4477d.this.hwd.getString(C25738R.string.g74);
                                    aur.wyP.color = "#FA5151";
                                    aur.wyQ = new C30240wx();
                                    aur.wyQ.desc = C4477d.this.hwd.getString(C25738R.string.g73);
                                    aur.wyQ.color = "#0C4F8E";
                                    C4477d.this.mo9536a(aur, textView);
                                    AppMethodBeat.m2505o(48088);
                                }
                            });
                            c5652a.mo11482rc(false);
                            c5652a.mo11458a(new C44803());
                            this.gLj = c5652a.aMb();
                            mo9536a(aur, textView);
                            this.gLj.show();
                        } else {
                            mo9536a(aur, (TextView) this.gLj.findViewById(2131823381));
                        }
                    } else {
                        C22680b.this.mqu.putInt(C43818a.tPL, C43818a.tQc);
                        C22680b.this.mqu.putString(C43818a.tPO, c1207m2.tQj);
                        C22680b.this.mqu.putString(C43818a.tPP, c1207m2.tQk);
                        C22680b.this.mqu.putString(C43818a.tPQ, c1207m2.tQl);
                        Bundle bundle = new Bundle();
                        if (c1207m2.tQi.vLd != null) {
                            C4990ab.m7416i("MicroMsg.OpenECardProcess", "no need verify sms");
                            bundle.putBoolean(C43818a.tPW, false);
                            try {
                                C22680b.this.mqu.putByteArray(C43818a.tQa, c1207m2.tQi.vLd.toByteArray());
                            } catch (IOException e) {
                                C4990ab.printErrStackTrace("MicroMsg.OpenECardProcess", e, "", new Object[0]);
                            }
                        } else {
                            C4990ab.m7416i("MicroMsg.OpenECardProcess", "need verfiy sms");
                            bundle.putBoolean(C43818a.tPW, true);
                            bundle.putString(C43818a.tPU, c1207m2.tQi.vLb);
                            bundle.putString(C43818a.tPV, c1207m2.tQi.wJO);
                        }
                        C22680b.this.mo8124a(this.hwd, 0, bundle);
                    }
                } else if (!(C22672b.m34358a((WalletBaseUI) this.hwd, c1207m2.tQi.vLc) || C22672b.m34357a((WalletBaseUI) this.hwd, c1207m2, c1207m2.kCl, c1207m2.kCm, c1207m2.tQi.kdT, c1207m2.tQi.kdU))) {
                    C30379h.m48461b(this.hwd, C22672b.m34359d(this.hwd, c1207m2.tQi.kdU, c1207m2.kCm, str), "", false);
                }
                AppMethodBeat.m2505o(48093);
                return true;
            }
            AppMethodBeat.m2505o(48093);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b$a */
    class C22679a extends C44432g {
        public C22679a(MMActivity mMActivity, C30868i c30868i) {
            super(mMActivity, c30868i);
        }

        /* renamed from: p */
        public final boolean mo9366p(Object... objArr) {
            AppMethodBeat.m2504i(48073);
            String str = (String) objArr[0];
            String str2 = (String) objArr[1];
            C22680b.this.mqu.putString(C43818a.tPR, str);
            C22680b.this.mqu.putString(C43818a.tPS, str2);
            this.Agm.mo36581a(new C14225t("", str, null), true);
            AppMethodBeat.m2505o(48073);
            return true;
        }

        /* renamed from: c */
        public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(48074);
            if (c1207m instanceof C14225t) {
                C14225t c14225t = (C14225t) c1207m;
                if (i == 0 && i2 == 0) {
                    Bundle bundle = new Bundle();
                    if (c14225t.tun == null || !c14225t.tun.tyC) {
                        bundle.putBoolean(C43818a.tPX, true);
                        C22680b.this.mo8124a(this.hwd, 0, bundle);
                    } else {
                        String string = C22680b.this.mqu.getString(C43818a.tPR);
                        String string2 = C22680b.this.mqu.getString(C43818a.tPS);
                        String str2 = c14225t.tun.pbn;
                        C22680b.this.mqu.putString(C43818a.tPT, str2);
                        this.Agm.mo49372nf(Exif.PARSE_EXIF_ERROR_CORRUPT);
                        this.Agm.mo36581a(new C22678d(C22680b.m34380b(C22680b.this), C22680b.m34383e(C22680b.this), string, string2, str2, C22680b.m34392m(C22680b.this), false, 0, ""), true);
                    }
                } else {
                    C4990ab.m7421w("MicroMsg.OpenECardProcess", "net error: %s", c14225t);
                    C30379h.m48461b(this.hwd, C22672b.m34359d(this.hwd, str), "", false);
                }
            } else if (c1207m instanceof C22678d) {
                this.Agm.mo49373ng(Exif.PARSE_EXIF_ERROR_CORRUPT);
                C1207m c1207m2 = (C22678d) c1207m;
                if (i != 0 || i2 != 0) {
                    C4990ab.m7421w("MicroMsg.OpenECardProcess", "net error: %s", c1207m2);
                    C30379h.m48461b(this.hwd, C22672b.m34359d(this.hwd, str), "", false);
                } else if (c1207m2.tQi.kdT == 0) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean(C43818a.tPX, false);
                    if (c1207m2.tQi.vLd == null || C5046bo.isNullOrNil(c1207m2.tQi.vLd.title)) {
                        C4990ab.m7416i("MicroMsg.OpenECardProcess", "need verfiy sms");
                        bundle2.putBoolean(C43818a.tPW, true);
                        bundle2.putString(C43818a.tPU, c1207m2.tQi.vLb);
                        bundle2.putString(C43818a.tPV, c1207m2.tQi.wJO);
                    } else {
                        C4990ab.m7416i("MicroMsg.OpenECardProcess", "no need verify sms");
                        bundle2.putBoolean(C43818a.tPW, false);
                        try {
                            C22680b.this.mqu.putByteArray(C43818a.tQa, c1207m2.tQi.vLd.toByteArray());
                        } catch (IOException e) {
                            C4990ab.printErrStackTrace("MicroMsg.OpenECardProcess", e, "", new Object[0]);
                        }
                    }
                    C22680b.this.mo8124a(this.hwd, 0, bundle2);
                } else if (!(C22672b.m34358a((WalletBaseUI) this.hwd, c1207m2.tQi.vLc) || C22672b.m34357a((WalletBaseUI) this.hwd, c1207m2, c1207m2.kCl, c1207m2.kCm, c1207m2.tQi.kdT, c1207m2.tQi.kdU))) {
                    C30379h.m48461b(this.hwd, C22672b.m34359d(this.hwd, c1207m2.tQi.kdU, c1207m2.kCm, str), "", false);
                }
                AppMethodBeat.m2505o(48074);
                return true;
            }
            AppMethodBeat.m2505o(48074);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b$b */
    class C22681b extends C44432g {

        /* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b$b$2 */
        class C44712 implements OnClickListener {
            C44712() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(48076);
                C22680b.this.mo8125b(C22681b.this.hwd, null);
                C22681b.this.hwd.finish();
                AppMethodBeat.m2505o(48076);
            }
        }

        /* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b$b$1 */
        class C143361 implements OnClickListener {
            C143361() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(48075);
                C22680b.this.mo8125b(C22681b.this.hwd, null);
                C22681b.this.hwd.finish();
                AppMethodBeat.m2505o(48075);
            }
        }

        public C22681b(MMActivity mMActivity, C30868i c30868i) {
            super(mMActivity, c30868i);
        }

        /* renamed from: p */
        public final boolean mo9366p(Object... objArr) {
            AppMethodBeat.m2504i(48077);
            String str = (String) objArr[0];
            int i = C22680b.this.mqu.getInt(C43818a.tPH);
            this.Agm.mo49372nf(1958);
            this.Agm.mo36581a(new C35523e(C22680b.m34380b(C22680b.this), str, i, null), true);
            C22680b.this.mqu.putString("key_pwd1", str);
            AppMethodBeat.m2505o(48077);
            return true;
        }

        /* renamed from: c */
        public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(48078);
            if (c1207m instanceof C35523e) {
                this.Agm.mo49373ng(1958);
                C1207m c1207m2 = (C35523e) c1207m;
                if (i != 0 || i2 != 0) {
                    C4990ab.m7421w("MicroMsg.OpenECardProcess", "net error: %s", c1207m2);
                    C30379h.m48448a(this.hwd, C22672b.m34359d(this.hwd, str), "", false, new C44712());
                } else if (c1207m2.tQm.kdT == 0) {
                    Bundle bundle = new Bundle();
                    C4990ab.m7417i("MicroMsg.OpenECardProcess", "req_serial: %s, is_reuse_existing_ecard: %s", c1207m2.tQm.vLa, Boolean.valueOf(c1207m2.tQm.wJJ));
                    C22680b.this.mqu.putString(C43818a.tPJ, c1207m2.tQm.vLa);
                    c1207m2.tQm.wJJ = false;
                    if (c1207m2.tQm.wJJ) {
                        bundle.putBoolean(C43818a.tPZ, true);
                    }
                    C22680b.this.mo8124a(this.hwd, 0, bundle);
                } else if (!(C22672b.m34358a((WalletBaseUI) this.hwd, c1207m2.tQm.vLc) || C22672b.m34357a((WalletBaseUI) this.hwd, c1207m2, c1207m2.kCl, c1207m2.kCm, c1207m2.tQm.kdT, c1207m2.tQm.kdU))) {
                    C30379h.m48448a(this.hwd, C22672b.m34359d(this.hwd, c1207m2.tQm.kdU, c1207m2.kCm, str), "", false, new C143361());
                }
                AppMethodBeat.m2505o(48078);
                return true;
            }
            AppMethodBeat.m2505o(48078);
            return false;
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(48079);
            super.onActivityResult(i, i2, intent);
            C4990ab.m7417i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
            Bundle bundle = new Bundle();
            bundle.putInt("key_process_result_code", 0);
            C22680b.this.mo8125b(this.hwd, bundle);
            AppMethodBeat.m2505o(48079);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b$e */
    class C22682e extends C44432g {
        public C22682e(MMActivity mMActivity, C30868i c30868i) {
            super(mMActivity, c30868i);
        }

        /* renamed from: p */
        public final boolean mo9366p(Object... objArr) {
            AppMethodBeat.m2504i(48094);
            String str = ((ElementQuery) objArr[0]).pbn;
            String string = C22680b.this.mqu.getString(C43818a.tPR);
            String string2 = C22680b.this.mqu.getString(C43818a.tPS);
            this.Agm.mo49372nf(Exif.PARSE_EXIF_ERROR_CORRUPT);
            this.Agm.mo36581a(new C22678d(C22680b.m34380b(C22680b.this), C22680b.m34383e(C22680b.this), string, string2, str, C22680b.m34392m(C22680b.this), false, 0, ""), true);
            AppMethodBeat.m2505o(48094);
            return true;
        }

        /* renamed from: c */
        public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(48095);
            if (c1207m instanceof C22678d) {
                this.Agm.mo49373ng(Exif.PARSE_EXIF_ERROR_CORRUPT);
                C1207m c1207m2 = (C22678d) c1207m;
                if (i != 0 || i2 != 0) {
                    C4990ab.m7421w("MicroMsg.OpenECardProcess", "net error: %s", c1207m2);
                    C30379h.m48461b(this.hwd, C22672b.m34359d(this.hwd, str), "", false);
                } else if (c1207m2.tQi.kdT == 0) {
                    Bundle bundle = new Bundle();
                    if (c1207m2.tQi.vLd != null) {
                        C4990ab.m7416i("MicroMsg.OpenECardProcess", "no need verify sms");
                        bundle.putBoolean(C43818a.tPW, false);
                        try {
                            C22680b.this.mqu.putByteArray(C43818a.tQa, c1207m2.tQi.vLd.toByteArray());
                        } catch (IOException e) {
                            C4990ab.printErrStackTrace("MicroMsg.OpenECardProcess", e, "", new Object[0]);
                        }
                    } else {
                        C4990ab.m7416i("MicroMsg.OpenECardProcess", "need verfiy sms");
                        bundle.putBoolean(C43818a.tPW, true);
                        bundle.putString(C43818a.tPU, c1207m2.tQi.vLb);
                        bundle.putString(C43818a.tPV, c1207m2.tQi.wJO);
                    }
                    C22680b.this.mo8124a(this.hwd, 0, bundle);
                } else if (!(C22672b.m34358a((WalletBaseUI) this.hwd, c1207m2.tQi.vLc) || C22672b.m34357a((WalletBaseUI) this.hwd, c1207m2, c1207m2.kCl, c1207m2.kCm, c1207m2.tQi.kdT, c1207m2.tQi.kdU))) {
                    C30379h.m48461b(this.hwd, C22672b.m34359d(this.hwd, c1207m2.tQi.kdU, c1207m2.kCm, str), "", false);
                }
                AppMethodBeat.m2505o(48095);
                return true;
            }
            AppMethodBeat.m2505o(48095);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b$g */
    class C22683g extends C44432g {
        public C22683g(MMActivity mMActivity, C30868i c30868i) {
            super(mMActivity, c30868i);
        }

        /* renamed from: Au */
        public final CharSequence mo9364Au(int i) {
            AppMethodBeat.m2504i(48098);
            String stringExtra = this.hwd.getIntent().getStringExtra(C43818a.tPV);
            AppMethodBeat.m2505o(48098);
            return stringExtra;
        }

        /* renamed from: x */
        public final boolean mo38265x(Object... objArr) {
            C1207m c22678d;
            AppMethodBeat.m2504i(48099);
            int i = C22680b.this.mqu.getInt(C43818a.tPL);
            String e = C22680b.m34383e(C22680b.this);
            C4990ab.m7417i("MicroMsg.OpenECardProcess", "bind action: %s", Integer.valueOf(i));
            if (i == C43818a.tQc) {
                c22678d = new C22678d(C22680b.m34380b(C22680b.this), e, C22680b.this.mqu.getString(C43818a.tPO), C22680b.this.mqu.getString(C43818a.tPP), C22680b.this.mqu.getString(C43818a.tPQ), C22680b.m34392m(C22680b.this), true, true, 0, "");
            } else {
                c22678d = new C22678d(C22680b.m34380b(C22680b.this), e, C22680b.this.mqu.getString(C43818a.tPR), C22680b.this.mqu.getString(C43818a.tPS), C22680b.this.mqu.getString(C43818a.tPT), C22680b.m34392m(C22680b.this), false, true, 0, "");
            }
            this.Agm.mo49372nf(Exif.PARSE_EXIF_ERROR_CORRUPT);
            this.Agm.mo36581a(c22678d, true);
            AppMethodBeat.m2505o(48099);
            return true;
        }

        /* renamed from: p */
        public final boolean mo9366p(Object... objArr) {
            AppMethodBeat.m2504i(48100);
            C22680b.this.mqu.getString("key_pwd1");
            String string = C22680b.this.mqu.getString("key_verify_code");
            String e = C22680b.m34383e(C22680b.this);
            int i = C22680b.this.mqu.getInt(C43818a.tPH);
            C22677c c22677c = new C22677c(C22680b.m34380b(C22680b.this), e, string, this.hwd.getIntent().getStringExtra(C43818a.tPU), i);
            this.Agm.mo49372nf(1986);
            this.Agm.mo49367a(c22677c, true, 3);
            AppMethodBeat.m2505o(48100);
            return true;
        }

        /* renamed from: c */
        public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(48101);
            if (c1207m instanceof C22677c) {
                this.Agm.mo49373ng(1986);
                C22677c c22677c = (C22677c) c1207m;
                if (i == 0 && i2 == 0) {
                    if (c22677c.tQh.kdT == 0) {
                        Bundle bundle = new Bundle();
                        if (c22677c.tQh.vLd != null) {
                            C4990ab.m7417i("MicroMsg.OpenECardProcess", "succ title: %s", c22677c.tQh.vLd.title);
                            try {
                                C22680b.this.mqu.putByteArray(C43818a.tQa, c22677c.tQh.vLd.toByteArray());
                            } catch (IOException e) {
                                C4990ab.printErrStackTrace("MicroMsg.OpenECardProcess", e, "", new Object[0]);
                            }
                        }
                        C22680b.this.mo8124a(this.hwd, 0, bundle);
                    } else if (!C22672b.m34358a((WalletBaseUI) this.hwd, c22677c.tQh.vLc)) {
                        C30379h.m48461b(this.hwd, C22672b.m34359d(this.hwd, c22677c.tQh.kdU, str), "", false);
                    }
                }
                AppMethodBeat.m2505o(48101);
                return true;
            } else if (c1207m instanceof C22678d) {
                this.Agm.mo49373ng(Exif.PARSE_EXIF_ERROR_CORRUPT);
                C1207m c1207m2 = (C22678d) c1207m;
                if (i != 0 || i2 != 0) {
                    C4990ab.m7421w("MicroMsg.OpenECardProcess", "net error: %s", c1207m2);
                    C30379h.m48461b(this.hwd, C22672b.m34359d(this.hwd, str), "", false);
                } else if (c1207m2.tQi.kdT == 0) {
                    this.hwd.getIntent().putExtra(C43818a.tPU, c1207m2.tQi.vLb);
                } else if (!(C22672b.m34358a((WalletBaseUI) this.hwd, c1207m2.tQi.vLc) || C22672b.m34357a((WalletBaseUI) this.hwd, c1207m2, c1207m2.kCl, c1207m2.kCm, c1207m2.tQi.kdT, c1207m2.tQi.kdU))) {
                    C30379h.m48461b(this.hwd, C22672b.m34359d(this.hwd, c1207m2.tQi.kdU, c1207m2.kCm, str), "", false);
                }
                AppMethodBeat.m2505o(48101);
                return true;
            } else {
                AppMethodBeat.m2505o(48101);
                return false;
            }
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.m2504i(48102);
            C4990ab.m7417i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
            C22680b.this.mo8125b(this.hwd, new Bundle());
            super.onActivityResult(i, i2, intent);
            AppMethodBeat.m2505o(48102);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b$f */
    class C22684f extends C44432g {
        public C22684f(MMActivity mMActivity, C30868i c30868i) {
            super(mMActivity, c30868i);
        }

        /* renamed from: p */
        public final boolean mo9366p(Object... objArr) {
            AppMethodBeat.m2504i(48096);
            ((Integer) objArr[0]).intValue();
            String str = (String) objArr[1];
            this.Agm.mo49372nf(2996);
            this.Agm.mo36581a(new C14105ad(C22680b.m34380b(C22680b.this), str), true);
            AppMethodBeat.m2505o(48096);
            return false;
        }

        /* renamed from: c */
        public final boolean mo9365c(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(48097);
            if (c1207m instanceof C14105ad) {
                C4990ab.m7417i("MicroMsg.OpenECardProcess", "openLqbAccount scene end, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
                C14105ad c14105ad = (C14105ad) c1207m;
                Bundle bundle = new Bundle();
                if (i == 0 && i2 == 0) {
                    bhd bhd = c14105ad.tgw;
                    if (bhd.kdT == 0) {
                        C22680b.this.mqu.putBoolean("key_goto_lqt_detail", true);
                        bundle.putInt("key_process_result_code", -1);
                    } else {
                        C4990ab.m7417i("MicroMsg.OpenECardProcess", "toast: %s", bhd.kdU);
                        Toast.makeText(this.hwd, bhd.kdU, 1).show();
                    }
                } else {
                    C4990ab.m7421w("MicroMsg.OpenECardProcess", "net error: %s", c1207m);
                    C30379h.m48461b(this.hwd, C22672b.m34359d(this.hwd, str), "", false);
                }
                C22680b.this.mo8125b(this.hwd, bundle);
                AppMethodBeat.m2505o(48097);
                return true;
            }
            AppMethodBeat.m2505o(48097);
            return false;
        }
    }

    /* renamed from: e */
    static /* synthetic */ String m34383e(C22680b c22680b) {
        AppMethodBeat.m2504i(48113);
        String cSS = c22680b.cSS();
        AppMethodBeat.m2505o(48113);
        return cSS;
    }

    /* renamed from: m */
    static /* synthetic */ int m34392m(C22680b c22680b) {
        AppMethodBeat.m2504i(48114);
        int bwU = c22680b.bwU();
        AppMethodBeat.m2505o(48114);
        return bwU;
    }

    /* renamed from: a */
    public final C40931c mo8123a(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48103);
        mo64571b(activity, WalletOpenECardProxyUI.class, bundle);
        C4990ab.m7417i("MicroMsg.OpenECardProcess", "start open ecard: %s", Integer.valueOf(bwU()));
        AppMethodBeat.m2505o(48103);
        return this;
    }

    /* renamed from: a */
    public final void mo8124a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.m2504i(48104);
        if (activity instanceof WalletCheckPwdUI) {
            if (bundle.getBoolean(C43818a.tPZ, false)) {
                C4990ab.m7416i("MicroMsg.OpenECardProcess", "forward, is reuse exist card");
                this.mqu.putBoolean(C43818a.tPZ, true);
                mo64571b(activity, WalletOpenECardProxyUI.class, bundle);
                activity.finish();
                AppMethodBeat.m2505o(48104);
                return;
            }
            mo64571b(activity, WalletECardBindCardListUI.class, null);
            AppMethodBeat.m2505o(48104);
        } else if (!(activity instanceof WalletECardBindCardListUI)) {
            if (!(activity instanceof WalletVerifyCodeUI)) {
                if (activity instanceof WalletECardCheckOtherCardUI) {
                    C4990ab.m7417i("MicroMsg.OpenECardProcess", "input card elem: %s, verify sms: %s", Boolean.valueOf(bundle.getBoolean(C43818a.tPX, false)), Boolean.valueOf(bundle.getBoolean(C43818a.tPW)));
                    if (bundle.getBoolean(C43818a.tPX, false)) {
                        mo64571b(activity, WalletECardElementInputUI.class, null);
                        AppMethodBeat.m2505o(48104);
                        return;
                    } else if (r1) {
                        bundle.putBoolean("key_need_confirm_finish", true);
                        mo64563a(activity, WalletVerifyCodeUI.class, null, bundle);
                        AppMethodBeat.m2505o(48104);
                        return;
                    }
                } else if (!(activity instanceof WalletECardElementInputUI)) {
                    if (activity instanceof WalletOpenECardProxyUI) {
                        boolean z = bundle.getBoolean(C43818a.tPK, false);
                        this.mqu.putBoolean(C43818a.tPK, z);
                        String string = this.mqu.getString(C43818a.tPI);
                        C4990ab.m7417i("MicroMsg.OpenECardProcess", "forward openScene: %s, token==null: %s, isTokenInvalid: %s, action: %s", Integer.valueOf(bwU()), Boolean.valueOf(C5046bo.isNullOrNil(string)), Boolean.valueOf(z), Integer.valueOf(bundle.getInt("key_ecard_proxy_action", 1)));
                        if (bundle.getInt("key_ecard_proxy_action", 1) == 1) {
                            if (C5046bo.isNullOrNil(string)) {
                                mo64562a(activity, WalletCheckPwdUI.class, bundle, 1);
                                AppMethodBeat.m2505o(48104);
                                return;
                            } else if (z) {
                                mo64571b(activity, WalletCheckPwdUI.class, bundle);
                                AppMethodBeat.m2505o(48104);
                                return;
                            } else if (r2 == 3) {
                                mo64571b(activity, WalletECardBindCardListUI.class, null);
                                AppMethodBeat.m2505o(48104);
                                return;
                            }
                        } else if (bundle.getBoolean(C43818a.tPW)) {
                            bundle.putBoolean("key_need_confirm_finish", true);
                            mo64563a(activity, WalletVerifyCodeUI.class, null, bundle);
                            AppMethodBeat.m2505o(48104);
                            return;
                        }
                    }
                    AppMethodBeat.m2505o(48104);
                } else if (bundle.getBoolean(C43818a.tPW)) {
                    bundle.putBoolean("key_need_confirm_finish", true);
                    mo64563a(activity, WalletVerifyCodeUI.class, null, bundle);
                    AppMethodBeat.m2505o(48104);
                    return;
                } else {
                    m34386g(activity, bundle);
                    AppMethodBeat.m2505o(48104);
                    return;
                }
            }
            m34386g(activity, bundle);
            AppMethodBeat.m2505o(48104);
        } else if (this.mqu.getInt(C43818a.tPL, C43818a.tQc) != C43818a.tQc) {
            mo64571b(activity, WalletECardCheckOtherCardUI.class, null);
            AppMethodBeat.m2505o(48104);
        } else if (bundle.getBoolean(C43818a.tPW)) {
            bundle.putBoolean("key_need_confirm_finish", true);
            mo64563a(activity, WalletVerifyCodeUI.class, null, bundle);
            AppMethodBeat.m2505o(48104);
        } else {
            m34386g(activity, bundle);
            AppMethodBeat.m2505o(48104);
        }
    }

    /* renamed from: g */
    private void m34386g(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48105);
        C4990ab.m7409c("MicroMsg.OpenECardProcess", "gotoFinishUI, openScene: %s", Integer.valueOf(bwU()));
        if (bwU() == 3) {
            bundle.putInt(C43818a.tPH, 3);
            bundle.putString(C43818a.tPN, this.mqu.getString(C43818a.tPN, ""));
            mo64571b(activity, WalletOpenLqbProxyUI.class, bundle);
            AppMethodBeat.m2505o(48105);
            return;
        }
        mo64571b(activity, WalletECardFinishUI.class, null);
        AppMethodBeat.m2505o(48105);
    }

    /* renamed from: c */
    public final void mo8127c(Activity activity, int i) {
        AppMethodBeat.m2504i(48106);
        if (i == 100) {
            C4990ab.m7416i("MicroMsg.OpenECardProcess", "back to card list");
            int bwU = bwU();
            String cSS = cSS();
            String str = (String) this.mqu.get("key_pwd1");
            this.mqu.clear();
            this.mqu.putInt(C43818a.tPH, bwU);
            this.mqu.putString(C43818a.tPJ, cSS);
            this.mqu.putString("key_pwd1", str);
            mo64558a(activity, WalletECardBindCardListUI.class, 0);
            AppMethodBeat.m2505o(48106);
            return;
        }
        if (activity instanceof WalletVerifyCodeUI) {
            if (this.mqu.getInt(C43818a.tPL) == C43818a.tQc) {
                mo64558a(activity, WalletECardBindCardListUI.class, 0);
                AppMethodBeat.m2505o(48106);
                return;
            }
            mo64558a(activity, WalletECardCheckOtherCardUI.class, 0);
        }
        AppMethodBeat.m2505o(48106);
    }

    /* renamed from: b */
    public final void mo8125b(Activity activity, Bundle bundle) {
        int i = 0;
        AppMethodBeat.m2504i(48107);
        C4990ab.m7417i("MicroMsg.OpenECardProcess", "end process: %s", activity);
        if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent(activity, WalletOpenECardProxyUI.class);
        intent.putExtras(bundle);
        if (bundle.containsKey("key_process_result_code")) {
            i = bundle.getInt("key_process_result_code", 0);
        }
        mo64559a(activity, WalletOpenECardProxyUI.class, i, intent, true);
        AppMethodBeat.m2505o(48107);
    }

    /* renamed from: c */
    public final boolean mo8128c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return "OpenECardProcess";
    }

    /* renamed from: h */
    public final boolean mo38264h(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(48108);
        C4990ab.m7410d("MicroMsg.OpenECardProcess", "intercept");
        bundle.putInt("key_process_result_code", 0);
        boolean h = super.mo38264h(activity, bundle);
        AppMethodBeat.m2505o(48108);
        return h;
    }

    private String cSS() {
        AppMethodBeat.m2504i(48109);
        String string = this.mqu.getString(C43818a.tPJ);
        AppMethodBeat.m2505o(48109);
        return string;
    }

    private int bwU() {
        AppMethodBeat.m2504i(48110);
        int i = this.mqu.getInt(C43818a.tPH);
        AppMethodBeat.m2505o(48110);
        return i;
    }

    /* renamed from: a */
    public final C44432g mo24745a(MMActivity mMActivity, C30868i c30868i) {
        AppMethodBeat.m2504i(48111);
        C44432g c22683g;
        if (mMActivity instanceof WalletCheckPwdUI) {
            C22681b c22681b = new C22681b(mMActivity, c30868i);
            AppMethodBeat.m2505o(48111);
            return c22681b;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            c22683g = new C22683g(mMActivity, c30868i);
            AppMethodBeat.m2505o(48111);
            return c22683g;
        } else if (mMActivity instanceof WalletECardBindCardListUI) {
            c22683g = new C4477d(mMActivity, c30868i);
            AppMethodBeat.m2505o(48111);
            return c22683g;
        } else if (mMActivity instanceof WalletECardCheckOtherCardUI) {
            c22683g = new C22679a(mMActivity, c30868i);
            AppMethodBeat.m2505o(48111);
            return c22683g;
        } else if (mMActivity instanceof WalletECardElementInputUI) {
            c22683g = new C22682e(mMActivity, c30868i);
            AppMethodBeat.m2505o(48111);
            return c22683g;
        } else if (mMActivity instanceof WalletOpenECardProxyUI) {
            c22683g = new C4472c(mMActivity, c30868i);
            AppMethodBeat.m2505o(48111);
            return c22683g;
        } else if (mMActivity instanceof WalletOpenLqbProxyUI) {
            c22683g = new C22684f(mMActivity, c30868i);
            AppMethodBeat.m2505o(48111);
            return c22683g;
        } else {
            c22683g = super.mo24745a(mMActivity, c30868i);
            AppMethodBeat.m2505o(48111);
            return c22683g;
        }
    }

    /* renamed from: b */
    static /* synthetic */ String m34380b(C22680b c22680b) {
        AppMethodBeat.m2504i(48112);
        String string = c22680b.mqu.getString(C43818a.tPM);
        if (C5046bo.isNullOrNil(string)) {
            string = "WEB_DEBIT";
        }
        AppMethodBeat.m2505o(48112);
        return string;
    }
}
