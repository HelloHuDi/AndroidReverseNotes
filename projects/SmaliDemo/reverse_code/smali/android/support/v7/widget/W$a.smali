.class public Landroid/support/v7/widget/W$a;
.super Landroid/support/v7/widget/N;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/widget/W;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "a"
.end annotation


# instance fields
.field final o:I

.field final p:I

.field private q:Landroid/support/v7/widget/V;

.field private r:Landroid/view/MenuItem;


# direct methods
.method public constructor <init>(Landroid/content/Context;Z)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "hijackFocus"    # Z

    .line 138
    invoke-direct {p0, p1, p2}, Landroid/support/v7/widget/N;-><init>(Landroid/content/Context;Z)V

    .line 140
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 141
    .local v0, "res":Landroid/content/res/Resources;
    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v1

    .line 142
    .local v1, "config":Landroid/content/res/Configuration;
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x15

    const/16 v4, 0x16

    const/16 v5, 0x11

    if-lt v2, v5, :cond_0

    const/4 v2, 0x1

    .line 143
    invoke-virtual {v1}, Landroid/content/res/Configuration;->getLayoutDirection()I

    move-result v5

    if-ne v2, v5, :cond_0

    .line 144
    iput v3, p0, Landroid/support/v7/widget/W$a;->o:I

    .line 145
    iput v4, p0, Landroid/support/v7/widget/W$a;->p:I

    goto :goto_0

    .line 147
    :cond_0
    iput v4, p0, Landroid/support/v7/widget/W$a;->o:I

    .line 148
    iput v3, p0, Landroid/support/v7/widget/W$a;->p:I

    .line 150
    :goto_0
    return-void
.end method


# virtual methods
.method public bridge synthetic a(IIIII)I
    .locals 0

    .line 129
    invoke-super/range {p0 .. p5}, Landroid/support/v7/widget/N;->a(IIIII)I

    move-result p1

    return p1
.end method

.method public bridge synthetic a(Landroid/view/MotionEvent;I)Z
    .locals 0

    .line 129
    invoke-super {p0, p1, p2}, Landroid/support/v7/widget/N;->a(Landroid/view/MotionEvent;I)Z

    move-result p1

    return p1
.end method

.method public bridge synthetic hasFocus()Z
    .locals 1

    .line 129
    invoke-super {p0}, Landroid/support/v7/widget/N;->hasFocus()Z

    move-result v0

    return v0
.end method

.method public bridge synthetic hasWindowFocus()Z
    .locals 1

    .line 129
    invoke-super {p0}, Landroid/support/v7/widget/N;->hasWindowFocus()Z

    move-result v0

    return v0
.end method

.method public bridge synthetic isFocused()Z
    .locals 1

    .line 129
    invoke-super {p0}, Landroid/support/v7/widget/N;->isFocused()Z

    move-result v0

    return v0
.end method

.method public bridge synthetic isInTouchMode()Z
    .locals 1

    .line 129
    invoke-super {p0}, Landroid/support/v7/widget/N;->isInTouchMode()Z

    move-result v0

    return v0
.end method

