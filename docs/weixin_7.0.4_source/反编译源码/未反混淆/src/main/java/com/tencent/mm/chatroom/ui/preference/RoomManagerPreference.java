package com.tencent.mm.chatroom.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.LinkedList;
import java.util.List;

public class RoomManagerPreference extends Preference {
    private List<ad> eom = new LinkedList();

    public RoomManagerPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(104471);
        AppMethodBeat.o(104471);
    }

    public RoomManagerPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(104472);
        AppMethodBeat.o(104472);
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(104473);
        super.onBindView(view);
        ((TextView) view.findViewById(R.id.cx)).setText(getTitle());
        ImageView imageView = (ImageView) view.findViewById(R.id.e3t);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.e3u);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.e3v);
        imageView.setVisibility(4);
        imageView2.setVisibility(4);
        imageView3.setVisibility(4);
        for (int i = 0; i < this.eom.size(); i++) {
            if (i == 0) {
                b.a(imageView, ((ad) this.eom.get(0)).field_username, 0.15f, false);
                imageView.setVisibility(0);
            } else if (1 == i) {
                b.a(imageView2, ((ad) this.eom.get(1)).field_username, 0.15f, false);
                imageView2.setVisibility(0);
            } else if (2 == i) {
                imageView3.setVisibility(0);
                b.a(imageView3, ((ad) this.eom.get(2)).field_username, 0.15f, false);
            }
        }
        AppMethodBeat.o(104473);
    }
}
