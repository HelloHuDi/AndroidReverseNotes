package com.tencent.p177mm.plugin.readerapp.p490ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C32779bl;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.plugin.readerapp.p1654b.C46155a;
import com.tencent.p177mm.pluginsdk.model.C30080q;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderItemListView */
public class ReaderItemListView extends ListView {
    private Context context;
    private LayoutInflater ezi;
    C5279d jOb;
    List<C32779bl> pFA = new ArrayList();
    C28806a pFB;
    OnCreateContextMenuListener pFC;
    private DisplayMetrics pFD;
    int position = 0;
    int type = 0;

    /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderItemListView$a */
    class C28806a extends BaseAdapter {

        /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderItemListView$a$a */
        class C21573a {
            TextView gsf;
            ImageView iNr;
            ImageView jOX;
            View jPn;
            TextView ngn;
            TextView pFH;
            ProgressBar pFI;
            ProgressBar progressBar;

            C21573a() {
            }
        }

        /* renamed from: com.tencent.mm.plugin.readerapp.ui.ReaderItemListView$a$1 */
        class C288081 implements OnLongClickListener {
            C288081() {
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.m2504i(76857);
                new C46696j(ReaderItemListView.this.getContext()).mo75009b(view, ReaderItemListView.this.pFC, ReaderItemListView.this.jOb);
                AppMethodBeat.m2505o(76857);
                return true;
            }
        }

        C28806a() {
        }

        public final int getCount() {
            AppMethodBeat.m2504i(76859);
            int size = ReaderItemListView.this.pFA.size();
            AppMethodBeat.m2505o(76859);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(76860);
            Object obj = ReaderItemListView.this.pFA.get(i);
            AppMethodBeat.m2505o(76860);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(76861);
            if (((C32779bl) ReaderItemListView.this.pFA.get(i)).type == 20) {
                if (i == 0) {
                    String aan = ((C32779bl) ReaderItemListView.this.pFA.get(i)).aan();
                    String digest = ((C32779bl) ReaderItemListView.this.pFA.get(i)).getDigest();
                    if (C5046bo.isNullOrNil(aan)) {
                        if (C5046bo.isNullOrNil(digest)) {
                            AppMethodBeat.m2505o(76861);
                            return 1;
                        }
                        AppMethodBeat.m2505o(76861);
                        return 2;
                    } else if (C5046bo.isNullOrNil(digest)) {
                        AppMethodBeat.m2505o(76861);
                        return 3;
                    } else {
                        AppMethodBeat.m2505o(76861);
                        return 0;
                    }
                }
                AppMethodBeat.m2505o(76861);
                return 1;
            } else if (i == 0) {
                if (getCount() == 1) {
                    AppMethodBeat.m2505o(76861);
                    return 8;
                }
                AppMethodBeat.m2505o(76861);
                return 6;
            } else if (i == getCount() - 1) {
                AppMethodBeat.m2505o(76861);
                return 7;
            } else {
                AppMethodBeat.m2505o(76861);
                return 5;
            }
        }