.method public onHoverEvent(Landroid/view/MotionEvent;)Z
    .locals 7
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .line 184
    iget-object v0, p0, Landroid/support/v7/widget/W$a;->q:Landroid/support/v7/widget/V;

    if-eqz v0, :cond_3

    .line 188
    invoke-virtual {p0}, Landroid/widget/ListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    .line 189
    .local v0, "adapter":Landroid/widget/ListAdapter;
    instance-of v1, v0, Landroid/widget/HeaderViewListAdapter;

    if-eqz v1, :cond_0

    .line 190
    move-object v1, v0

    check-cast v1, Landroid/widget/HeaderViewListAdapter;

    .line 191
    .local v1, "headerAdapter":Landroid/widget/HeaderViewListAdapter;
    invoke-virtual {v1}, Landroid/widget/HeaderViewListAdapter;->getHeadersCount()I

    move-result v2

    .line 192
    .local v2, "headersCount":I
    invoke-virtual {v1}, Landroid/widget/HeaderViewListAdapter;->getWrappedAdapter()Landroid/widget/ListAdapter;

    move-result-object v3

    move-object v1, v3

    check-cast v1, Landroid/support/v7/view/menu/k;

    .line 193
    .local v1, "menuAdapter":Landroid/support/v7/view/menu/k;
    goto :goto_0

    .line 194
    .end local v1    # "menuAdapter":Landroid/support/v7/view/menu/k;
    .end local v2    # "headersCount":I
    :cond_0
    const/4 v2, 0x0

    .line 195
    .restart local v2    # "headersCount":I
    move-object v1, v0

    check-cast v1, Landroid/support/v7/view/menu/k;

    .line 199
    .restart local v1    # "menuAdapter":Landroid/support/v7/view/menu/k;
    :goto_0
    const/4 v3, 0x0

    .line 200
    .local v3, "menuItem":Landroid/view/MenuItem;
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v4

    const/16 v5, 0xa

    if-eq v4, v5, :cond_1

    .line 201
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v4

    float-to-int v4, v4

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v5

    float-to-int v5, v5

    invoke-virtual {p0, v4, v5}, Landroid/widget/ListView;->pointToPosition(II)I

    move-result v4

    .line 202
    .local v4, "position":I
    const/4 v5, -0x1

    if-eq v4, v5, :cond_1

    .line 203
    sub-int v5, v4, v2

    .line 204
    .local v5, "itemPosition":I
    if-ltz v5, :cond_1

    invoke-virtual {v1}, Landroid/support/v7/view/menu/k;->getCount()I

    move-result v6

    if-ge v5, v6, :cond_1

    .line 205
    invoke-virtual {v1, v5}, Landroid/support/v7/view/menu/k;->getItem(I)Landroid/support/v7/view/menu/p;

    move-result-object v3

    .line 210
    .end local v4    # "position":I
    .end local v5    # "itemPosition":I
    :cond_1
    iget-object v4, p0, Landroid/support/v7/widget/W$a;->r:Landroid/view/MenuItem;

    .line 211
    .local v4, "oldMenuItem":Landroid/view/MenuItem;
    if-eq v4, v3, :cond_3

    .line 212
    invoke-virtual {v1}, Landroid/support/v7/view/menu/k;->b()Landroid/support/v7/view/menu/l;

    move-result-object v5

    .line 213
    .local v5, "menu":Landroid/support/v7/view/menu/l;
    if-eqz v4, :cond_2

    .line 214
    iget-object v6, p0, Landroid/support/v7/widget/W$a;->q:Landroid/support/v7/widget/V;

    invoke-interface {v6, v5, v4}, Landroid/support/v7/widget/V;->b(Landroid/support/v7/view/menu/l;Landroid/view/MenuItem;)V

    .line 217
    :cond_2
    iput-object v3, p0, Landroid/support/v7/widget/W$a;->r:Landroid/view/MenuItem;

    .line 219
    if-eqz v3, :cond_3

    .line 220
    iget-object v6, p0, Landroid/support/v7/widget/W$a;->q:Landroid/support/v7/widget/V;

    invoke-interface {v6, v5, v3}, Landroid/support/v7/widget/V;->a(Landroid/support/v7/view/menu/l;Landroid/view/MenuItem;)V

    .line 225
    .end local v0    # "adapter":Landroid/widget/ListAdapter;
    .end local v1    # "menuAdapter":Landroid/support/v7/view/menu/k;
    .end local v2    # "headersCount":I
    .end local v3    # "menuItem":Landroid/view/MenuItem;
    .end local v4    # "oldMenuItem":Landroid/view/MenuItem;
    .end local v5    # "menu":Landroid/support/v7/view/menu/l;
    :cond_3
    invoke-super {p0, p1}, Landroid/support/v7/widget/N;->onHoverEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 5
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .line 162
    invoke-virtual {p0}, Landroid/widget/ListView;->getSelectedView()Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/view/menu/ListMenuItemView;

    .line 163
    .local v0, "selectedItem":Landroid/support/v7/view/menu/ListMenuItemView;
    const/4 v1, 0x1

    if-eqz v0, :cond_1

    iget v2, p0, Landroid/support/v7/widget/W$a;->o:I

    if-ne p1, v2, :cond_1

    .line 164
    invoke-virtual {v0}, Landroid/widget/LinearLayout;->isEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Landroid/support/v7/view/menu/ListMenuItemView;->getItemData()Landroid/support/v7/view/menu/p;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v7/view/menu/p;->hasSubMenu()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 165
    nop

    .line 167
    invoke-virtual {p0}, Landroid/widget/ListView;->getSelectedItemPosition()I

    move-result v2

    .line 168
    invoke-virtual {p0}, Landroid/widget/ListView;->getSelectedItemId()J

    move-result-wide v3

    .line 165
    invoke-virtual {p0, v0, v2, v3, v4}, Landroid/widget/ListView;->performItemClick(Landroid/view/View;IJ)Z

    .line 170
    :cond_0
    return v1

    .line 171
    :cond_1
    if-eqz v0, :cond_2

    iget v2, p0, Landroid/support/v7/widget/W$a;->p:I

    if-ne p1, v2, :cond_2

    .line 172
    const/4 v2, -0x1

    invoke-virtual {p0, v2}, Landroid/widget/ListView;->setSelection(I)V

    .line 175
    invoke-virtual {p0}, Landroid/widget/ListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v2

    check-cast v2, Landroid/support/v7/view/menu/k;

    invoke-virtual {v2}, Landroid/support/v7/view/menu/k;->b()Landroid/support/v7/view/menu/l;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/support/v7/view/menu/l;->a(Z)V

    .line 176
    return v1

    .line 178
    :cond_2
    invoke-super {p0, p1, p2}, Landroid/widget/ListView;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v1

    return v1
.end method

.method public bridge synthetic onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 0

    .line 129
    invoke-super {p0, p1}, Landroid/support/v7/widget/N;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result p1

    return p1
.end method

.method public setHoverListener(Landroid/support/v7/widget/V;)V
    .locals 0
    .param p1, "hoverListener"    # Landroid/support/v7/widget/V;

    .line 153
    iput-object p1, p0, Landroid/support/v7/widget/W$a;->q:Landroid/support/v7/widget/V;

    .line 154
    return-void
.end method

.method public bridge synthetic setSelector(Landroid/graphics/drawable/Drawable;)V
    .locals 0

    .line 129
    invoke-super {p0, p1}, Landroid/support/v7/widget/N;->setSelector(Landroid/graphics/drawable/Drawable;)V

    return-void
.end method
