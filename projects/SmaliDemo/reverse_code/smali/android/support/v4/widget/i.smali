.class public final Landroid/support/v4/widget/i;
.super Ljava/lang/Object;
.source ""


# direct methods
.method public static a(Landroid/widget/ListView;I)V
    .locals 3
    .param p0, "listView"    # Landroid/widget/ListView;
    .param p1, "y"    # I

    .line 37
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x13

    if-lt v0, v1, :cond_0

    .line 39
    invoke-virtual {p0, p1}, Landroid/widget/ListView;->scrollListBy(I)V

    goto :goto_0

    .line 42
    :cond_0
    invoke-virtual {p0}, Landroid/widget/ListView;->getFirstVisiblePosition()I

    move-result v0

    .line 43
    .local v0, "firstPosition":I
    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    .line 44
    return-void

    .line 47
    :cond_1
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 48
    .local v1, "firstView":Landroid/view/View;
    if-nez v1, :cond_2

    .line 49
    return-void

    .line 52
    :cond_2
    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v2

    sub-int/2addr v2, p1

    .line 53
    .local v2, "newTop":I
    invoke-virtual {p0, v0, v2}, Landroid/widget/ListView;->setSelectionFromTop(II)V

    .line 55
    .end local v0    # "firstPosition":I
    .end local v1    # "firstView":Landroid/view/View;
    .end local v2    # "newTop":I
    :goto_0
    return-void
.end method