        public final int getViewTypeCount() {
            return 9;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            C21573a c21573a;
            boolean z;
            Bitmap a;
            ViewGroup viewGroup2 = null;
            AppMethodBeat.m2504i(76862);
            int itemViewType = getItemViewType(i);
            if (view == null) {
                switch (itemViewType) {
                    case 0:
                    case 3:
                        c21573a = new C21573a();
                        view = ReaderItemListView.this.ezi.inflate(2130970445, null);
                        c21573a.gsf = (TextView) view.findViewById(2131826819);
                        c21573a.jOX = (ImageView) view.findViewById(2131826817);
                        c21573a.progressBar = (ProgressBar) view.findViewById(2131826818);
                        view.setTag(c21573a);
                        break;
                    case 1:
                        c21573a = new C21573a();
                        view = ReaderItemListView.this.ezi.inflate(2130970449, null);
                        c21573a.gsf = (TextView) view.findViewById(2131826830);
                        view.setTag(c21573a);
                        break;
                    case 2:
                        c21573a = new C21573a();
                        view = ReaderItemListView.this.ezi.inflate(2130970446, null);
                        c21573a.gsf = (TextView) view.findViewById(2131826819);
                        c21573a.pFH = (TextView) view.findViewById(2131826820);
                        view.setTag(c21573a);
                        break;
                    case 4:
                        c21573a = new C21573a();
                        view = ReaderItemListView.this.ezi.inflate(2130970452, null);
                        c21573a.gsf = (TextView) view.findViewById(2131826819);
                        c21573a.jOX = (ImageView) view.findViewById(2131826817);
                        c21573a.progressBar = (ProgressBar) view.findViewById(2131826818);
                        c21573a.ngn = (TextView) view.findViewById(2131826840);
                        c21573a.iNr = (ImageView) view.findViewById(2131826838);
                        c21573a.pFI = (ProgressBar) view.findViewById(2131826839);
                        c21573a.jPn = view.findViewById(2131826837);
                        c21573a.jPn.setBackgroundResource(C25738R.drawable.f6577ip);
                        view.setTag(c21573a);
                        break;
                    case 5:
                        c21573a = new C21573a();
                        view = ReaderItemListView.this.ezi.inflate(2130970453, null);
                        c21573a.gsf = (TextView) view.findViewById(2131826819);
                        c21573a.ngn = (TextView) view.findViewById(2131826840);
                        c21573a.iNr = (ImageView) view.findViewById(2131826838);
                        c21573a.pFI = (ProgressBar) view.findViewById(2131826839);
                        c21573a.jPn = view.findViewById(2131826837);
                        c21573a.jPn.setBackgroundResource(C25738R.drawable.f6576io);
                        view.setTag(c21573a);
                        break;
                    case 6:
                        c21573a = new C21573a();
                        view = ReaderItemListView.this.ezi.inflate(2130970455, null);
                        c21573a.gsf = (TextView) view.findViewById(2131826819);
                        c21573a.ngn = (TextView) view.findViewById(2131826840);
                        c21573a.iNr = (ImageView) view.findViewById(2131826838);
                        c21573a.pFI = (ProgressBar) view.findViewById(2131826839);
                        c21573a.jPn = view.findViewById(2131826837);
                        c21573a.jPn.setBackgroundResource(C25738R.drawable.f6577ip);
                        view.setTag(c21573a);
                        break;
                    case 7:
                        c21573a = new C21573a();
                        view = ReaderItemListView.this.ezi.inflate(2130970454, null);
                        c21573a.gsf = (TextView) view.findViewById(2131826819);
                        c21573a.ngn = (TextView) view.findViewById(2131826840);
                        c21573a.iNr = (ImageView) view.findViewById(2131826838);
                        c21573a.pFI = (ProgressBar) view.findViewById(2131826839);
                        c21573a.jPn = view.findViewById(2131826837);
                        c21573a.jPn.setBackgroundResource(C25738R.drawable.f6575in);
                        view.setTag(c21573a);
                        Object viewGroup22 = c21573a;
                        break;
                    case 8:
                        c21573a = new C21573a();
                        view = ReaderItemListView.this.ezi.inflate(2130970453, null);
                        c21573a.gsf = (TextView) view.findViewById(2131826819);
                        c21573a.ngn = (TextView) view.findViewById(2131826840);
                        c21573a.iNr = (ImageView) view.findViewById(2131826838);
                        c21573a.pFI = (ProgressBar) view.findViewById(2131826839);
                        c21573a.jPn = view.findViewById(2131826837);
                        c21573a.jPn.setBackgroundResource(C25738R.drawable.f6578iq);
                        view.setTag(c21573a);
                        break;
                }
                c21573a = viewGroup22;
            } else {
                c21573a = (C21573a) view.getTag();
            }
            if (c21573a != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (c21573a.gsf != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            c21573a.gsf.setText(((C32779bl) ReaderItemListView.this.pFA.get(i)).getTitle().trim());
            if (c21573a.pFH != null) {
                c21573a.pFH.setText(((C32779bl) ReaderItemListView.this.pFA.get(i)).getDigest().trim());
            }
            if (c21573a.ngn != null) {
                c21573a.ngn.setText(((C32779bl) ReaderItemListView.this.pFA.get(i)).aal().trim() + ReaderItemListView.this.getContext().getString(C25738R.string.di0));
            }
            if (c21573a.iNr != null) {
                a = C18764x.m29325a(new C30080q(((C32779bl) ReaderItemListView.this.pFA.get(i)).aam(), ((C32779bl) ReaderItemListView.this.pFA.get(i)).type, "@S"));
                if (a != null) {
                    c21573a.iNr.setImageBitmap(a);
                    c21573a.iNr.setVisibility(0);
                    c21573a.pFI.setVisibility(8);
                } else {
                    c21573a.pFI.setVisibility(0);
                    c21573a.iNr.setVisibility(8);
                }
            }
            if (c21573a.jOX != null) {
                a = C18764x.m29325a(new C30080q(((C32779bl) ReaderItemListView.this.pFA.get(i)).aan(), ((C32779bl) ReaderItemListView.this.pFA.get(i)).type, "@T"));
                if (a != null) {
                    c21573a.jOX.setImageBitmap(a);
                    c21573a.jOX.setVisibility(0);
                    c21573a.progressBar.setVisibility(8);
                } else {
                    c21573a.progressBar.setVisibility(0);
                    c21573a.jOX.setVisibility(8);
                }
            }
            if (!(c21573a.jPn == null || ReaderItemListView.this.pFC == null)) {
                c21573a.jPn.setTag(Integer.valueOf(ReaderItemListView.this.position));
                c21573a.jPn.setOnLongClickListener(new C288081());
                c21573a.jPn.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(76858);
                        int i = i;
                        Intent intent = new Intent();
                        intent.putExtra("mode", 1);
                        String url = ((C32779bl) ReaderItemListView.this.pFA.get(i)).getUrl();
                        if (url.contains("?")) {
                            url = url + "&dt=2&cv=0x" + Integer.toHexString(C7243d.vxo) + "&w=" + ReaderItemListView.this.pFD.widthPixels;
                        } else {
                            url = url + "?dt=2&cv=0x" + Integer.toHexString(C7243d.vxo) + "&w=" + ReaderItemListView.this.pFD.widthPixels;
                        }
                        intent.putExtra("rawUrl", url);
                        intent.putExtra("webpageTitle", ((C32779bl) ReaderItemListView.this.pFA.get(i)).getTitle());
                        intent.putExtra("title", ReaderItemListView.this.context.getString(C25738R.string.cb4));
                        intent.putExtra("useJs", true);
                        intent.putExtra("vertical_scroll", true);
                        Bundle bundle = new Bundle();
                        if (((C32779bl) ReaderItemListView.this.pFA.get(i)).type == 20) {
                            bundle.putInt("snsWebSource", 3);
                        } else {
                            bundle.putInt("snsWebSource", 2);
                        }
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("shortUrl", ((C32779bl) ReaderItemListView.this.pFA.get(i)).aak());
                        intent.putExtra("type", ((C32779bl) ReaderItemListView.this.pFA.get(i)).type);
                        intent.putExtra("tweetid", ((C32779bl) ReaderItemListView.this.pFA.get(i)).aaj());
                        intent.putExtra("geta8key_username", "blogapp");
                        C46155a.gkE.mo38924i(intent, ReaderItemListView.this.context);
                        AppMethodBeat.m2505o(76858);
                    }
                });
            }
            AppMethodBeat.m2505o(76862);
            return view;
        }
    }

    public ReaderItemListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(76863);
        init(context);
        AppMethodBeat.m2505o(76863);
    }

    public ReaderItemListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(76864);
        init(context);
        AppMethodBeat.m2505o(76864);
    }

    private void init(Context context) {
        boolean z = false;
        AppMethodBeat.m2504i(76865);
        this.context = context;
        this.ezi = C5616v.m8409hu(context);
        this.type = ((Activity) context).getIntent().getIntExtra("type", 0);
        if (C32779bl.m53547kG(this.type) != null) {
            z = true;
        }
        Assert.assertTrue(z);
        this.pFD = getResources().getDisplayMetrics();
        this.pFB = new C28806a();
        setAdapter(this.pFB);
        AppMethodBeat.m2505o(76865);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(76866);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, C8415j.INVALID_ID));
        AppMethodBeat.m2505o(76866);
    }
}
