package com.tencent.p177mm.chatroom.p216ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.chatroom.ui.preference.RoomManagerPreference */
public class RoomManagerPreference extends Preference {
    private List<C7616ad> eom = new LinkedList();

    public RoomManagerPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(104471);
        AppMethodBeat.m2505o(104471);
    }

    public RoomManagerPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(104472);
        AppMethodBeat.m2505o(104472);
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(104473);
        super.onBindView(view);
        ((TextView) view.findViewById(2131820678)).setText(getTitle());
        ImageView imageView = (ImageView) view.findViewById(2131827159);
        ImageView imageView2 = (ImageView) view.findViewById(2131827160);
        ImageView imageView3 = (ImageView) view.findViewById(2131827161);
        imageView.setVisibility(4);
        imageView2.setVisibility(4);
        imageView3.setVisibility(4);
        for (int i = 0; i < this.eom.size(); i++) {
            if (i == 0) {
                C40460b.m69433a(imageView, ((C7616ad) this.eom.get(0)).field_username, 0.15f, false);
                imageView.setVisibility(0);
            } else if (1 == i) {
                C40460b.m69433a(imageView2, ((C7616ad) this.eom.get(1)).field_username, 0.15f, false);
                imageView2.setVisibility(0);
            } else if (2 == i) {
                imageView3.setVisibility(0);
                C40460b.m69433a(imageView3, ((C7616ad) this.eom.get(2)).field_username, 0.15f, false);
            }
        }
        AppMethodBeat.m2505o(104473);
    }
}
