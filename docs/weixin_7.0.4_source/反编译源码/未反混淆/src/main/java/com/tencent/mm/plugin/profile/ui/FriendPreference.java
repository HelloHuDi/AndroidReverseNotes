package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import junit.framework.Assert;

public class FriendPreference extends Preference implements a {
    private int cHJ;
    private MMActivity crP;
    private ad ehM;
    private TextView gne;
    private String gta;
    private boolean lyb;
    private long pnA;
    private TextView pnu;
    private ImageView pnv;
    private ImageView pnw;
    private com.tencent.mm.plugin.account.friend.a.a pnx;
    private String pny;
    private long pnz;

    public FriendPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(23622);
        this.crP = (MMActivity) context;
        init();
        AppMethodBeat.o(23622);
    }

    public FriendPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23623);
        setLayoutResource(R.layout.ae4);
        setWidgetLayoutResource(R.layout.ag5);
        init();
        AppMethodBeat.o(23623);
    }

    private void init() {
        this.lyb = false;
        this.ehM = null;
        this.pnx = null;
        this.pny = "";
        this.pnz = 0;
        this.pnA = 0;
        this.cHJ = 0;
        this.gta = "";
    }

    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(23624);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.m5);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(R.layout.aeo, viewGroup2);
        AppMethodBeat.o(23624);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23625);
        this.gne = (TextView) view.findViewById(R.id.cx);
        this.pnu = (TextView) view.findViewById(R.id.a81);
        this.pnv = (ImageView) view.findViewById(R.id.aga);
        this.pnw = (ImageView) view.findViewById(R.id.dah);
        this.lyb = true;
        initView();
        super.onBindView(view);
        AppMethodBeat.o(23625);
    }

    private void initView() {
        AppMethodBeat.i(23626);
        if (this.ehM == null || !this.lyb) {
            ab.d("MicroMsg.FriendPreference", "initView : contact = " + this.ehM + " bindView = " + this.lyb);
            AppMethodBeat.o(23626);
        } else if (this.pnz != -1 && new p(this.pnz).longValue() > 0) {
            setWidgetLayoutResource(R.layout.ag6);
            cbh();
            AppMethodBeat.o(23626);
        } else if (this.pnx != null) {
            setWidgetLayoutResource(R.layout.afx);
            cbi();
            AppMethodBeat.o(23626);
        } else if (this.pnA > 0) {
            cbg();
            AppMethodBeat.o(23626);
        } else if (TextUtils.isEmpty(this.gta)) {
            Assert.assertTrue(false);
            AppMethodBeat.o(23626);
        } else {
            cbj();
            AppMethodBeat.o(23626);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cbg() {
        AppMethodBeat.i(23627);
        if (this.ehM == null || !this.lyb) {
            ab.d("MicroMsg.FriendPreference", "initView : contact = " + this.ehM + " bindView = " + this.lyb);
            AppMethodBeat.o(23627);
            return;
        }
        Bitmap decodeStream;
        this.cHJ = 3;
        this.gne.setText(this.mContext.getString(R.string.c_t));
        this.pnu.setText(bo.nullAsNil(this.ehM.dtT));
        Bitmap pS = b.pS(this.pnA);
        if (pS == null) {
            InputStream inputStream = null;
            try {
                inputStream = this.mContext.getResources().openRawResource(R.raw.default_qq_avatar);
                decodeStream = com.tencent.mm.compatible.g.a.decodeStream(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.FriendPreference", e, "", new Object[0]);
                    }
                }
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.FriendPreference", e2, "", new Object[0]);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        decodeStream = pS;
                    } catch (Exception e22) {
                        ab.printErrStackTrace("MicroMsg.FriendPreference", e22, "", new Object[0]);
                        decodeStream = pS;
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                        ab.printErrStackTrace("MicroMsg.FriendPreference", e3, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(23627);
            }
            if (decodeStream != null) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, 48, 48, false);
                if (createScaledBitmap != decodeStream) {
                    ab.i("MicroMsg.FriendPreference", "bitmap recycle %s", decodeStream.toString());
                    decodeStream.recycle();
                }
                this.pnv.setImageBitmap(d.a(createScaledBitmap, true, 0.0f));
            }
            aw.ZK();
            if (!c.isSDCardAvailable()) {
                this.pnv.setBackgroundDrawable(com.tencent.mm.bz.a.g(this.crP, R.raw.default_avatar));
            }
            AppMethodBeat.o(23627);
        }
        decodeStream = pS;
        if (decodeStream != null) {
        }
        aw.ZK();
        if (c.isSDCardAvailable()) {
        }
        AppMethodBeat.o(23627);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cbh() {
        AppMethodBeat.i(23628);
        if (this.ehM == null || !this.lyb) {
            ab.d("MicroMsg.FriendPreference", "initView : contact = " + this.ehM + " bindView = " + this.lyb);
            AppMethodBeat.o(23628);
            return;
        }
        Bitmap decodeStream;
        this.cHJ = 2;
        this.gne.setText(this.mContext.getString(R.string.awk));
        this.pnu.setText(bo.nullAsNil(this.pny) + " " + new p(this.pnz).longValue());
        Bitmap fr = b.fr(this.pnz);
        if (fr == null) {
            InputStream inputStream = null;
            try {
                inputStream = this.mContext.getResources().openRawResource(R.raw.default_qq_avatar);
                decodeStream = com.tencent.mm.compatible.g.a.decodeStream(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.FriendPreference", e, "", new Object[0]);
                    }
                }
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.FriendPreference", e2, "", new Object[0]);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        decodeStream = fr;
                    } catch (Exception e22) {
                        ab.printErrStackTrace("MicroMsg.FriendPreference", e22, "", new Object[0]);
                        decodeStream = fr;
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                        ab.printErrStackTrace("MicroMsg.FriendPreference", e3, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(23628);
            }
            if (decodeStream != null) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, 48, 48, false);
                if (createScaledBitmap != decodeStream) {
                    ab.i("MicroMsg.FriendPreference", "bitmap recycle %s", decodeStream.toString());
                    decodeStream.recycle();
                }
                this.pnv.setImageBitmap(d.a(createScaledBitmap, true, 0.0f));
            }
            aw.ZK();
            if (!c.isSDCardAvailable()) {
                this.pnv.setBackgroundDrawable(com.tencent.mm.bz.a.g(this.crP, R.raw.default_avatar));
            }
            AppMethodBeat.o(23628);
        }
        decodeStream = fr;
        if (decodeStream != null) {
        }
        aw.ZK();
        if (c.isSDCardAvailable()) {
        }
        AppMethodBeat.o(23628);
    }

    private void cbi() {
        AppMethodBeat.i(23629);
        if (this.ehM == null || !this.lyb) {
            ab.d("MicroMsg.FriendPreference", "initView : contact = " + this.ehM + " bindView = " + this.lyb);
            AppMethodBeat.o(23629);
        } else if (this.pnx == null) {
            AppMethodBeat.o(23629);
        } else {
            this.cHJ = 1;
            this.gne.setText(this.mContext.getString(R.string.awj));
            final String str = bo.nullAsNil(this.pnx.apA()) + " " + bo.nullAsNil(this.pnx.apG()).replace(" ", "");
            this.pnu.setText(str);
            Bitmap b = l.b(this.pnx.apz(), this.mContext);
            if (b == null) {
                this.pnv.setImageDrawable(com.tencent.mm.bz.a.g(this.crP, R.raw.default_mobile_avatar));
            } else {
                this.pnv.setImageBitmap(d.a(Bitmap.createScaledBitmap(b, 48, 48, false), true, 0.0f));
            }
            aw.ZK();
            if (c.XM().aoJ(this.pnx.getUsername())) {
                this.pnw.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        String[] stringArray;
                        AppMethodBeat.i(23620);
                        if (FriendPreference.this.pnx == null || bo.isNullOrNil(FriendPreference.this.pnx.frQ)) {
                            stringArray = FriendPreference.this.crP.getResources().getStringArray(R.array.a_);
                        } else {
                            stringArray = FriendPreference.this.crP.getResources().getStringArray(R.array.a9);
                        }
                        if (com.tencent.mm.plugin.profile.b.gkF.BX()) {
                            ArrayList P = bo.P(stringArray);
                            P.add(FriendPreference.this.crP.getResources().getString(R.string.anc));
                            stringArray = (String[]) P.toArray(new String[P.size()]);
                            h.pYm.e(11621, Integer.valueOf(2), Integer.valueOf(3));
                        }
                        com.tencent.mm.ui.base.h.a(FriendPreference.this.crP, null, stringArray, null, new com.tencent.mm.ui.base.h.c() {
                            public final void iE(int i) {
                                AppMethodBeat.i(23619);
                                switch (i) {
                                    case 0:
                                        if (str == null || str.length() == 0) {
                                            AppMethodBeat.o(23619);
                                            return;
                                        }
                                        int lastIndexOf = str.lastIndexOf(32) + 1;
                                        if (lastIndexOf > 0) {
                                            FriendPreference.a(FriendPreference.this, str.substring(lastIndexOf));
                                            AppMethodBeat.o(23619);
                                            return;
                                        }
                                        break;
                                    case 1:
                                        if (str == null || str.length() == 0) {
                                            AppMethodBeat.o(23619);
                                            return;
                                        }
                                        String substring = str.substring(0, str.lastIndexOf(32));
                                        if (substring == null || substring.length() == 0) {
                                            AppMethodBeat.o(23619);
                                            return;
                                        }
                                        t.b(FriendPreference.this.ehM, substring.trim());
                                        AppMethodBeat.o(23619);
                                        return;
                                    case 2:
                                        if (stringArray == null || stringArray.length <= 2 || FriendPreference.this.pnx == null || FriendPreference.this.ehM == null) {
                                            AppMethodBeat.o(23619);
                                            return;
                                        } else if (!(FriendPreference.this.pnx == null || bo.isNullOrNil(FriendPreference.this.pnx.frQ))) {
                                            FriendPreference.a(FriendPreference.this, FriendPreference.this.ehM.field_username, FriendPreference.this.pnx.frQ);
                                            AppMethodBeat.o(23619);
                                            return;
                                        }
                                        break;
                                    case 3:
                                        break;
                                }
                                Intent intent = new Intent();
                                Bundle bundle = new Bundle();
                                bundle.putInt("fromScene", 2);
                                intent.putExtra("reportArgs", bundle);
                                com.tencent.mm.plugin.profile.b.gkE.j(intent, FriendPreference.this.crP);
                                AppMethodBeat.o(23619);
                            }
                        });
                        AppMethodBeat.o(23620);
                    }
                });
                AppMethodBeat.o(23629);
                return;
            }
            this.pnw.setVisibility(4);
            AppMethodBeat.o(23629);
        }
    }

    private void cbj() {
        AppMethodBeat.i(23630);
        if (this.ehM == null || !this.lyb) {
            ab.d("MicroMsg.FriendPreference", "initView : contact = " + this.ehM + " bindView = " + this.lyb);
            AppMethodBeat.o(23630);
            return;
        }
        this.cHJ = 3;
        this.gne.setText(this.mContext.getString(R.string.djy));
        this.pnu.setText(bo.nullAsNil(this.gta));
        this.pnv.setVisibility(8);
        AppMethodBeat.o(23630);
    }

    private boolean q(String str, Bitmap bitmap) {
        AppMethodBeat.i(23631);
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
            boolean a = l.a(str, this.mContext, byteArrayOutputStream.toByteArray());
            AppMethodBeat.o(23631);
            return a;
        }
        AppMethodBeat.o(23631);
        return false;
    }

    public final boolean biV() {
        AppMethodBeat.i(23632);
        o.acd().e(this);
        AppMethodBeat.o(23632);
        return true;
    }

    public final void qj(String str) {
        AppMethodBeat.i(23633);
        long pU = b.pU(str);
        if (pU > 0 && this.pnz == pU && b.a(str, false, -1) != null) {
            initView();
        }
        if (b.pT(str) == this.pnA && b.a(str, false, -1) != null) {
            initView();
        }
        AppMethodBeat.o(23633);
    }

    public final /* synthetic */ CharSequence getSummary() {
        AppMethodBeat.i(23634);
        String charSequence = this.pnu.getText().toString();
        AppMethodBeat.o(23634);
        return charSequence;
    }

    static /* synthetic */ void a(FriendPreference friendPreference, String str) {
        AppMethodBeat.i(23635);
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
        friendPreference.crP.startActivity(intent);
        AppMethodBeat.o(23635);
    }
}
