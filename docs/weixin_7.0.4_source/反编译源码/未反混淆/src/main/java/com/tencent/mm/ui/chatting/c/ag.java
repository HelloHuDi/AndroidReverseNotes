package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.c.a.a;
import com.tencent.mm.ui.chatting.c.b.d;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.c.b.z;
import com.tencent.mm.ui.chatting.u;
import com.tencent.mm.ui.tools.o;
import com.tencent.mm.ui.tools.o.b;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.ArrayList;

@a(dFp = z.class)
public class ag extends a implements z {
    private o elS = null;
    private ListView yRA;
    private View yRB;
    private u yRC;
    public boolean yRD = false;
    private boolean yRE = true;
    private int yRF = 0;
    private boolean yRG = false;
    private View yRq;
    public boolean yRr = false;
    public boolean yRs = false;
    public boolean yRt = false;
    public boolean yRu = false;
    public boolean yRv = false;
    private long yRw = -1;
    private ArrayList<String> yRx;
    public boolean yRy = false;
    private TextView yRz;

    public final ArrayList<String> dEM() {
        return this.yRx;
    }

    public final boolean ng(long j) {
        AppMethodBeat.i(31653);
        if (this.yRw != j || !this.yRu || this.yRx == null || this.yRx.size() <= 0) {
            AppMethodBeat.o(31653);
            return false;
        }
        AppMethodBeat.o(31653);
        return true;
    }

    public final boolean dEN() {
        return this.yRt;
    }

