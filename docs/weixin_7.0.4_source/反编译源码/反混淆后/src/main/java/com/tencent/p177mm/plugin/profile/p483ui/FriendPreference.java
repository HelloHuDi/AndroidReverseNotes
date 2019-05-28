package com.tencent.p177mm.plugin.profile.p483ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.account.friend.p272a.C18817a;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.WebView;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.profile.ui.FriendPreference */
public class FriendPreference extends Preference implements C8915a {
    private int cHJ;
    private MMActivity crP;
    private C7616ad ehM;
    private TextView gne;
    private String gta;
    private boolean lyb;
    private long pnA;
    private TextView pnu;
    private ImageView pnv;
    private ImageView pnw;
    private C18817a pnx;
    private String pny;
    private long pnz;

    public FriendPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(23622);
        this.crP = (MMActivity) context;
        init();
        AppMethodBeat.m2505o(23622);
    }

    public FriendPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23623);
        setLayoutResource(2130970127);
        setWidgetLayoutResource(2130970202);
        init();
        AppMethodBeat.m2505o(23623);
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
        AppMethodBeat.m2504i(23624);
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131821019);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130970148, viewGroup2);
        AppMethodBeat.m2505o(23624);
        return onCreateView;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23625);
        this.gne = (TextView) view.findViewById(2131820678);
        this.pnu = (TextView) view.findViewById(2131821841);
        this.pnv = (ImageView) view.findViewById(2131822184);
        this.pnw = (ImageView) view.findViewById(2131826074);
        this.lyb = true;
        initView();
        super.onBindView(view);
        AppMethodBeat.m2505o(23625);
    }

    private void initView() {
        AppMethodBeat.m2504i(23626);
        if (this.ehM == null || !this.lyb) {
            C4990ab.m7410d("MicroMsg.FriendPreference", "initView : contact = " + this.ehM + " bindView = " + this.lyb);
            AppMethodBeat.m2505o(23626);
        } else if (this.pnz != -1 && new C1183p(this.pnz).longValue() > 0) {
            setWidgetLayoutResource(2130970203);
            cbh();
            AppMethodBeat.m2505o(23626);
        } else if (this.pnx != null) {
            setWidgetLayoutResource(2130970194);
            cbi();
            AppMethodBeat.m2505o(23626);
        } else if (this.pnA > 0) {
            cbg();
            AppMethodBeat.m2505o(23626);
        } else if (TextUtils.isEmpty(this.gta)) {
            Assert.assertTrue(false);
            AppMethodBeat.m2505o(23626);
        } else {
            cbj();
            AppMethodBeat.m2505o(23626);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cbg() {
        AppMethodBeat.m2504i(23627);
        if (this.ehM == null || !this.lyb) {
            C4990ab.m7410d("MicroMsg.FriendPreference", "initView : contact = " + this.ehM + " bindView = " + this.lyb);
            AppMethodBeat.m2505o(23627);
            return;
        }
        Bitmap decodeStream;
        this.cHJ = 3;
        this.gne.setText(this.mContext.getString(C25738R.string.c_t));
        this.pnu.setText(C5046bo.nullAsNil(this.ehM.dtT));
        Bitmap pS = C41730b.m73500pS(this.pnA);
        if (pS == null) {
            InputStream inputStream = null;
            try {
                inputStream = this.mContext.getResources().openRawResource(C1318a.default_qq_avatar);
                decodeStream = C1434a.decodeStream(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.FriendPreference", e, "", new Object[0]);
                    }
                }
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.FriendPreference", e2, "", new Object[0]);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        decodeStream = pS;
                    } catch (Exception e22) {
                        C4990ab.printErrStackTrace("MicroMsg.FriendPreference", e22, "", new Object[0]);
                        decodeStream = pS;
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                        C4990ab.printErrStackTrace("MicroMsg.FriendPreference", e3, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(23627);
            }
            if (decodeStream != null) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, 48, 48, false);
                if (createScaledBitmap != decodeStream) {
                    C4990ab.m7417i("MicroMsg.FriendPreference", "bitmap recycle %s", decodeStream.toString());
                    decodeStream.recycle();
                }
                this.pnv.setImageBitmap(C5056d.m7616a(createScaledBitmap, true, 0.0f));
            }
            C9638aw.m17190ZK();
            if (!C18628c.isSDCardAvailable()) {
                this.pnv.setBackgroundDrawable(C1338a.m2864g(this.crP, C1318a.default_avatar));
            }
            AppMethodBeat.m2505o(23627);
        }
        decodeStream = pS;
        if (decodeStream != null) {
        }
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
        }
        AppMethodBeat.m2505o(23627);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cbh() {
        AppMethodBeat.m2504i(23628);
        if (this.ehM == null || !this.lyb) {
            C4990ab.m7410d("MicroMsg.FriendPreference", "initView : contact = " + this.ehM + " bindView = " + this.lyb);
            AppMethodBeat.m2505o(23628);
            return;
        }
        Bitmap decodeStream;
        this.cHJ = 2;
        this.gne.setText(this.mContext.getString(C25738R.string.awk));
        this.pnu.setText(C5046bo.nullAsNil(this.pny) + " " + new C1183p(this.pnz).longValue());
        Bitmap fr = C41730b.m73496fr(this.pnz);
        if (fr == null) {
            InputStream inputStream = null;
            try {
                inputStream = this.mContext.getResources().openRawResource(C1318a.default_qq_avatar);
                decodeStream = C1434a.decodeStream(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.FriendPreference", e, "", new Object[0]);
                    }
                }
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.FriendPreference", e2, "", new Object[0]);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        decodeStream = fr;
                    } catch (Exception e22) {
                        C4990ab.printErrStackTrace("MicroMsg.FriendPreference", e22, "", new Object[0]);
                        decodeStream = fr;
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                        C4990ab.printErrStackTrace("MicroMsg.FriendPreference", e3, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(23628);
            }
            if (decodeStream != null) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeStream, 48, 48, false);
                if (createScaledBitmap != decodeStream) {
                    C4990ab.m7417i("MicroMsg.FriendPreference", "bitmap recycle %s", decodeStream.toString());
                    decodeStream.recycle();
                }
                this.pnv.setImageBitmap(C5056d.m7616a(createScaledBitmap, true, 0.0f));
            }
            C9638aw.m17190ZK();
            if (!C18628c.isSDCardAvailable()) {
                this.pnv.setBackgroundDrawable(C1338a.m2864g(this.crP, C1318a.default_avatar));
            }
            AppMethodBeat.m2505o(23628);
        }
        decodeStream = fr;
        if (decodeStream != null) {
        }
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
        }
        AppMethodBeat.m2505o(23628);
    }

    private void cbi() {
        AppMethodBeat.m2504i(23629);
        if (this.ehM == null || !this.lyb) {
            C4990ab.m7410d("MicroMsg.FriendPreference", "initView : contact = " + this.ehM + " bindView = " + this.lyb);
            AppMethodBeat.m2505o(23629);
        } else if (this.pnx == null) {
            AppMethodBeat.m2505o(23629);
        } else {
            this.cHJ = 1;
            this.gne.setText(this.mContext.getString(C25738R.string.awj));
            final String str = C5046bo.nullAsNil(this.pnx.apA()) + " " + C5046bo.nullAsNil(this.pnx.apG()).replace(" ", "");
            this.pnu.setText(str);
            Bitmap b = C38033l.m64348b(this.pnx.apz(), this.mContext);
            if (b == null) {
                this.pnv.setImageDrawable(C1338a.m2864g(this.crP, C1318a.default_mobile_avatar));
            } else {
                this.pnv.setImageBitmap(C5056d.m7616a(Bitmap.createScaledBitmap(b, 48, 48, false), true, 0.0f));
            }
            C9638aw.m17190ZK();
            if (C18628c.m29078XM().aoJ(this.pnx.getUsername())) {
                this.pnw.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        String[] stringArray;
                        AppMethodBeat.m2504i(23620);
                        if (FriendPreference.this.pnx == null || C5046bo.isNullOrNil(FriendPreference.this.pnx.frQ)) {
                            stringArray = FriendPreference.this.crP.getResources().getStringArray(C25738R.array.f12626a_);
                        } else {
                            stringArray = FriendPreference.this.crP.getResources().getStringArray(C25738R.array.f12625a9);
                        }
                        if (C39503b.gkF.mo38848BX()) {
                            ArrayList P = C5046bo.m7508P(stringArray);
                            P.add(FriendPreference.this.crP.getResources().getString(C25738R.string.anc));
                            stringArray = (String[]) P.toArray(new String[P.size()]);
                            C7060h.pYm.mo8381e(11621, Integer.valueOf(2), Integer.valueOf(3));
                        }
                        C30379h.m48422a(FriendPreference.this.crP, null, stringArray, null, new C30391c() {
                            /* renamed from: iE */
                            public final void mo7700iE(int i) {
                                AppMethodBeat.m2504i(23619);
                                switch (i) {
                                    case 0:
                                        if (str == null || str.length() == 0) {
                                            AppMethodBeat.m2505o(23619);
                                            return;
                                        }
                                        int lastIndexOf = str.lastIndexOf(32) + 1;
                                        if (lastIndexOf > 0) {
                                            FriendPreference.m38742a(FriendPreference.this, str.substring(lastIndexOf));
                                            AppMethodBeat.m2505o(23619);
                                            return;
                                        }
                                        break;
                                    case 1:
                                        if (str == null || str.length() == 0) {
                                            AppMethodBeat.m2505o(23619);
                                            return;
                                        }
                                        String substring = str.substring(0, str.lastIndexOf(32));
                                        if (substring == null || substring.length() == 0) {
                                            AppMethodBeat.m2505o(23619);
                                            return;
                                        }
                                        C1855t.m3887b(FriendPreference.this.ehM, substring.trim());
                                        AppMethodBeat.m2505o(23619);
                                        return;
                                    case 2:
                                        if (stringArray == null || stringArray.length <= 2 || FriendPreference.this.pnx == null || FriendPreference.this.ehM == null) {
                                            AppMethodBeat.m2505o(23619);
                                            return;
                                        } else if (!(FriendPreference.this.pnx == null || C5046bo.isNullOrNil(FriendPreference.this.pnx.frQ))) {
                                            FriendPreference.m38743a(FriendPreference.this, FriendPreference.this.ehM.field_username, FriendPreference.this.pnx.frQ);
                                            AppMethodBeat.m2505o(23619);
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
                                C39503b.gkE.mo38925j(intent, FriendPreference.this.crP);
                                AppMethodBeat.m2505o(23619);
                            }
                        });
                        AppMethodBeat.m2505o(23620);
                    }
                });
                AppMethodBeat.m2505o(23629);
                return;
            }
            this.pnw.setVisibility(4);
            AppMethodBeat.m2505o(23629);
        }
    }

    private void cbj() {
        AppMethodBeat.m2504i(23630);
        if (this.ehM == null || !this.lyb) {
            C4990ab.m7410d("MicroMsg.FriendPreference", "initView : contact = " + this.ehM + " bindView = " + this.lyb);
            AppMethodBeat.m2505o(23630);
            return;
        }
        this.cHJ = 3;
        this.gne.setText(this.mContext.getString(C25738R.string.djy));
        this.pnu.setText(C5046bo.nullAsNil(this.gta));
        this.pnv.setVisibility(8);
        AppMethodBeat.m2505o(23630);
    }

    /* renamed from: q */
    private boolean m38747q(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(23631);
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
            boolean a = C38033l.m64344a(str, this.mContext, byteArrayOutputStream.toByteArray());
            AppMethodBeat.m2505o(23631);
            return a;
        }
        AppMethodBeat.m2505o(23631);
        return false;
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(23632);
        C17884o.acd().mo67503e(this);
        AppMethodBeat.m2505o(23632);
        return true;
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(23633);
        long pU = C41730b.m73502pU(str);
        if (pU > 0 && this.pnz == pU && C41730b.m73490a(str, false, -1) != null) {
            initView();
        }
        if (C41730b.m73501pT(str) == this.pnA && C41730b.m73490a(str, false, -1) != null) {
            initView();
        }
        AppMethodBeat.m2505o(23633);
    }

    public final /* synthetic */ CharSequence getSummary() {
        AppMethodBeat.m2504i(23634);
        String charSequence = this.pnu.getText().toString();
        AppMethodBeat.m2505o(23634);
        return charSequence;
    }

    /* renamed from: a */
    static /* synthetic */ void m38742a(FriendPreference friendPreference, String str) {
        AppMethodBeat.m2504i(23635);
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse(WebView.SCHEME_TEL.concat(String.valueOf(str))));
        friendPreference.crP.startActivity(intent);
        AppMethodBeat.m2505o(23635);
    }
}
