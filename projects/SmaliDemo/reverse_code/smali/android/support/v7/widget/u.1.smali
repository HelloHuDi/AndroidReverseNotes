.class public Landroid/support/v7/widget/u;
.super Landroid/widget/MultiAutoCompleteTextView;
.source ""

# interfaces
.implements La/b/c/g/s;


# static fields
.field private static final a:[I


# instance fields
.field private final b:Landroid/support/v7/widget/j;

.field private final c:Landroid/support/v7/widget/H;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .line 55
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, 0x1010176

    aput v2, v0, v1

    sput-object v0, Landroid/support/v7/widget/u;->a:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .line 67
    sget v0, La/b/d/a/a;->autoCompleteTextViewStyle:I

    invoke-direct {p0, p1, p2, v0}, Landroid/support/v7/widget/u;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 68
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .line 71
    invoke-static {p1}, Landroid/support/v7/widget/qa;->a(Landroid/content/Context;)Landroid/content/Context;

    move-result-object v0

    invoke-direct {p0, v0, p2, p3}, Landroid/widget/MultiAutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 73
    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, Landroid/support/v7/widget/u;->a:[I

    const/4 v2, 0x0

    invoke-static {v0, p2, v1, p3, v2}, Landroid/support/v7/widget/ta;->a(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/ta;

    move-result-object v0

    .line 75
    .local v0, "a":Landroid/support/v7/widget/ta;
    invoke-virtual {v0, v2}, Landroid/support/v7/widget/ta;->g(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 76
    invoke-virtual {v0, v2}, Landroid/support/v7/widget/ta;->b(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {p0, v1}, Landroid/widget/MultiAutoCompleteTextView;->setDropDownBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 78
    :cond_0
    invoke-virtual {v0}, Landroid/support/v7/widget/ta;->a()V

    .line 80
    new-instance v1, Landroid/support/v7/widget/j;

    invoke-direct {v1, p0}, Landroid/support/v7/widget/j;-><init>(Landroid/view/View;)V

    iput-object v1, p0, Landroid/support/v7/widget/u;->b:Landroid/support/v7/widget/j;

    .line 81
    iget-object v1, p0, Landroid/support/v7/widget/u;->b:Landroid/support/v7/widget/j;

    invoke-virtual {v1, p2, p3}, Landroid/support/v7/widget/j;->a(Landroid/util/AttributeSet;I)V

    .line 83
    new-instance v1, Landroid/support/v7/widget/H;

    invoke-direct {v1, p0}, Landroid/support/v7/widget/H;-><init>(Landroid/widget/TextView;)V

    iput-object v1, p0, Landroid/support/v7/widget/u;->c:Landroid/support/v7/widget/H;

    .line 84
    iget-object v1, p0, Landroid/support/v7/widget/u;->c:Landroid/support/v7/widget/H;

    invoke-virtual {v1, p2, p3}, Landroid/support/v7/widget/H;->a(Landroid/util/AttributeSet;I)V

    .line 85
    iget-object v1, p0, Landroid/support/v7/widget/u;->c:Landroid/support/v7/widget/H;

    invoke-virtual {v1}, Landroid/support/v7/widget/H;->a()V

    .line 86
    return-void
.end method


# virtual methods
.method protected drawableStateChanged()V
    .locals 1

    .line 167
    invoke-super {p0}, Landroid/widget/MultiAutoCompleteTextView;->drawableStateChanged()V

    .line 168
    iget-object v0, p0, Landroid/support/v7/widget/u;->b:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 169
    invoke-virtual {v0}, Landroid/support/v7/widget/j;->a()V

    .line 171
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/u;->c:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_1

    .line 172
    invoke-virtual {v0}, Landroid/support/v7/widget/H;->a()V

    .line 174
    :cond_1
    return-void
.end method

.method public getSupportBackgroundTintList()Landroid/content/res/ColorStateList;
    .locals 1

    .line 133
    iget-object v0, p0, Landroid/support/v7/widget/u;->b:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 134
    invoke-virtual {v0}, Landroid/support/v7/widget/j;->b()Landroid/content/res/ColorStateList;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method public getSupportBackgroundTintMode()Landroid/graphics/PorterDuff$Mode;
    .locals 1

    .line 161
    iget-object v0, p0, Landroid/support/v7/widget/u;->b:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 162
    invoke-virtual {v0}, Landroid/support/v7/widget/j;->c()Landroid/graphics/PorterDuff$Mode;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return-object v0
.end method

.method public onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;
    .locals 1
    .param p1, "outAttrs"    # Landroid/view/inputmethod/EditorInfo;

    .line 186
    invoke-super {p0, p1}, Landroid/widget/MultiAutoCompleteTextView;->onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;

    move-result-object v0

    invoke-static {v0, p1, p0}, Landroid/support/v7/widget/q;->a(Landroid/view/inputmethod/InputConnection;Landroid/view/inputmethod/EditorInfo;Landroid/view/View;)Landroid/view/inputmethod/InputConnection;

    return-object v0
.end method

.method public setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "background"    # Landroid/graphics/drawable/Drawable;

    .line 103
    invoke-super {p0, p1}, Landroid/widget/MultiAutoCompleteTextView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 104
    iget-object v0, p0, Landroid/support/v7/widget/u;->b:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 105
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/j;->a(Landroid/graphics/drawable/Drawable;)V

    .line 107
    :cond_0
    return-void
.end method

.method public setBackgroundResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 95
    invoke-super {p0, p1}, Landroid/widget/MultiAutoCompleteTextView;->setBackgroundResource(I)V

    .line 96
    iget-object v0, p0, Landroid/support/v7/widget/u;->b:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 97
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/j;->a(I)V

    .line 99
    :cond_0
    return-void
.end method

.method public setDropDownBackgroundResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 90
    invoke-virtual {p0}, Landroid/widget/MultiAutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, La/b/d/b/a/a;->b(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/widget/MultiAutoCompleteTextView;->setDropDownBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 91
    return-void
.end method

.method public setSupportBackgroundTintList(Landroid/content/res/ColorStateList;)V
    .locals 1
    .param p1, "tint"    # Landroid/content/res/ColorStateList;

    .line 118
    iget-object v0, p0, Landroid/support/v7/widget/u;->b:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 119
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/j;->b(Landroid/content/res/ColorStateList;)V

    .line 121
    :cond_0
    return-void
.end method

.method public setSupportBackgroundTintMode(Landroid/graphics/PorterDuff$Mode;)V
    .locals 1
    .param p1, "tintMode"    # Landroid/graphics/PorterDuff$Mode;

    .line 146
    iget-object v0, p0, Landroid/support/v7/widget/u;->b:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 147
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/j;->a(Landroid/graphics/PorterDuff$Mode;)V

    .line 149
    :cond_0
    return-void
.end method

.method public setTextAppearance(Landroid/content/Context;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resId"    # I

    .line 178
    invoke-super {p0, p1, p2}, Landroid/widget/MultiAutoCompleteTextView;->setTextAppearance(Landroid/content/Context;I)V

    .line 179
    iget-object v0, p0, Landroid/support/v7/widget/u;->c:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_0

    .line 180
    invoke-virtual {v0, p1, p2}, Landroid/support/v7/widget/H;->a(Landroid/content/Context;I)V

    .line 182
    :cond_0
    return-void
.end method
