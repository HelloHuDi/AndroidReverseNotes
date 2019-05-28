package com.tencent.mm.ui.chatting;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.cb.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.w;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.g.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.bdl;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.AllRemindMsgUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.textview.b;
import com.tencent.recovery.wx.util.NetUtil;
import java.io.IOException;

@a(3)
public class TextPreviewUI extends MMActivity implements f {
    private int bottom = 0;
    private bi cKd;
    private Animation qzo;
    private Animation qzp;
    private TextView sW = null;
    private CharSequence text = null;
    private boolean vpf = false;
    private int yI;
    private TextView yJL = null;
    private final int yMA = 1;
    private final int yMB = 2;
    private boolean yMC = false;
    private ToolsBar yMD;
    private View yME;
    private com.tencent.mm.ui.widget.textview.a yMs;
    private com.tencent.mm.ui.widget.b.a yMt;
    private CharSequence yMu;
    private View yMv;
    private View yMw;
    private View yMx;
    private CustomScrollView yMy;
    private final int yMz = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int getLayoutId() {
        return R.layout.mr;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(31060);
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        if (d.iW(19)) {
            getWindow().setFlags(67109888, 67109888);
        }
        this.yMv = findViewById(R.id.ase);
        this.text = getIntent().getCharSequenceExtra("key_chat_text");
        long longExtra = getIntent().getLongExtra("Chat_Msg_Id", 0);
        aw.ZK();
        this.cKd = c.XO().jf(longExtra);
        this.sW = (TextView) findViewById(R.id.ash);
        this.yJL = (TextView) findViewById(R.id.asf);
        CharSequence charSequence = this.text;
        TextView textView = this.yJL;
        if (charSequence instanceof SpannableString) {
            textView.setText(((SpannableString) charSequence).toString());
            j.h(textView, 1);
            charSequence = textView.getText();
        }
        this.text = charSequence;
        this.sW.setText(g.dqQ().b(this.text, this.sW.getTextSize()));
        this.yMw = findViewById(R.id.asj);
        this.yMx = this.yMw.findViewById(R.id.ask);
        this.yMy = (CustomScrollView) findViewById(R.id.asg);
        this.sW.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.i(31043);
                TextPreviewUI.this.sW.getViewTreeObserver().removeOnPreDrawListener(this);
                if (TextPreviewUI.this.sW.getLineCount() == 1) {
                    TextPreviewUI.this.sW.setGravity(1);
                }
                AppMethodBeat.o(31043);
                return false;
            }
        });
        this.qzp = AnimationUtils.loadAnimation(this.mController.ylL, R.anim.cg);
        this.qzo = AnimationUtils.loadAnimation(this.mController.ylL, R.anim.ce);
        this.yMt = new com.tencent.mm.ui.widget.b.a(this.mController.ylL, this.sW);
        this.yMt.zSa = true;
        this.yMt.zRZ = new OnCreateContextMenuListener() {
            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(31051);
                contextMenu.clear();
                contextMenu.add(0, 0, 0, TextPreviewUI.this.getResources().getString(R.string.oy));
                int t = bh.t(TextPreviewUI.this.cKd);
                if (t <= 0 || t >= b.fs(TextPreviewUI.this.sW).length()) {
                    contextMenu.add(1, 1, 0, TextPreviewUI.this.getResources().getString(R.string.czl));
                }
                contextMenu.add(1, 2, 0, TextPreviewUI.this.getResources().getString(R.string.czk));
                AppMethodBeat.o(31051);
            }
        };
        this.yMt.rBm = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(31053);
                switch (menuItem.getItemId()) {
                    case 0:
                        ((ClipboardManager) ah.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(TextPreviewUI.this.yMu, TextPreviewUI.this.yMu));
                        if (TextPreviewUI.this.yMs != null) {
                            TextPreviewUI.this.yMs.dLM();
                            TextPreviewUI.this.yMs.zWC = true;
                            TextPreviewUI.this.yMs.zWD = true;
                            TextPreviewUI.this.yMs.dLL();
                        }
                        Toast.makeText(TextPreviewUI.this.mController.ylL, R.string.oz, 0).show();
                        AppMethodBeat.o(31053);
                        return;
                    case 1:
                        if (TextPreviewUI.this.yMs != null) {
                            TextPreviewUI.this.yMs.dLL();
                            TextPreviewUI.this.yMs.dLP();
                            TextPreviewUI.this.yMs.hH(0, TextPreviewUI.this.sW.getText().length());
                            TextPreviewUI.this.yMs.zWC = false;
                            TextPreviewUI.this.yMs.zWD = false;
                            TextPreviewUI.this.yMs.dLO();
                        }
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(31052);
                                if (TextPreviewUI.this.yMs != null) {
                                    TextPreviewUI.this.yMs.dLS();
                                }
                                AppMethodBeat.o(31052);
                            }
                        }, 100);
                        AppMethodBeat.o(31053);
                        return;
                    case 2:
                        TextPreviewUI.e(TextPreviewUI.this.mController.ylL, TextPreviewUI.this.yMu);
                        break;
                }
                AppMethodBeat.o(31053);
            }
        };
        if (this.yMs == null && !bh.o(this.cKd)) {
            com.tencent.mm.ui.widget.textview.a.a aVar = new com.tencent.mm.ui.widget.textview.a.a(this.sW, this.yMt);
            aVar.zWt = R.color.z1;
            aVar.zWu = R.color.l7;
            this.yMs = aVar.dLT();
            this.yMs.zWl = new v() {
                public final void af(CharSequence charSequence) {
                    AppMethodBeat.i(31054);
                    TextPreviewUI.this.yMu = charSequence;
                    AppMethodBeat.o(31054);
                }
            };
        }
        this.yMv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(31055);
                if (TextPreviewUI.this.yMs == null || (TextPreviewUI.this.yMs.zWC && TextPreviewUI.this.yMs.zWD)) {
                    TextPreviewUI.this.finish();
                    AppMethodBeat.o(31055);
                    return;
                }
                TextPreviewUI.this.yMs.dLM();
                TextPreviewUI.this.yMs.zWC = true;
                TextPreviewUI.this.yMs.zWD = true;
                TextPreviewUI.this.yMs.dLL();
                AppMethodBeat.o(31055);
            }
        });
        this.sW.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(31056);
                if (TextPreviewUI.this.yMs == null || (TextPreviewUI.this.yMs.zWC && TextPreviewUI.this.yMs.zWD)) {
                    TextPreviewUI.this.finish();
                    AppMethodBeat.o(31056);
                    return;
                }
                TextPreviewUI.this.yMs.dLM();
                TextPreviewUI.this.yMs.zWC = true;
                TextPreviewUI.this.yMs.zWD = true;
                TextPreviewUI.this.yMs.dLL();
                AppMethodBeat.o(31056);
            }
        });
        if (!bo.isNullOrNil(bh.r(this.cKd))) {
            this.yMw.setVisibility(0);
            this.yMx.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(31057);
                    Intent intent = new Intent(TextPreviewUI.this, WebViewUI.class);
                    intent.putExtra("rawUrl", bh.r(TextPreviewUI.this.cKd));
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("needRedirect", false);
                    TextPreviewUI.this.startActivity(intent);
                    AppMethodBeat.o(31057);
                }
            });
        } else if (!bh.o(this.cKd)) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.asi);
            if (viewStub != null) {
                this.yME = viewStub.inflate();
            }
            this.yMD = (ToolsBar) findViewById(R.id.ew8);
            this.yMD.setVisibility(0);
            if (this.yMD != null) {
                this.yMD.c(0, new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(31048);
                        if (TextPreviewUI.this.cKd != null) {
                            TextPreviewUI.e(TextPreviewUI.this.mController.ylL, TextPreviewUI.this.text.toString());
                        }
                        AppMethodBeat.o(31048);
                    }
                });
                this.yMD.c(1, new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(31049);
                        TextPreviewUI.l(TextPreviewUI.this);
                        AppMethodBeat.o(31049);
                    }
                });
                this.yMD.c(2, new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(31050);
                        TextPreviewUI.b(TextPreviewUI.this, TextPreviewUI.this.cKd);
                        AppMethodBeat.o(31050);
                    }
                });
            }
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(31058);
                TextPreviewUI.this.finish();
                AppMethodBeat.o(31058);
                return true;
            }
        });
        this.yMy.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(31059);
                switch (motionEvent.getAction()) {
                    case 0:
                        TextPreviewUI.this.vpf = true;
                        break;
                    case 1:
                        TextPreviewUI.this.vpf = false;
                        TextPreviewUI.this.yMC = false;
                        break;
                    case 2:
                        if (!TextPreviewUI.this.yMC) {
                            TextPreviewUI.this.yMC = true;
                            TextPreviewUI.this.vpf = true;
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(31059);
                return false;
            }
        });
        this.yMy.setOnScrollChangeListener(new CustomScrollView.a() {
            public final void a(ScrollView scrollView, int i, int i2) {
                AppMethodBeat.i(31044);
                int i3 = i - i2;
                TextPreviewUI.this.yI;
                if ((scrollView.getChildAt(0).getMeasuredHeight() == scrollView.getHeight() + scrollView.getScrollY() ? 1 : 0) != 0) {
                    TextPreviewUI.this.bottom = scrollView.getScrollY();
                }
                if (scrollView.getScrollY() <= 0 || (scrollView.getScrollY() >= TextPreviewUI.this.bottom - 10 && TextPreviewUI.this.bottom > 0)) {
                    TextPreviewUI.h(TextPreviewUI.this);
                } else if (TextPreviewUI.this.vpf) {
                    if (i2 > i) {
                        TextPreviewUI.h(TextPreviewUI.this);
                    } else if (i2 < i) {
                        TextPreviewUI.j(TextPreviewUI.this);
                    }
                    TextPreviewUI.this.vpf = false;
                }
                TextPreviewUI.this.yI = i3;
                AppMethodBeat.o(31044);
            }
        });
        aw.Rg().a((int) i.CTRL_INDEX, (f) this);
        AppMethodBeat.o(31060);
    }

    public void onResume() {
        AppMethodBeat.i(31061);
        super.onResume();
        if (this.yMs != null) {
            if (!this.yMs.zWC) {
                this.yMs.dLS();
            }
            if (!this.yMs.zWD) {
                this.yMs.dLO();
            }
        }
        AppMethodBeat.o(31061);
    }

    public void onBackPressed() {
        AppMethodBeat.i(31062);
        finish();
        AppMethodBeat.o(31062);
    }

    private void ba(final bi biVar) {
        AppMethodBeat.i(31063);
        final com.tencent.mm.ui.chatting.view.b bVar = new com.tencent.mm.ui.chatting.view.b(this.mController.ylL);
        bVar.zaY = new com.tencent.mm.ui.chatting.view.b.a() {
            public final void ne(long j) {
                AppMethodBeat.i(31046);
                bVar.hide();
                h.pYm.a(795, 1, 1, false);
                if (NetUtil.isConnected(TextPreviewUI.this.mController.ylL)) {
                    bre bre = new bre();
                    bre.lvf = (int) (j / 1000);
                    bre.jCt = 1;
                    bre.wOI = 1;
                    try {
                        String str;
                        bdl bdl = new bdl();
                        bdl.jBB = biVar.field_talker;
                        bdl.ptF = biVar.field_msgSvrId;
                        TextPreviewUI textPreviewUI = TextPreviewUI.this;
                        bi biVar = biVar;
                        if (biVar.isText() || biVar.dtz()) {
                            str = biVar.field_content;
                            int ox = bf.ox(str);
                            if (ox != -1) {
                                str = str.substring(ox + 1).trim();
                            }
                        } else {
                            str = AllRemindMsgUI.a(textPreviewUI.mController.ylL, biVar.getType(), biVar.field_content, biVar.field_isSend);
                            ab.i("MicroMsg.TextPreviewUI", "[getRemindTitle] msgId:%s type:%s title:%s", Long.valueOf(biVar.field_msgId), Integer.valueOf(biVar.getType()), str);
                        }
                        bdl.Title = str;
                        bre.wcJ = new com.tencent.mm.bt.b(bdl.toByteArray());
                    } catch (IOException e) {
                        ab.e("MicroMsg.TextPreviewUI", "[onOk] %s", e.toString());
                    }
                    aw.Rg().a(new w(1, bre), 0);
                    AppMethodBeat.o(31046);
                    return;
                }
                com.tencent.mm.ui.base.h.b(TextPreviewUI.this.mController.ylL, TextPreviewUI.this.getString(R.string.d5l), TextPreviewUI.this.getString(R.string.dna), true);
                AppMethodBeat.o(31046);
            }

            public final void onCancel() {
                AppMethodBeat.i(31047);
                bVar.hide();
                AppMethodBeat.o(31047);
            }
        };
        bVar.show();
        AppMethodBeat.o(31063);
    }

    public void onDestroy() {
        AppMethodBeat.i(31064);
        super.onDestroy();
        aw.Rg().b((int) i.CTRL_INDEX, (f) this);
        AppMethodBeat.o(31064);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(31065);
        if (i == 0 && i2 == 0) {
            switch (mVar.getType()) {
                case i.CTRL_INDEX /*525*/:
                    ab.i("MicroMsg.TextPreviewUI", "set msg remind!");
                    com.tencent.mm.ui.widget.snackbar.b.a(this.mController.ylL, this.mController.ylL.getResources().getString(R.string.cbl), "", null);
                    AppMethodBeat.o(31065);
                    return;
                default:
                    AppMethodBeat.o(31065);
                    return;
            }
        }
        if (mVar.getType() == i.CTRL_INDEX) {
            ab.e("MicroMsg.TextPreviewUI", "[setMsgRemind] scene type:%s errCode:%s, errType:%s, errMsg:%s", Integer.valueOf(i.CTRL_INDEX), Integer.valueOf(i2), Integer.valueOf(i), bo.nullAsNil(str));
            Context context = this.mController.ylL;
            if (bo.isNullOrNil(str)) {
                str = getResources().getString(R.string.dn_);
            }
            com.tencent.mm.ui.base.h.b(context, str, this.mController.ylL.getResources().getString(R.string.dna), true);
            h.pYm.a(795, 4, 1, false);
        }
        AppMethodBeat.o(31065);
    }

    static /* synthetic */ void e(Context context, CharSequence charSequence) {
        AppMethodBeat.i(31066);
        Intent intent = new Intent(context, MsgRetransmitUI.class);
        intent.putExtra("Retr_Msg_content", charSequence);
        intent.putExtra("Retr_Msg_Type", 4);
        context.startActivity(intent);
        AppMethodBeat.o(31066);
    }

    static /* synthetic */ void h(TextPreviewUI textPreviewUI) {
        AppMethodBeat.i(31067);
        if (textPreviewUI.yME != null && bo.isNullOrNil(bh.r(textPreviewUI.cKd))) {
            textPreviewUI.yME.setAnimation(textPreviewUI.qzp);
            textPreviewUI.yME.setVisibility(0);
        }
        AppMethodBeat.o(31067);
    }

    static /* synthetic */ void j(TextPreviewUI textPreviewUI) {
        AppMethodBeat.i(31068);
        if (textPreviewUI.yME != null) {
            textPreviewUI.yME.setAnimation(textPreviewUI.qzo);
            textPreviewUI.yME.setVisibility(8);
        }
        AppMethodBeat.o(31068);
    }

    static /* synthetic */ void l(TextPreviewUI textPreviewUI) {
        AppMethodBeat.i(31070);
        cl clVar = new cl();
        e.d(clVar, textPreviewUI.cKd);
        clVar.cvA.activity = textPreviewUI;
        clVar.cvA.cvH = 43;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        AppMethodBeat.o(31070);
    }
}
