package com.tencent.mm.plugin.readerapp.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import com.tencent.mm.R;
import com.tencent.mm.model.bl;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public class ReaderItemListView extends ListView {
    private Context context;
    private LayoutInflater ezi;
    d jOb;
    List<bl> pFA = new ArrayList();
    a pFB;
    OnCreateContextMenuListener pFC;
    private DisplayMetrics pFD;
    int position = 0;
    int type = 0;

    class a extends BaseAdapter {

        class a {
            TextView gsf;
            ImageView iNr;
            ImageView jOX;
            View jPn;
            TextView ngn;
            TextView pFH;
            ProgressBar pFI;
            ProgressBar progressBar;

            a() {
            }
        }

        a() {
        }

        public final int getCount() {
            AppMethodBeat.i(76859);
            int size = ReaderItemListView.this.pFA.size();
            AppMethodBeat.o(76859);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(76860);
            Object obj = ReaderItemListView.this.pFA.get(i);
            AppMethodBeat.o(76860);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(76861);
            if (((bl) ReaderItemListView.this.pFA.get(i)).type == 20) {
                if (i == 0) {
                    String aan = ((bl) ReaderItemListView.this.pFA.get(i)).aan();
                    String digest = ((bl) ReaderItemListView.this.pFA.get(i)).getDigest();
                    if (bo.isNullOrNil(aan)) {
                        if (bo.isNullOrNil(digest)) {
                            AppMethodBeat.o(76861);
                            return 1;
                        }
                        AppMethodBeat.o(76861);
                        return 2;
                    } else if (bo.isNullOrNil(digest)) {
                        AppMethodBeat.o(76861);
                        return 3;
                    } else {
                        AppMethodBeat.o(76861);
                        return 0;
                    }
                }
                AppMethodBeat.o(76861);
                return 1;
            } else if (i == 0) {
                if (getCount() == 1) {
                    AppMethodBeat.o(76861);
                    return 8;
                }
                AppMethodBeat.o(76861);
                return 6;
            } else if (i == getCount() - 1) {
                AppMethodBeat.o(76861);
                return 7;
            } else {
                AppMethodBeat.o(76861);
                return 5;
            }
        }

        public final int getViewTypeCount() {
            return 9;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            a aVar;
            boolean z;
            Bitmap a;
            ViewGroup viewGroup2 = null;
            AppMethodBeat.i(76862);
            int itemViewType = getItemViewType(i);
            if (view == null) {
                switch (itemViewType) {
                    case 0:
                    case 3:
                        aVar = new a();
                        view = ReaderItemListView.this.ezi.inflate(R.layout.amo, null);
                        aVar.gsf = (TextView) view.findViewById(R.id.dum);
                        aVar.jOX = (ImageView) view.findViewById(R.id.duk);
                        aVar.progressBar = (ProgressBar) view.findViewById(R.id.dul);
                        view.setTag(aVar);
                        break;
                    case 1:
                        aVar = new a();
                        view = ReaderItemListView.this.ezi.inflate(R.layout.ams, null);
                        aVar.gsf = (TextView) view.findViewById(R.id.dux);
                        view.setTag(aVar);
                        break;
                    case 2:
                        aVar = new a();
                        view = ReaderItemListView.this.ezi.inflate(R.layout.amp, null);
                        aVar.gsf = (TextView) view.findViewById(R.id.dum);
                        aVar.pFH = (TextView) view.findViewById(R.id.dun);
                        view.setTag(aVar);
                        break;
                    case 4:
                        aVar = new a();
                        view = ReaderItemListView.this.ezi.inflate(R.layout.amv, null);
                        aVar.gsf = (TextView) view.findViewById(R.id.dum);
                        aVar.jOX = (ImageView) view.findViewById(R.id.duk);
                        aVar.progressBar = (ProgressBar) view.findViewById(R.id.dul);
                        aVar.ngn = (TextView) view.findViewById(R.id.dv7);
                        aVar.iNr = (ImageView) view.findViewById(R.id.dv5);
                        aVar.pFI = (ProgressBar) view.findViewById(R.id.dv6);
                        aVar.jPn = view.findViewById(R.id.dv4);
                        aVar.jPn.setBackgroundResource(R.drawable.ip);
                        view.setTag(aVar);
                        break;
                    case 5:
                        aVar = new a();
                        view = ReaderItemListView.this.ezi.inflate(R.layout.amw, null);
                        aVar.gsf = (TextView) view.findViewById(R.id.dum);
                        aVar.ngn = (TextView) view.findViewById(R.id.dv7);
                        aVar.iNr = (ImageView) view.findViewById(R.id.dv5);
                        aVar.pFI = (ProgressBar) view.findViewById(R.id.dv6);
                        aVar.jPn = view.findViewById(R.id.dv4);
                        aVar.jPn.setBackgroundResource(R.drawable.io);
                        view.setTag(aVar);
                        break;
                    case 6:
                        aVar = new a();
                        view = ReaderItemListView.this.ezi.inflate(R.layout.amy, null);
                        aVar.gsf = (TextView) view.findViewById(R.id.dum);
                        aVar.ngn = (TextView) view.findViewById(R.id.dv7);
                        aVar.iNr = (ImageView) view.findViewById(R.id.dv5);
                        aVar.pFI = (ProgressBar) view.findViewById(R.id.dv6);
                        aVar.jPn = view.findViewById(R.id.dv4);
                        aVar.jPn.setBackgroundResource(R.drawable.ip);
                        view.setTag(aVar);
                        break;
                    case 7:
                        aVar = new a();
                        view = ReaderItemListView.this.ezi.inflate(R.layout.amx, null);
                        aVar.gsf = (TextView) view.findViewById(R.id.dum);
                        aVar.ngn = (TextView) view.findViewById(R.id.dv7);
                        aVar.iNr = (ImageView) view.findViewById(R.id.dv5);
                        aVar.pFI = (ProgressBar) view.findViewById(R.id.dv6);
                        aVar.jPn = view.findViewById(R.id.dv4);
                        aVar.jPn.setBackgroundResource(R.drawable.in);
                        view.setTag(aVar);
                        Object viewGroup22 = aVar;
                        break;
                    case 8:
                        aVar = new a();
                        view = ReaderItemListView.this.ezi.inflate(R.layout.amw, null);
                        aVar.gsf = (TextView) view.findViewById(R.id.dum);
                        aVar.ngn = (TextView) view.findViewById(R.id.dv7);
                        aVar.iNr = (ImageView) view.findViewById(R.id.dv5);
                        aVar.pFI = (ProgressBar) view.findViewById(R.id.dv6);
                        aVar.jPn = view.findViewById(R.id.dv4);
                        aVar.jPn.setBackgroundResource(R.drawable.iq);
                        view.setTag(aVar);
                        break;
                }
                aVar = viewGroup22;
            } else {
                aVar = (a) view.getTag();
            }
            if (aVar != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            if (aVar.gsf != null) {
                z = true;
            } else {
                z = false;
            }
            Assert.assertTrue(z);
            aVar.gsf.setText(((bl) ReaderItemListView.this.pFA.get(i)).getTitle().trim());
            if (aVar.pFH != null) {
                aVar.pFH.setText(((bl) ReaderItemListView.this.pFA.get(i)).getDigest().trim());
            }
            if (aVar.ngn != null) {
                aVar.ngn.setText(((bl) ReaderItemListView.this.pFA.get(i)).aal().trim() + ReaderItemListView.this.getContext().getString(R.string.di0));
            }
            if (aVar.iNr != null) {
                a = x.a(new q(((bl) ReaderItemListView.this.pFA.get(i)).aam(), ((bl) ReaderItemListView.this.pFA.get(i)).type, "@S"));
                if (a != null) {
                    aVar.iNr.setImageBitmap(a);
                    aVar.iNr.setVisibility(0);
                    aVar.pFI.setVisibility(8);
                } else {
                    aVar.pFI.setVisibility(0);
                    aVar.iNr.setVisibility(8);
                }
            }
            if (aVar.jOX != null) {
                a = x.a(new q(((bl) ReaderItemListView.this.pFA.get(i)).aan(), ((bl) ReaderItemListView.this.pFA.get(i)).type, "@T"));
                if (a != null) {
                    aVar.jOX.setImageBitmap(a);
                    aVar.jOX.setVisibility(0);
                    aVar.progressBar.setVisibility(8);
                } else {
                    aVar.progressBar.setVisibility(0);
                    aVar.jOX.setVisibility(8);
                }
            }
            if (!(aVar.jPn == null || ReaderItemListView.this.pFC == null)) {
                aVar.jPn.setTag(Integer.valueOf(ReaderItemListView.this.position));
                aVar.jPn.setOnLongClickListener(new OnLongClickListener() {
                    public final boolean onLongClick(View view) {
                        AppMethodBeat.i(76857);
                        new j(ReaderItemListView.this.getContext()).b(view, ReaderItemListView.this.pFC, ReaderItemListView.this.jOb);
                        AppMethodBeat.o(76857);
                        return true;
                    }
                });
                aVar.jPn.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(76858);
                        int i = i;
                        Intent intent = new Intent();
                        intent.putExtra("mode", 1);
                        String url = ((bl) ReaderItemListView.this.pFA.get(i)).getUrl();
                        if (url.contains("?")) {
                            url = url + "&dt=2&cv=0x" + Integer.toHexString(com.tencent.mm.protocal.d.vxo) + "&w=" + ReaderItemListView.this.pFD.widthPixels;
                        } else {
                            url = url + "?dt=2&cv=0x" + Integer.toHexString(com.tencent.mm.protocal.d.vxo) + "&w=" + ReaderItemListView.this.pFD.widthPixels;
                        }
                        intent.putExtra("rawUrl", url);
                        intent.putExtra("webpageTitle", ((bl) ReaderItemListView.this.pFA.get(i)).getTitle());
                        intent.putExtra("title", ReaderItemListView.this.context.getString(R.string.cb4));
                        intent.putExtra("useJs", true);
                        intent.putExtra("vertical_scroll", true);
                        Bundle bundle = new Bundle();
                        if (((bl) ReaderItemListView.this.pFA.get(i)).type == 20) {
                            bundle.putInt("snsWebSource", 3);
                        } else {
                            bundle.putInt("snsWebSource", 2);
                        }
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("shortUrl", ((bl) ReaderItemListView.this.pFA.get(i)).aak());
                        intent.putExtra("type", ((bl) ReaderItemListView.this.pFA.get(i)).type);
                        intent.putExtra("tweetid", ((bl) ReaderItemListView.this.pFA.get(i)).aaj());
                        intent.putExtra("geta8key_username", "blogapp");
                        com.tencent.mm.plugin.readerapp.b.a.gkE.i(intent, ReaderItemListView.this.context);
                        AppMethodBeat.o(76858);
                    }
                });
            }
            AppMethodBeat.o(76862);
            return view;
        }
    }

    public ReaderItemListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(76863);
        init(context);
        AppMethodBeat.o(76863);
    }

    public ReaderItemListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(76864);
        init(context);
        AppMethodBeat.o(76864);
    }

    private void init(Context context) {
        boolean z = false;
        AppMethodBeat.i(76865);
        this.context = context;
        this.ezi = v.hu(context);
        this.type = ((Activity) context).getIntent().getIntExtra("type", 0);
        if (bl.kG(this.type) != null) {
            z = true;
        }
        Assert.assertTrue(z);
        this.pFD = getResources().getDisplayMetrics();
        this.pFB = new a();
        setAdapter(this.pFB);
        AppMethodBeat.o(76865);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(76866);
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(536870911, android.support.v4.widget.j.INVALID_ID));
        AppMethodBeat.o(76866);
    }
}
