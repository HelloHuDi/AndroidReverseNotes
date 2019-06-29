.class public Landroid/support/v7/widget/l;
.super Landroid/widget/CheckBox;
.source ""

# interfaces
.implements Landroid/support/v4/widget/n;


# instance fields
.field private final a:Landroid/support/v7/widget/n;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .line 59
    sget v0, La/b/d/a/a;->checkboxStyle:I

    invoke-direct {p0, p1, p2, v0}, Landroid/support/v7/widget/l;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 60
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .line 63
    invoke-static {p1}, Landroid/support/v7/widget/qa;->a(Landroid/content/Context;)Landroid/content/Context;

    move-result-object v0

    invoke-direct {p0, v0, p2, p3}, Landroid/widget/CheckBox;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 64
    new-instance v0, Landroid/support/v7/widget/n;

    invoke-direct {v0, p0}, Landroid/support/v7/widget/n;-><init>(Landroid/widget/CompoundButton;)V

    iput-object v0, p0, Landroid/support/v7/widget/l;->a:Landroid/support/v7/widget/n;

    .line 65
    iget-object v0, p0, Landroid/support/v7/widget/l;->a:Landroid/support/v7/widget/n;

    invoke-virtual {v0, p2, p3}, Landroid/support/v7/widget/n;->a(Landroid/util/AttributeSet;I)V

    .line 66
    return-void
.end method


# virtual methods
.method public getCompoundPaddingLeft()I
    .locals 2

    .line 83
    invoke-super {p0}, Landroid/widget/CheckBox;->getCompoundPaddingLeft()I

    move-result v0

    .line 84
    .local v0, "value":I
    iget-object v1, p0, Landroid/support/v7/widget/l;->a:Landroid/support/v7/widget/n;

    if-eqz v1, :cond_0

    .line 85
    invoke-virtual {v1, v0}, Landroid/support/v7/widget/n;->a(I)I

    move-result v1

    goto :goto_0

    :cond_0
    move v1, v0

    :goto_0
    return v1
.end method

.method public getSupportButtonTintList()Landroid/content/res/ColorStateList;
    .locals 1

    .line 109
    iget-object v0, p0, Landroid/support/v7/widget/l;->a:Landroid/support/v7/widget/n;

    if-eqz v0, :cond_0

    .line 110
    invoke-virtual {v0}, Landroid/support/v7/widget/n;->b()Landroid/content/res/ColorStateList;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method public getSupportButtonTintMode()Landroid/graphics/PorterDuff$Mode;
    .locals 1

    .line 134
    iget-object v0, p0, Landroid/support/v7/widget/l;->a:Landroid/support/v7/widget/n;

    if-eqz v0, :cond_0

    .line 135
    invoke-virtual {v0}, Landroid/support/v7/widget/n;->c()Landroid/graphics/PorterDuff$Mode;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method public setButtonDrawable(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 78
    invoke-virtual {p0}, Landroid/widget/CheckBox;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, La/b/d/b/a/a;->b(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/support/v7/widget/l;->setButtonDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 79
    return-void
.end method

.method public setButtonDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "buttonDrawable"    # Landroid/graphics/drawable/Drawable;

    .line 70
    invoke-super {p0, p1}, Landroid/widget/CheckBox;->setButtonDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 71
    iget-object v0, p0, Landroid/support/v7/widget/l;->a:Landroid/support/v7/widget/n;

    if-eqz v0, :cond_0

    .line 72
    invoke-virtual {v0}, Landroid/support/v7/widget/n;->d()V

    .line 74
    :cond_0
    return-void
.end method

.method public setSupportButtonTintList(Landroid/content/res/ColorStateList;)V
    .locals 1
    .param p1, "tint"    # Landroid/content/res/ColorStateList;

    .line 96
    iget-object v0, p0, Landroid/support/v7/widget/l;->a:Landroid/support/v7/widget/n;

    if-eqz v0, :cond_0

    .line 97
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/n;->a(Landroid/content/res/ColorStateList;)V

    .line 99
    :cond_0
    return-void
.end method

.method public setSupportButtonTintMode(Landroid/graphics/PorterDuff$Mode;)V
    .locals 1
    .param p1, "tintMode"    # Landroid/graphics/PorterDuff$Mode;

    .line 121
    iget-object v0, p0, Landroid/support/v7/widget/l;->a:Landroid/support/v7/widget/n;

    if-eqz v0, :cond_0

    .line 122
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/n;->a(Landroid/graphics/PorterDuff$Mode;)V

    .line 124
    :cond_0
    return-void
.end method
