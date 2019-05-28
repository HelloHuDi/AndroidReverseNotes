package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.v;
import com.tencent.smtt.sdk.WebView;
import java.util.LinkedList;
import java.util.List;

public class AtContactWidget extends LinearLayout {
    private View contentView;
    private Activity gNy;
    private TextView iyE;
    private ImageView rhd;
    private TextView rhe;
    private PreviewContactView rhf;
    SnsUploadConfigView rhg;
    private List<String> rhh = new LinkedList();
    private boolean rhi = false;

    @TargetApi(11)
    public AtContactWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(38152);
        init(context);
        AppMethodBeat.o(38152);
    }

    public AtContactWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38153);
        init(context);
        AppMethodBeat.o(38153);
    }

    public List<String> getAtList() {
        AppMethodBeat.i(38154);
        if (this.rhh == null) {
            this.rhh = new LinkedList();
        }
        List list = this.rhh;
        AppMethodBeat.o(38154);
        return list;
    }

    public final void crA() {
        AppMethodBeat.i(38155);
        if (this.rhh == null) {
            this.rhh = new LinkedList();
        }
        this.rhh.clear();
        if (this.rhf != null) {
            this.rhf.setList(this.rhh);
        }
        crB();
        if (this.rhe != null) {
            this.rhe.setVisibility(8);
        }
        if (this.iyE != null) {
            this.iyE.setTextColor(getResources().getColor(R.color.w4));
        }
        AppMethodBeat.o(38155);
    }

    private void init(Context context) {
        AppMethodBeat.i(38156);
        this.gNy = (Activity) context;
        this.contentView = v.hu(context).inflate(getLayoutResource(), this);
        this.rhf = (PreviewContactView) this.contentView.findViewById(R.id.z9);
        this.rhd = (ImageView) this.contentView.findViewById(R.id.z7);
        this.rhe = (TextView) this.contentView.findViewById(R.id.edr);
        this.iyE = (TextView) this.contentView.findViewById(R.id.z8);
        this.contentView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(38150);
                AtContactWidget.a(AtContactWidget.this);
                AppMethodBeat.o(38150);
            }
        });
        this.contentView.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(38151);
                int i = (int) (d.anS().density * 36.0f);
                if (i != 0) {
                    i = (((AtContactWidget.this.contentView.getWidth() - AtContactWidget.this.rhd.getWidth()) - AtContactWidget.this.iyE.getWidth()) - ((int) (d.anS().density * 32.0f))) / i;
                    if (i > 0 && i < 5) {
                        AtContactWidget.this.rhf.setLineNum(i);
                        LayoutParams layoutParams = (LayoutParams) AtContactWidget.this.rhf.getLayoutParams();
                        layoutParams.alignWithParent = true;
                        AtContactWidget.this.rhf.setLayoutParams(layoutParams);
                    }
                }
                AppMethodBeat.o(38151);
            }
        });
        AppMethodBeat.o(38156);
    }

    public final boolean ao(Intent intent) {
        AppMethodBeat.i(38157);
        String stringExtra = intent.getStringExtra("Select_Contact");
        LinkedList linkedList = new LinkedList();
        if (stringExtra == null || stringExtra.equals("")) {
            List linkedList2 = new LinkedList();
        } else {
            Object linkedList22 = bo.P(stringExtra.split(","));
        }
        if (this.rhh == null) {
            this.rhh = new LinkedList();
        }
        this.rhh.clear();
        for (String stringExtra2 : linkedList22) {
            if (!this.rhh.contains(stringExtra2)) {
                this.rhh.add(stringExtra2);
            }
        }
        if (this.rhf != null) {
            this.rhf.setList(this.rhh);
        }
        if (this.iyE != null) {
            this.iyE.setTextColor(getResources().getColor(linkedList22.isEmpty() ? R.color.w4 : R.color.r8));
        }
        if (this.rhi) {
            ab.d("MicroMsg.AtContactWiget", "withList count " + this.rhh.size());
            if (!this.rhi || this.rhe == null || this.rhh.size() <= 0) {
                this.rhe.setVisibility(8);
            } else {
                this.rhe.setVisibility(0);
                if (this.rhh.size() < 100) {
                    this.rhe.setText(this.rhh.size());
                    this.rhe.setBackgroundResource(r.ik(getContext()));
                } else {
                    this.rhe.setText("");
                    this.rhe.setBackgroundResource(R.raw.badge_count_more);
                }
            }
        }
        crB();
        AppMethodBeat.o(38157);
        return true;
    }

    private void crB() {
        AppMethodBeat.i(38158);
        if (this.rhh.size() > 0) {
            this.rhd.setImageDrawable(ah.f(this.gNy, getWithDrawableId(), getContext().getResources().getColor(R.color.a61)));
            AppMethodBeat.o(38158);
            return;
        }
        this.rhd.setImageDrawable(ah.f(this.gNy, getWithEmptyDrawableId(), WebView.NIGHT_MODE_COLOR));
        AppMethodBeat.o(38158);
    }

    public void setShowAtList(boolean z) {
        AppMethodBeat.i(38159);
        if (this.rhf != null) {
            this.rhf.setVisibility(z ? 0 : 8);
        }
        AppMethodBeat.o(38159);
    }

    public void setShowAtTips(boolean z) {
        AppMethodBeat.i(38160);
        if (!(this.contentView == null || this.iyE == null)) {
            this.iyE.setVisibility(z ? 0 : 8);
        }
        AppMethodBeat.o(38160);
    }

    public void setShowAtNum(boolean z) {
        this.rhi = z;
    }

    /* Access modifiers changed, original: protected */
    public int getLayoutResource() {
        return R.layout.et;
    }

    /* Access modifiers changed, original: protected */
    public int getWithDrawableId() {
        return R.raw.album_mention_icon_pressed;
    }

    /* Access modifiers changed, original: protected */
    public int getWithEmptyDrawableId() {
        return R.raw.album_mention_icon_normal;
    }

    static /* synthetic */ void a(AtContactWidget atContactWidget) {
        AppMethodBeat.i(38161);
        if (atContactWidget.rhh == null) {
            atContactWidget.rhh = new LinkedList();
        }
        if (atContactWidget.rhg == null || atContactWidget.rhg.getPrivated() <= 0) {
            Intent intent = new Intent();
            intent.putExtra("Contact_Compose", true);
            intent.putExtra("List_Type", 1);
            intent.putExtra("Add_address_titile", atContactWidget.gNy.getString(R.string.eqq));
            intent.putExtra("Contact_GroupFilter_Type", "@micromsg.qq.com");
            intent.putExtra("Block_list", com.tencent.mm.model.r.Yz());
            intent.putExtra("Select_Contact", bo.c(atContactWidget.rhh, ","));
            intent.putExtra("sns_address_count", 0);
            a.gkE.a(intent, atContactWidget.gNy, 6);
            AppMethodBeat.o(38161);
            return;
        }
        h.g(atContactWidget.gNy, R.string.epa, R.string.tz);
        AppMethodBeat.o(38161);
    }
}
