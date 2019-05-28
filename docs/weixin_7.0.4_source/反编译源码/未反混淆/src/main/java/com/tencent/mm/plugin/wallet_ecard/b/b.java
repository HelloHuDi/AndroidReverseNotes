package com.tencent.mm.plugin.wallet_ecard.b;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.wallet.balance.a.a.ad;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenECardProxyUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenLqbProxyUI;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.protocal.protobuf.bhd;
import com.tencent.mm.protocal.protobuf.hb;
import com.tencent.mm.protocal.protobuf.wx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

public class b extends com.tencent.mm.wallet_core.c {

    class c extends com.tencent.mm.wallet_core.d.g {
        public c(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        public final boolean p(Object... objArr) {
            AppMethodBeat.i(48084);
            if (((Integer) objArr[0]).intValue() == 1) {
                ab.i("MicroMsg.OpenECardProcess", "onNext do ecard auth");
                int intValue = ((Integer) objArr[1]).intValue();
                String str = (String) objArr[2];
                this.Agm.nf(1958);
                this.Agm.a(new com.tencent.mm.plugin.wallet_ecard.a.e(b.b(b.this), null, intValue, str), true);
            } else {
                ab.i("MicroMsg.OpenECardProcess", "onNext do ecard open");
                int intValue2 = ((Integer) objArr[1]).intValue();
                this.Agm.nf(Exif.PARSE_EXIF_ERROR_CORRUPT);
                this.Agm.a(new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), intValue2), true);
            }
            AppMethodBeat.o(48084);
            return true;
        }

