.class Landroid/support/v7/widget/q;
.super Ljava/lang/Object;
.source ""


# direct methods
.method static a(Landroid/view/inputmethod/InputConnection;Landroid/view/inputmethod/EditorInfo;Landroid/view/View;)Landroid/view/inputmethod/InputConnection;
    .locals 2
    .param p0, "ic"    # Landroid/view/inputmethod/InputConnection;
    .param p1, "outAttrs"    # Landroid/view/inputmethod/EditorInfo;
    .param p2, "view"    # Landroid/view/View;

    .line 28
    if-eqz p0, :cond_1

    iget-object v0, p1, Landroid/view/inputmethod/EditorInfo;->hintText:Ljava/lang/CharSequence;

    if-nez v0, :cond_1

    .line 31
    invoke-virtual {p2}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 32
    .local v0, "parent":Landroid/view/ViewParent;
    :goto_0
    instance-of v1, v0, Landroid/view/View;

    if-eqz v1, :cond_1

    .line 33
    instance-of v1, v0, Landroid/support/v7/widget/Ia;

    if-eqz v1, :cond_0

    .line 34
    move-object v1, v0

    check-cast v1, Landroid/support/v7/widget/Ia;

    invoke-interface {v1}, Landroid/support/v7/widget/Ia;->a()Ljava/lang/CharSequence;

    move-result-object v1

    iput-object v1, p1, Landroid/view/inputmethod/EditorInfo;->hintText:Ljava/lang/CharSequence;

    .line 35
    goto :goto_1

    .line 37
    :cond_0
    invoke-interface {v0}, Landroid/view/ViewParent;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    goto :goto_0

    .line 40
    .end local v0    # "parent":Landroid/view/ViewParent;
    :cond_1
    :goto_1
    return-object p0
.end method