    public final void dEO() {
        AppMethodBeat.i(31654);
        String str = "MicroMsg.ChattingUI.SearchComponent";
        String str2 = "enter edit search mode, search stub view is null?%B";
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(this.yRq == null);
        ab.v(str, str2, objArr);
        this.yRD = true;
        this.cgL.Or(8);
        if (this.yRq != null) {
            this.yRq.setVisibility(0);
            if (this.yRC != null) {
                this.yRC.talker = this.cgL.getTalkerUserName();
            }
        } else {
            i.a(this.cgL.yTx, R.id.alp);
            this.yRq = this.cgL.findViewById(R.id.alq);
            this.yRq.setVisibility(0);
            this.yRB = this.cgL.findViewById(R.id.e6s);
            this.cgL.getListView().setFocusable(false);
            this.cgL.getListView().setFocusableInTouchMode(false);
            this.yRB.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                }
            });
            this.yRB.setVisibility(8);
            this.yRz = (TextView) this.cgL.findViewById(R.id.av1);
            boolean z = this.cgL.dFw() || ((d) this.cgL.aF(d.class)).dDn();
            this.yRC = new u(this.cgL.yTx.getContext(), new bi(), this.cgL.getTalkerUserName(), this.cgL.dFu(), z);
            this.yRC.yKp = new u.a() {
                public final void Oo(int i) {
                    AppMethodBeat.i(31651);
                    ag.this.OD(i);
                    AppMethodBeat.o(31651);
                }
            };
            this.yRA = (ListView) this.cgL.findViewById(R.id.e6r);
            this.yRA.setVisibility(0);
            this.yRA.setAdapter(this.yRC);
            this.yRA.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(31652);
                    bi biVar = (bi) ag.this.yRC.getItem(i);
                    if (!(biVar == null || bo.isNullOrNil(biVar.field_talker))) {
                        ag.this.dEP();
                        ((i) ag.this.cgL.aF(i.class)).bd(biVar);
                        if (!ag.this.yRy) {
                            ag.this.yRy = true;
                            ag.this.cgL.yTz.setBottomViewVisible(true);
                            ag.this.cgL.yTy.dCC();
                        }
                        ag.this.cgL.yTz.dCA();
                        ag.this.cgL.yTz.setIsBottomShowAll(false);
                        ((h) ag.this.cgL.aF(h.class)).a(biVar.field_msgId, false, com.tencent.mm.ui.chatting.f.d.a.ACTION_POSITION);
                    }
                    AppMethodBeat.o(31652);
                }
            });
            this.yRA.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(31644);
                    ag.this.cgL.aqX();
                    AppMethodBeat.o(31644);
                    return false;
                }
            });
        }
        OD(-1);
        AppMethodBeat.o(31654);
    }

    public final void dEP() {
        AppMethodBeat.i(31655);
        ab.v("MicroMsg.ChattingUI.SearchComponent", "exit edit search mode");
        this.yRD = false;
        this.yRE = true;
        if (this.yRz != null) {
            this.yRz.setVisibility(8);
        }
        if (this.yRB != null) {
            this.yRB.setVisibility(8);
        }
        if (this.yRA != null) {
            this.yRA.setVisibility(8);
        }
        this.cgL.Or(0);
        this.cgL.aqX();
        AppMethodBeat.o(31655);
    }

    public final boolean dEQ() {
        return this.yRD;
    }

    public final void OD(int i) {
        AppMethodBeat.i(31656);
        ab.i("MicroMsg.ChattingUI.SearchComponent", "search result count %d, in edit mode %B, can report %B", Integer.valueOf(i), Boolean.valueOf(this.yRD), Boolean.valueOf(this.yRE));
        if (this.yRr || this.yRD) {
            if (this.yRE && i >= 0) {
                this.yRE = false;
                com.tencent.mm.plugin.report.service.h.pYm.e(10811, Integer.valueOf(2));
            }
            if (i > 0) {
                this.yRA.setVisibility(0);
                this.cgL.Or(8);
                this.yRz.setVisibility(8);
                this.yRB.setVisibility(8);
                AppMethodBeat.o(31656);
                return;
            } else if (i == 0) {
                this.yRA.setVisibility(8);
                this.cgL.Or(8);
                this.yRz.setVisibility(0);
                this.yRB.setVisibility(8);
                AppMethodBeat.o(31656);
                return;
            } else {
                this.yRA.setVisibility(8);
                this.cgL.Or(0);
                this.yRz.setVisibility(8);
                this.yRB.setVisibility(0);
                AppMethodBeat.o(31656);
                return;
            }
        }
        ab.d("MicroMsg.ChattingUI.SearchComponent", "not search now");
        AppMethodBeat.o(31656);
    }

    public final u dER() {
        return this.yRC;
    }

    public final boolean dES() {
        return this.yRs;
    }

    public final boolean dET() {
        return this.yRr;
    }

    public final boolean dEU() {
        return this.yRu;
    }

    public final boolean dEV() {
        return this.yRv;
    }

    public final boolean dEW() {
        return this.yRy;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(31657);
        super.onActivityResult(i, i2, intent);
        if (((h) this.cgL.aF(h.class)).isInEditMode() && this.yRD) {
            dEP();
        }
        AppMethodBeat.o(31657);
    }

    public final void dDh() {
        AppMethodBeat.i(31658);
        super.dDh();
        this.yRG = true;
        if (this.yRC != null) {
            this.yRC.bIf();
        }
        if (this.elS != null) {
            this.elS.clearFocus();
        }
        AppMethodBeat.o(31658);
    }

    public final void dxx() {
        AppMethodBeat.i(31659);
        this.yRr = this.cgL.yTx.getBooleanExtra("search_chat_content", false).booleanValue();
        this.yRs = this.cgL.yTx.getBooleanExtra("show_search_chat_content_result", false).booleanValue();
        this.yRx = this.cgL.yTx.getStringArrayList("highlight_keyword_list");
        this.yRw = this.cgL.yTx.getLongExtra("msg_local_id", -1);
        this.yRu = this.cgL.yTx.getBooleanExtra("from_global_search", false).booleanValue();
        this.yRv = this.cgL.yTx.getBooleanExtra("from_date_search", false).booleanValue();
        this.yRt = this.cgL.yTx.getBooleanExtra("img_gallery_enter_from_chatting_ui", false).booleanValue();
        AppMethodBeat.o(31659);
    }

    public final void dxy() {
        boolean z = true;
        AppMethodBeat.i(31660);
        if (this.yRw >= 0 && !this.yRG) {
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(31643);
                    if (!ag.this.yRG) {
                        ag.this.yRG = true;
                        ag.this.yRw = -1;
                        if (ag.this.cgL != null) {
                            ag.this.cgL.aWv();
                        }
                        ab.i("MicroMsg.ChattingUI.SearchComponent", "dismiss fts highlight");
                    }
                    AppMethodBeat.o(31643);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        if (this.yRr) {
            ab.i("MicroMsg.ChattingUI.SearchComponent", "[initSearchView]");
            com.tencent.mm.plugin.report.service.h.pYm.a(219, 11, 1, true);
            i.a(this.cgL.yTx, R.id.alp);
            this.yRq = this.cgL.findViewById(R.id.alq);
            this.yRB = this.cgL.findViewById(R.id.e6s);
            this.cgL.getListView().setFocusable(false);
            this.cgL.getListView().setFocusableInTouchMode(false);
            this.yRB.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                }
            });
            if (this.yRz == null) {
                i.a(this.cgL.yTx, R.id.all);
                this.yRz = (TextView) this.cgL.findViewById(R.id.av1);
            }
            boolean z2 = this.cgL.dFw() || ((d) this.cgL.aF(d.class)).dDn();
            this.yRC = new u(this.cgL.yTx.getContext(), new bi(), this.cgL.getTalkerUserName(), this.cgL.dFu(), z2);
            this.yRC.yKp = new u.a() {
                public final void Oo(int i) {
                    AppMethodBeat.i(31645);
                    ag.this.OD(i);
                    AppMethodBeat.o(31645);
                }
            };
            this.yRA = (ListView) this.cgL.findViewById(R.id.e6r);
            this.yRA.setAdapter(this.yRC);
            this.yRA.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(31646);
                    bi biVar = (bi) ag.this.yRC.getItem(i);
                    if (!(biVar == null || bo.isNullOrNil(biVar.field_talker))) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(10450, Integer.valueOf(1));
                        Intent intent = new Intent(ag.this.cgL.yTx.getContext(), ChattingUI.class);
                        intent.putExtra("Chat_User", biVar.field_talker);
                        intent.putExtra("finish_direct", true);
                        intent.putExtra("show_search_chat_content_result", false);
                        intent.putExtra("msg_local_id", biVar.field_msgId);
                        intent.putExtra("img_gallery_enter_from_chatting_ui", true);
                        ag.this.cgL.yTx.startActivity(intent);
                    }
                    AppMethodBeat.o(31646);
                }
            });
            this.yRA.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(31647);
                    ag.this.cgL.aqX();
                    AppMethodBeat.o(31647);
                    return false;
                }
            });
            this.elS = new o();
            this.elS.zHa = new b() {
                private int yRI = 0;

                public final void vO(String str) {
                    AppMethodBeat.i(31649);
                    if (bo.isNullOrNil(str)) {
                        this.yRI = 0;
                        ag.this.OD(-1);
                        AppMethodBeat.o(31649);
                        return;
                    }
                    if (str.length() > this.yRI) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(10451, Integer.valueOf(1));
                    }
                    this.yRI = str.length();
                    com.tencent.mm.plugin.report.service.h.pYm.e(10456, Integer.valueOf(1));
                    ag.this.yRC.vM(str);
                    AppMethodBeat.o(31649);
                }

                public final void apo() {
                    AppMethodBeat.i(31650);
                    new ak().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(31648);
                            ag.this.cgL.yTx.dBP();
                            AppMethodBeat.o(31648);
                        }
                    });
                    AppMethodBeat.o(31650);
                }

                public final void app() {
                }

                public final boolean vN(String str) {
                    return false;
                }

                public final void apq() {
                }

                public final void apr() {
                }
            };
            this.cgL.yTx.addSearchMenu(true, this.elS);
            this.elS.qQ(true);
        }
        if (this.yRs || this.yRu || this.yRv) {
            long longExtra = this.cgL.yTx.getLongExtra("msg_local_id", -1);
            h hVar = (h) this.cgL.aF(h.class);
            if (!this.yRu || this.yRv) {
                z = false;
            }
            hVar.a(longExtra, z, com.tencent.mm.ui.chatting.f.d.a.ACTION_POSITION);
        }
        AppMethodBeat.o(31660);
    }

    public final void dxB() {
        AppMethodBeat.i(31661);
        if (this.yRD) {
            dEP();
            ((i) this.cgL.aF(i.class)).dDO();
        }
        AppMethodBeat.o(31661);
    }
}