        public final boolean c(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(48085);
            m mVar2;
            if (mVar instanceof com.tencent.mm.plugin.wallet_ecard.a.e) {
                this.Agm.ng(1958);
                mVar2 = (com.tencent.mm.plugin.wallet_ecard.a.e) mVar;
                if (i != 0 || i2 != 0) {
                    ab.w("MicroMsg.OpenECardProcess", "net error: %s", mVar2);
                    h.a(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, str), "", false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(48081);
                            b.this.b(c.this.hwd, null);
                            AppMethodBeat.o(48081);
                        }
                    });
                } else if (mVar2.tQm.kdT == 0) {
                    Bundle bundle = new Bundle();
                    ab.i("MicroMsg.OpenECardProcess", "req_serial: %s", mVar2.tQm.vLa);
                    b.this.mqu.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPJ, mVar2.tQm.vLa);
                    ab.i("MicroMsg.OpenECardProcess", "authScene.token: %s, is_token_invalid: %s, is_reuse_existing_ecard: %s", mVar2.token, Boolean.valueOf(mVar2.tQm.wJI), Boolean.valueOf(mVar2.tQm.wJJ));
                    if (!bo.isNullOrNil(mVar2.token)) {
                        bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPK, mVar2.tQm.wJI);
                    }
                    if (mVar2.tQm.wJJ) {
                        bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPZ, true);
                    }
                    bundle.putInt("key_ecard_proxy_action", 1);
                    b.this.a(this.hwd, 0, bundle);
                } else if (!(com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.hwd, mVar2.tQm.vLc) || com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.hwd, mVar2, mVar2.kCl, mVar2.kCm, mVar2.tQm.kdT, mVar2.tQm.kdU))) {
                    h.a(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, mVar2.tQm.kdU, mVar2.kCm, str), "", false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(48080);
                            b.this.b(c.this.hwd, null);
                            AppMethodBeat.o(48080);
                        }
                    });
                }
                AppMethodBeat.o(48085);
                return true;
            } else if (mVar instanceof com.tencent.mm.plugin.wallet_ecard.a.d) {
                this.Agm.ng(Exif.PARSE_EXIF_ERROR_CORRUPT);
                mVar2 = (com.tencent.mm.plugin.wallet_ecard.a.d) mVar;
                if (i != 0 || i2 != 0) {
                    ab.w("MicroMsg.OpenECardProcess", "net error: %s", mVar2);
                    h.a(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, str), "", false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(48083);
                            b.this.b(c.this.hwd, null);
                            AppMethodBeat.o(48083);
                        }
                    });
                } else if (mVar2.tQi.kdT == 0) {
                    b.this.mqu.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.tPL, com.tencent.mm.plugin.wallet_ecard.a.a.tQc);
                    b.this.mqu.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPO, mVar2.tQj);
                    b.this.mqu.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPP, mVar2.tQk);
                    b.this.mqu.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPQ, mVar2.tQl);
                    Bundle bundle2 = new Bundle();
                    if (mVar2.tQi.vLd != null) {
                        ab.i("MicroMsg.OpenECardProcess", "no need verify sms");
                        bundle2.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPW, false);
                        try {
                            b.this.mqu.putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.tQa, mVar2.tQi.vLd.toByteArray());
                        } catch (IOException e) {
                            ab.printErrStackTrace("MicroMsg.OpenECardProcess", e, "", new Object[0]);
                        }
                    } else {
                        ab.i("MicroMsg.OpenECardProcess", "need verfiy sms");
                        bundle2.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPW, true);
                        bundle2.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPU, mVar2.tQi.vLb);
                        bundle2.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPV, mVar2.tQi.wJO);
                    }
                    bundle2.putInt("key_ecard_proxy_action", 2);
                    b.this.a(this.hwd, 0, bundle2);
                } else if (!(com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.hwd, mVar2.tQi.vLc) || com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.hwd, mVar2, mVar2.kCl, mVar2.kCm, mVar2.tQi.kdT, mVar2.tQi.kdU))) {
                    h.a(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, mVar2.tQi.kdU, mVar2.kCm, str), "", false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(48082);
                            b.this.b(c.this.hwd, null);
                            AppMethodBeat.o(48082);
                        }
                    });
                }
                AppMethodBeat.o(48085);
                return true;
            } else {
                AppMethodBeat.o(48085);
                return false;
            }
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.i(48086);
            super.onActivityResult(i, i2, intent);
            ab.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
            Bundle bundle = new Bundle();
            bundle.putInt("key_process_result_code", 0);
            b.this.b(this.hwd, bundle);
            AppMethodBeat.o(48086);
        }
    }

    class d extends com.tencent.mm.wallet_core.d.g {
        com.tencent.mm.ui.widget.a.c gLj;

        public d(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        public final boolean p(Object... objArr) {
            AppMethodBeat.i(48091);
            hb hbVar = (hb) objArr[0];
            String string = b.this.mqu.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPJ, "");
            if (hbVar == null) {
                ab.w("MicroMsg.OpenECardProcess", "empty bank item");
                AppMethodBeat.o(48091);
                return false;
            }
            this.Agm.nf(Exif.PARSE_EXIF_ERROR_CORRUPT);
            this.Agm.a(new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), string, hbVar.vJH, hbVar.tuk, hbVar.pbn, b.m(b.this), true, 1, String.format("%s %s(%s)", new Object[]{hbVar.nuL, hbVar.kmu, hbVar.vJG})), true, 1);
            AppMethodBeat.o(48091);
            return true;
        }

        /* Access modifiers changed, original: final */
        public final void a(aur aur, TextView textView) {
            AppMethodBeat.i(48092);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (!(aur.wyP == null || bo.isNullOrNil(aur.wyP.desc))) {
                spannableStringBuilder.append(aur.wyP.desc);
                if (!bo.isNullOrNil(aur.wyP.color)) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(aur.wyP.color)), 0, spannableStringBuilder.length(), 18);
                }
            }
            if (!(aur.wyQ == null || bo.isNullOrNil(aur.wyQ.desc))) {
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append(aur.wyQ.desc);
                spannableStringBuilder.setSpan(new o(aur.wyQ.color, new com.tencent.mm.plugin.wallet_core.ui.o.a() {
                    public final void df(View view) {
                        AppMethodBeat.i(48087);
                        ab.d("MicroMsg.OpenECardProcess", "click span");
                        d.this.gLj.dismiss();
                        if (d.this.hwd instanceof WalletECardBindCardListUI) {
                            ((WalletECardBindCardListUI) d.this.hwd).cST();
                        }
                        AppMethodBeat.o(48087);
                    }
                }), length, spannableStringBuilder.length(), 18);
            }
            textView.setText(spannableStringBuilder);
            AppMethodBeat.o(48092);
        }

        public final boolean c(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(48093);
            if (mVar instanceof com.tencent.mm.plugin.wallet_ecard.a.d) {
                this.Agm.ng(Exif.PARSE_EXIF_ERROR_CORRUPT);
                final m mVar2 = (com.tencent.mm.plugin.wallet_ecard.a.d) mVar;
                if (i != 0 || i2 != 0) {
                    ab.w("MicroMsg.OpenECardProcess", "net error: %s", mVar2);
                    h.b(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, str), "", false);
                } else if (mVar2.tQi.kdT == 0) {
                    if (mVar2.tQi.wJP != null) {
                        ab.i("MicroMsg.OpenECardProcess", "show input alert");
                        aur aur = mVar2.tQi.wJP;
                        if (this.gLj == null) {
                            View inflate = View.inflate(this.hwd, R.layout.t7, null);
                            final EditText editText = (EditText) inflate.findViewById(R.id.bbn);
                            final TextView textView = (TextView) inflate.findViewById(R.id.bbo);
                            textView.setClickable(true);
                            textView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.e.m(this.hwd));
                            if (!bo.isNullOrNil(aur.wyO)) {
                                editText.setHint(mVar2.tQi.wJP.wyO);
                            }
                            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this.hwd);
                            aVar.asD(mVar2.tQi.wJP.wyN);
                            aVar.PX(4);
                            aVar.fn(inflate);
                            if (!bo.isNullOrNil(aur.wyS)) {
                                aVar.asJ(aur.wyS);
                            }
                            if (!bo.isNullOrNil(aur.wyR)) {
                                aVar.asK(aur.wyR);
                            }
                            aVar.a(false, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(48088);
                                    ab.i("MicroMsg.OpenECardProcess", "click verify btn");
                                    String obj = editText.getText().toString();
                                    if (obj.length() == 11) {
                                        d.this.Agm.nf(Exif.PARSE_EXIF_ERROR_CORRUPT);
                                        bfx bfx = (bfx) ((com.tencent.mm.ai.b) mVar2.ftl).fsG.fsP;
                                        d.this.Agm.a(new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), bfx.vLa, bfx.wJK, obj, bfx.pbn, b.m(b.this), true, 2, bfx.wJN), true, 1);
                                        AppMethodBeat.o(48088);
                                        return;
                                    }
                                    aur aur = new aur();
                                    aur.wyP = new wx();
                                    aur.wyP.desc = d.this.hwd.getString(R.string.g74);
                                    aur.wyP.color = "#FA5151";
                                    aur.wyQ = new wx();
                                    aur.wyQ.desc = d.this.hwd.getString(R.string.g73);
                                    aur.wyQ.color = "#0C4F8E";
                                    d.this.a(aur, textView);
                                    AppMethodBeat.o(48088);
                                }
                            });
                            aVar.rc(false);
                            aVar.a(new OnDismissListener() {
                                public final void onDismiss(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(48089);
                                    ab.i("MicroMsg.OpenECardProcess", "dismiss alert");
                                    d.this.gLj = null;
                                    AppMethodBeat.o(48089);
                                }
                            });
                            this.gLj = aVar.aMb();
                            a(aur, textView);
                            this.gLj.show();
                        } else {
                            a(aur, (TextView) this.gLj.findViewById(R.id.bbo));
                        }
                    } else {
                        b.this.mqu.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.tPL, com.tencent.mm.plugin.wallet_ecard.a.a.tQc);
                        b.this.mqu.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPO, mVar2.tQj);
                        b.this.mqu.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPP, mVar2.tQk);
                        b.this.mqu.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPQ, mVar2.tQl);
                        Bundle bundle = new Bundle();
                        if (mVar2.tQi.vLd != null) {
                            ab.i("MicroMsg.OpenECardProcess", "no need verify sms");
                            bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPW, false);
                            try {
                                b.this.mqu.putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.tQa, mVar2.tQi.vLd.toByteArray());
                            } catch (IOException e) {
                                ab.printErrStackTrace("MicroMsg.OpenECardProcess", e, "", new Object[0]);
                            }
                        } else {
                            ab.i("MicroMsg.OpenECardProcess", "need verfiy sms");
                            bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPW, true);
                            bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPU, mVar2.tQi.vLb);
                            bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPV, mVar2.tQi.wJO);
                        }
                        b.this.a(this.hwd, 0, bundle);
                    }
                } else if (!(com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.hwd, mVar2.tQi.vLc) || com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.hwd, mVar2, mVar2.kCl, mVar2.kCm, mVar2.tQi.kdT, mVar2.tQi.kdU))) {
                    h.b(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, mVar2.tQi.kdU, mVar2.kCm, str), "", false);
                }
                AppMethodBeat.o(48093);
                return true;
            }
            AppMethodBeat.o(48093);
            return false;
        }
    }

    class a extends com.tencent.mm.wallet_core.d.g {
        public a(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        public final boolean p(Object... objArr) {
            AppMethodBeat.i(48073);
            String str = (String) objArr[0];
            String str2 = (String) objArr[1];
            b.this.mqu.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPR, str);
            b.this.mqu.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPS, str2);
            this.Agm.a(new t("", str, null), true);
            AppMethodBeat.o(48073);
            return true;
        }

        public final boolean c(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(48074);
            if (mVar instanceof t) {
                t tVar = (t) mVar;
                if (i == 0 && i2 == 0) {
                    Bundle bundle = new Bundle();
                    if (tVar.tun == null || !tVar.tun.tyC) {
                        bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPX, true);
                        b.this.a(this.hwd, 0, bundle);
                    } else {
                        String string = b.this.mqu.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPR);
                        String string2 = b.this.mqu.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPS);
                        String str2 = tVar.tun.pbn;
                        b.this.mqu.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPT, str2);
                        this.Agm.nf(Exif.PARSE_EXIF_ERROR_CORRUPT);
                        this.Agm.a(new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), string, string2, str2, b.m(b.this), false, 0, ""), true);
                    }
                } else {
                    ab.w("MicroMsg.OpenECardProcess", "net error: %s", tVar);
                    h.b(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, str), "", false);
                }
            } else if (mVar instanceof com.tencent.mm.plugin.wallet_ecard.a.d) {
                this.Agm.ng(Exif.PARSE_EXIF_ERROR_CORRUPT);
                m mVar2 = (com.tencent.mm.plugin.wallet_ecard.a.d) mVar;
                if (i != 0 || i2 != 0) {
                    ab.w("MicroMsg.OpenECardProcess", "net error: %s", mVar2);
                    h.b(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, str), "", false);
                } else if (mVar2.tQi.kdT == 0) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPX, false);
                    if (mVar2.tQi.vLd == null || bo.isNullOrNil(mVar2.tQi.vLd.title)) {
                        ab.i("MicroMsg.OpenECardProcess", "need verfiy sms");
                        bundle2.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPW, true);
                        bundle2.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPU, mVar2.tQi.vLb);
                        bundle2.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPV, mVar2.tQi.wJO);
                    } else {
                        ab.i("MicroMsg.OpenECardProcess", "no need verify sms");
                        bundle2.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPW, false);
                        try {
                            b.this.mqu.putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.tQa, mVar2.tQi.vLd.toByteArray());
                        } catch (IOException e) {
                            ab.printErrStackTrace("MicroMsg.OpenECardProcess", e, "", new Object[0]);
                        }
                    }
                    b.this.a(this.hwd, 0, bundle2);
                } else if (!(com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.hwd, mVar2.tQi.vLc) || com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.hwd, mVar2, mVar2.kCl, mVar2.kCm, mVar2.tQi.kdT, mVar2.tQi.kdU))) {
                    h.b(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, mVar2.tQi.kdU, mVar2.kCm, str), "", false);
                }
                AppMethodBeat.o(48074);
                return true;
            }
            AppMethodBeat.o(48074);
            return false;
        }
    }

    class b extends com.tencent.mm.wallet_core.d.g {
        public b(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        public final boolean p(Object... objArr) {
            AppMethodBeat.i(48077);
            String str = (String) objArr[0];
            int i = b.this.mqu.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.tPH);
            this.Agm.nf(1958);
            this.Agm.a(new com.tencent.mm.plugin.wallet_ecard.a.e(b.b(b.this), str, i, null), true);
            b.this.mqu.putString("key_pwd1", str);
            AppMethodBeat.o(48077);
            return true;
        }

        public final boolean c(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(48078);
            if (mVar instanceof com.tencent.mm.plugin.wallet_ecard.a.e) {
                this.Agm.ng(1958);
                m mVar2 = (com.tencent.mm.plugin.wallet_ecard.a.e) mVar;
                if (i != 0 || i2 != 0) {
                    ab.w("MicroMsg.OpenECardProcess", "net error: %s", mVar2);
                    h.a(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, str), "", false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(48076);
                            b.this.b(b.this.hwd, null);
                            b.this.hwd.finish();
                            AppMethodBeat.o(48076);
                        }
                    });
                } else if (mVar2.tQm.kdT == 0) {
                    Bundle bundle = new Bundle();
                    ab.i("MicroMsg.OpenECardProcess", "req_serial: %s, is_reuse_existing_ecard: %s", mVar2.tQm.vLa, Boolean.valueOf(mVar2.tQm.wJJ));
                    b.this.mqu.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPJ, mVar2.tQm.vLa);
                    mVar2.tQm.wJJ = false;
                    if (mVar2.tQm.wJJ) {
                        bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPZ, true);
                    }
                    b.this.a(this.hwd, 0, bundle);
                } else if (!(com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.hwd, mVar2.tQm.vLc) || com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.hwd, mVar2, mVar2.kCl, mVar2.kCm, mVar2.tQm.kdT, mVar2.tQm.kdU))) {
                    h.a(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, mVar2.tQm.kdU, mVar2.kCm, str), "", false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(48075);
                            b.this.b(b.this.hwd, null);
                            b.this.hwd.finish();
                            AppMethodBeat.o(48075);
                        }
                    });
                }
                AppMethodBeat.o(48078);
                return true;
            }
            AppMethodBeat.o(48078);
            return false;
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.i(48079);
            super.onActivityResult(i, i2, intent);
            ab.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
            Bundle bundle = new Bundle();
            bundle.putInt("key_process_result_code", 0);
            b.this.b(this.hwd, bundle);
            AppMethodBeat.o(48079);
        }
    }

    class e extends com.tencent.mm.wallet_core.d.g {
        public e(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        public final boolean p(Object... objArr) {
            AppMethodBeat.i(48094);
            String str = ((ElementQuery) objArr[0]).pbn;
            String string = b.this.mqu.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPR);
            String string2 = b.this.mqu.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPS);
            this.Agm.nf(Exif.PARSE_EXIF_ERROR_CORRUPT);
            this.Agm.a(new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), string, string2, str, b.m(b.this), false, 0, ""), true);
            AppMethodBeat.o(48094);
            return true;
        }

        public final boolean c(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(48095);
            if (mVar instanceof com.tencent.mm.plugin.wallet_ecard.a.d) {
                this.Agm.ng(Exif.PARSE_EXIF_ERROR_CORRUPT);
                m mVar2 = (com.tencent.mm.plugin.wallet_ecard.a.d) mVar;
                if (i != 0 || i2 != 0) {
                    ab.w("MicroMsg.OpenECardProcess", "net error: %s", mVar2);
                    h.b(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, str), "", false);
                } else if (mVar2.tQi.kdT == 0) {
                    Bundle bundle = new Bundle();
                    if (mVar2.tQi.vLd != null) {
                        ab.i("MicroMsg.OpenECardProcess", "no need verify sms");
                        bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPW, false);
                        try {
                            b.this.mqu.putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.tQa, mVar2.tQi.vLd.toByteArray());
                        } catch (IOException e) {
                            ab.printErrStackTrace("MicroMsg.OpenECardProcess", e, "", new Object[0]);
                        }
                    } else {
                        ab.i("MicroMsg.OpenECardProcess", "need verfiy sms");
                        bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPW, true);
                        bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPU, mVar2.tQi.vLb);
                        bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPV, mVar2.tQi.wJO);
                    }
                    b.this.a(this.hwd, 0, bundle);
                } else if (!(com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.hwd, mVar2.tQi.vLc) || com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.hwd, mVar2, mVar2.kCl, mVar2.kCm, mVar2.tQi.kdT, mVar2.tQi.kdU))) {
                    h.b(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, mVar2.tQi.kdU, mVar2.kCm, str), "", false);
                }
                AppMethodBeat.o(48095);
                return true;
            }
            AppMethodBeat.o(48095);
            return false;
        }
    }

    class g extends com.tencent.mm.wallet_core.d.g {
        public g(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        public final CharSequence Au(int i) {
            AppMethodBeat.i(48098);
            String stringExtra = this.hwd.getIntent().getStringExtra(com.tencent.mm.plugin.wallet_ecard.a.a.tPV);
            AppMethodBeat.o(48098);
            return stringExtra;
        }

        public final boolean x(Object... objArr) {
            m dVar;
            AppMethodBeat.i(48099);
            int i = b.this.mqu.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.tPL);
            String e = b.e(b.this);
            ab.i("MicroMsg.OpenECardProcess", "bind action: %s", Integer.valueOf(i));
            if (i == com.tencent.mm.plugin.wallet_ecard.a.a.tQc) {
                dVar = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), e, b.this.mqu.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPO), b.this.mqu.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPP), b.this.mqu.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPQ), b.m(b.this), true, true, 0, "");
            } else {
                dVar = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), e, b.this.mqu.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPR), b.this.mqu.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPS), b.this.mqu.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPT), b.m(b.this), false, true, 0, "");
            }
            this.Agm.nf(Exif.PARSE_EXIF_ERROR_CORRUPT);
            this.Agm.a(dVar, true);
            AppMethodBeat.o(48099);
            return true;
        }

        public final boolean p(Object... objArr) {
            AppMethodBeat.i(48100);
            b.this.mqu.getString("key_pwd1");
            String string = b.this.mqu.getString("key_verify_code");
            String e = b.e(b.this);
            int i = b.this.mqu.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.tPH);
            com.tencent.mm.plugin.wallet_ecard.a.c cVar = new com.tencent.mm.plugin.wallet_ecard.a.c(b.b(b.this), e, string, this.hwd.getIntent().getStringExtra(com.tencent.mm.plugin.wallet_ecard.a.a.tPU), i);
            this.Agm.nf(1986);
            this.Agm.a(cVar, true, 3);
            AppMethodBeat.o(48100);
            return true;
        }

        public final boolean c(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(48101);
            if (mVar instanceof com.tencent.mm.plugin.wallet_ecard.a.c) {
                this.Agm.ng(1986);
                com.tencent.mm.plugin.wallet_ecard.a.c cVar = (com.tencent.mm.plugin.wallet_ecard.a.c) mVar;
                if (i == 0 && i2 == 0) {
                    if (cVar.tQh.kdT == 0) {
                        Bundle bundle = new Bundle();
                        if (cVar.tQh.vLd != null) {
                            ab.i("MicroMsg.OpenECardProcess", "succ title: %s", cVar.tQh.vLd.title);
                            try {
                                b.this.mqu.putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.tQa, cVar.tQh.vLd.toByteArray());
                            } catch (IOException e) {
                                ab.printErrStackTrace("MicroMsg.OpenECardProcess", e, "", new Object[0]);
                            }
                        }
                        b.this.a(this.hwd, 0, bundle);
                    } else if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.hwd, cVar.tQh.vLc)) {
                        h.b(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, cVar.tQh.kdU, str), "", false);
                    }
                }
                AppMethodBeat.o(48101);
                return true;
            } else if (mVar instanceof com.tencent.mm.plugin.wallet_ecard.a.d) {
                this.Agm.ng(Exif.PARSE_EXIF_ERROR_CORRUPT);
                m mVar2 = (com.tencent.mm.plugin.wallet_ecard.a.d) mVar;
                if (i != 0 || i2 != 0) {
                    ab.w("MicroMsg.OpenECardProcess", "net error: %s", mVar2);
                    h.b(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, str), "", false);
                } else if (mVar2.tQi.kdT == 0) {
                    this.hwd.getIntent().putExtra(com.tencent.mm.plugin.wallet_ecard.a.a.tPU, mVar2.tQi.vLb);
                } else if (!(com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.hwd, mVar2.tQi.vLc) || com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.hwd, mVar2, mVar2.kCl, mVar2.kCm, mVar2.tQi.kdT, mVar2.tQi.kdU))) {
                    h.b(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, mVar2.tQi.kdU, mVar2.kCm, str), "", false);
                }
                AppMethodBeat.o(48101);
                return true;
            } else {
                AppMethodBeat.o(48101);
                return false;
            }
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            AppMethodBeat.i(48102);
            ab.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
            b.this.b(this.hwd, new Bundle());
            super.onActivityResult(i, i2, intent);
            AppMethodBeat.o(48102);
        }
    }

    class f extends com.tencent.mm.wallet_core.d.g {
        public f(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        public final boolean p(Object... objArr) {
            AppMethodBeat.i(48096);
            ((Integer) objArr[0]).intValue();
            String str = (String) objArr[1];
            this.Agm.nf(2996);
            this.Agm.a(new ad(b.b(b.this), str), true);
            AppMethodBeat.o(48096);
            return false;
        }

        public final boolean c(int i, int i2, String str, m mVar) {
            AppMethodBeat.i(48097);
            if (mVar instanceof ad) {
                ab.i("MicroMsg.OpenECardProcess", "openLqbAccount scene end, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
                ad adVar = (ad) mVar;
                Bundle bundle = new Bundle();
                if (i == 0 && i2 == 0) {
                    bhd bhd = adVar.tgw;
                    if (bhd.kdT == 0) {
                        b.this.mqu.putBoolean("key_goto_lqt_detail", true);
                        bundle.putInt("key_process_result_code", -1);
                    } else {
                        ab.i("MicroMsg.OpenECardProcess", "toast: %s", bhd.kdU);
                        Toast.makeText(this.hwd, bhd.kdU, 1).show();
                    }
                } else {
                    ab.w("MicroMsg.OpenECardProcess", "net error: %s", mVar);
                    h.b(this.hwd, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.hwd, str), "", false);
                }
                b.this.b(this.hwd, bundle);
                AppMethodBeat.o(48097);
                return true;
            }
            AppMethodBeat.o(48097);
            return false;
        }
    }

    static /* synthetic */ String e(b bVar) {
        AppMethodBeat.i(48113);
        String cSS = bVar.cSS();
        AppMethodBeat.o(48113);
        return cSS;
    }

    static /* synthetic */ int m(b bVar) {
        AppMethodBeat.i(48114);
        int bwU = bVar.bwU();
        AppMethodBeat.o(48114);
        return bwU;
    }

    public final com.tencent.mm.wallet_core.c a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48103);
        b(activity, WalletOpenECardProxyUI.class, bundle);
        ab.i("MicroMsg.OpenECardProcess", "start open ecard: %s", Integer.valueOf(bwU()));
        AppMethodBeat.o(48103);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        AppMethodBeat.i(48104);
        if (activity instanceof WalletCheckPwdUI) {
            if (bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPZ, false)) {
                ab.i("MicroMsg.OpenECardProcess", "forward, is reuse exist card");
                this.mqu.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPZ, true);
                b(activity, WalletOpenECardProxyUI.class, bundle);
                activity.finish();
                AppMethodBeat.o(48104);
                return;
            }
            b(activity, WalletECardBindCardListUI.class, null);
            AppMethodBeat.o(48104);
        } else if (!(activity instanceof WalletECardBindCardListUI)) {
            if (!(activity instanceof WalletVerifyCodeUI)) {
                if (activity instanceof WalletECardCheckOtherCardUI) {
                    ab.i("MicroMsg.OpenECardProcess", "input card elem: %s, verify sms: %s", Boolean.valueOf(bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPX, false)), Boolean.valueOf(bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPW)));
                    if (bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPX, false)) {
                        b(activity, WalletECardElementInputUI.class, null);
                        AppMethodBeat.o(48104);
                        return;
                    } else if (r1) {
                        bundle.putBoolean("key_need_confirm_finish", true);
                        a(activity, WalletVerifyCodeUI.class, null, bundle);
                        AppMethodBeat.o(48104);
                        return;
                    }
                } else if (!(activity instanceof WalletECardElementInputUI)) {
                    if (activity instanceof WalletOpenECardProxyUI) {
                        boolean z = bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPK, false);
                        this.mqu.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPK, z);
                        String string = this.mqu.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPI);
                        ab.i("MicroMsg.OpenECardProcess", "forward openScene: %s, token==null: %s, isTokenInvalid: %s, action: %s", Integer.valueOf(bwU()), Boolean.valueOf(bo.isNullOrNil(string)), Boolean.valueOf(z), Integer.valueOf(bundle.getInt("key_ecard_proxy_action", 1)));
                        if (bundle.getInt("key_ecard_proxy_action", 1) == 1) {
                            if (bo.isNullOrNil(string)) {
                                a(activity, WalletCheckPwdUI.class, bundle, 1);
                                AppMethodBeat.o(48104);
                                return;
                            } else if (z) {
                                b(activity, WalletCheckPwdUI.class, bundle);
                                AppMethodBeat.o(48104);
                                return;
                            } else if (r2 == 3) {
                                b(activity, WalletECardBindCardListUI.class, null);
                                AppMethodBeat.o(48104);
                                return;
                            }
                        } else if (bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPW)) {
                            bundle.putBoolean("key_need_confirm_finish", true);
                            a(activity, WalletVerifyCodeUI.class, null, bundle);
                            AppMethodBeat.o(48104);
                            return;
                        }
                    }
                    AppMethodBeat.o(48104);
                } else if (bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPW)) {
                    bundle.putBoolean("key_need_confirm_finish", true);
                    a(activity, WalletVerifyCodeUI.class, null, bundle);
                    AppMethodBeat.o(48104);
                    return;
                } else {
                    g(activity, bundle);
                    AppMethodBeat.o(48104);
                    return;
                }
            }
            g(activity, bundle);
            AppMethodBeat.o(48104);
        } else if (this.mqu.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.tPL, com.tencent.mm.plugin.wallet_ecard.a.a.tQc) != com.tencent.mm.plugin.wallet_ecard.a.a.tQc) {
            b(activity, WalletECardCheckOtherCardUI.class, null);
            AppMethodBeat.o(48104);
        } else if (bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.tPW)) {
            bundle.putBoolean("key_need_confirm_finish", true);
            a(activity, WalletVerifyCodeUI.class, null, bundle);
            AppMethodBeat.o(48104);
        } else {
            g(activity, bundle);
            AppMethodBeat.o(48104);
        }
    }

    private void g(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48105);
        ab.c("MicroMsg.OpenECardProcess", "gotoFinishUI, openScene: %s", Integer.valueOf(bwU()));
        if (bwU() == 3) {
            bundle.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.tPH, 3);
            bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPN, this.mqu.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPN, ""));
            b(activity, WalletOpenLqbProxyUI.class, bundle);
            AppMethodBeat.o(48105);
            return;
        }
        b(activity, WalletECardFinishUI.class, null);
        AppMethodBeat.o(48105);
    }

    public final void c(Activity activity, int i) {
        AppMethodBeat.i(48106);
        if (i == 100) {
            ab.i("MicroMsg.OpenECardProcess", "back to card list");
            int bwU = bwU();
            String cSS = cSS();
            String str = (String) this.mqu.get("key_pwd1");
            this.mqu.clear();
            this.mqu.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.tPH, bwU);
            this.mqu.putString(com.tencent.mm.plugin.wallet_ecard.a.a.tPJ, cSS);
            this.mqu.putString("key_pwd1", str);
            a(activity, WalletECardBindCardListUI.class, 0);
            AppMethodBeat.o(48106);
            return;
        }
        if (activity instanceof WalletVerifyCodeUI) {
            if (this.mqu.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.tPL) == com.tencent.mm.plugin.wallet_ecard.a.a.tQc) {
                a(activity, WalletECardBindCardListUI.class, 0);
                AppMethodBeat.o(48106);
                return;
            }
            a(activity, WalletECardCheckOtherCardUI.class, 0);
        }
        AppMethodBeat.o(48106);
    }

    public final void b(Activity activity, Bundle bundle) {
        int i = 0;
        AppMethodBeat.i(48107);
        ab.i("MicroMsg.OpenECardProcess", "end process: %s", activity);
        if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent(activity, WalletOpenECardProxyUI.class);
        intent.putExtras(bundle);
        if (bundle.containsKey("key_process_result_code")) {
            i = bundle.getInt("key_process_result_code", 0);
        }
        a(activity, WalletOpenECardProxyUI.class, i, intent, true);
        AppMethodBeat.o(48107);
    }

    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    public final String bxP() {
        return "OpenECardProcess";
    }

    public final boolean h(Activity activity, Bundle bundle) {
        AppMethodBeat.i(48108);
        ab.d("MicroMsg.OpenECardProcess", "intercept");
        bundle.putInt("key_process_result_code", 0);
        boolean h = super.h(activity, bundle);
        AppMethodBeat.o(48108);
        return h;
    }

    private String cSS() {
        AppMethodBeat.i(48109);
        String string = this.mqu.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPJ);
        AppMethodBeat.o(48109);
        return string;
    }

    private int bwU() {
        AppMethodBeat.i(48110);
        int i = this.mqu.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.tPH);
        AppMethodBeat.o(48110);
        return i;
    }

    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(48111);
        com.tencent.mm.wallet_core.d.g gVar;
        if (mMActivity instanceof WalletCheckPwdUI) {
            b bVar = new b(mMActivity, iVar);
            AppMethodBeat.o(48111);
            return bVar;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            gVar = new g(mMActivity, iVar);
            AppMethodBeat.o(48111);
            return gVar;
        } else if (mMActivity instanceof WalletECardBindCardListUI) {
            gVar = new d(mMActivity, iVar);
            AppMethodBeat.o(48111);
            return gVar;
        } else if (mMActivity instanceof WalletECardCheckOtherCardUI) {
            gVar = new a(mMActivity, iVar);
            AppMethodBeat.o(48111);
            return gVar;
        } else if (mMActivity instanceof WalletECardElementInputUI) {
            gVar = new e(mMActivity, iVar);
            AppMethodBeat.o(48111);
            return gVar;
        } else if (mMActivity instanceof WalletOpenECardProxyUI) {
            gVar = new c(mMActivity, iVar);
            AppMethodBeat.o(48111);
            return gVar;
        } else if (mMActivity instanceof WalletOpenLqbProxyUI) {
            gVar = new f(mMActivity, iVar);
            AppMethodBeat.o(48111);
            return gVar;
        } else {
            gVar = super.a(mMActivity, iVar);
            AppMethodBeat.o(48111);
            return gVar;
        }
    }

    static /* synthetic */ String b(b bVar) {
        AppMethodBeat.i(48112);
        String string = bVar.mqu.getString(com.tencent.mm.plugin.wallet_ecard.a.a.tPM);
        if (bo.isNullOrNil(string)) {
            string = "WEB_DEBIT";
        }
        AppMethodBeat.o(48112);
        return string;
    }
}
