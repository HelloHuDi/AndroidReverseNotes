.class public Landroid/support/v7/widget/i;
.super Landroid/widget/AutoCompleteTextView;
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

    .line 58
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, 0x1010176

    aput v2, v0, v1

    sput-object v0, Landroid/support/v7/widget/i;->a:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 66
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/support/v7/widget/i;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 67
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .line 70
    sget v0, La/b/d/a/a;->autoCompleteTextViewStyle:I

    invoke-direct {p0, p1, p2, v0}, Landroid/support/v7/widget/i;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 71
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .line 74
    invoke-static {p1}, Landroid/support/v7/widget/qa;->a(Landroid/content/Context;)Landroid/content/Context;

    move-result-object v0

    invoke-direct {p0, v0, p2, p3}, Landroid/widget/AutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 76
    invoke-virtual {p0}, Landroid/widget/AutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget-object v1, Landroid/support/v7/widget/i;->a:[I

    const/4 v2, 0x0

    invoke-static {v0, p2, v1, p3, v2}, Landroid/support/v7/widget/ta;->a(Landroid/content/Context;Landroid/util/AttributeSet;[III)Landroid/support/v7/widget/ta;

    move-result-object v0

    .line 78
    .local v0, "a":Landroid/support/v7/widget/ta;
    invoke-virtual {v0, v2}, Landroid/support/v7/widget/ta;->g(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 79
    invoke-virtual {v0, v2}, Landroid/support/v7/widget/ta;->b(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {p0, v1}, Landroid/widget/AutoCompleteTextView;->setDropDownBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 81
    :cond_0
    invoke-virtual {v0}, Landroid/support/v7/widget/ta;->a()V

    .line 83
    new-instance v1, Landroid/support/v7/widget/j;

    invoke-direct {v1, p0}, Landroid/support/v7/widget/j;-><init>(Landroid/view/View;)V

    iput-object v1, p0, Landroid/support/v7/widget/i;->b:Landroid/support/v7/widget/j;

    .line 84
    iget-object v1, p0, Landroid/support/v7/widget/i;->b:Landroid/support/v7/widget/j;

    invoke-virtual {v1, p2, p3}, Landroid/support/v7/widget/j;->a(Landroid/util/AttributeSet;I)V

    .line 86
    new-instance v1, Landroid/support/v7/widget/H;

    invoke-direct {v1, p0}, Landroid/support/v7/widget/H;-><init>(Landroid/widget/TextView;)V

    iput-object v1, p0, Landroid/support/v7/widget/i;->c:Landroid/support/v7/widget/H;

    .line 87
    iget-object v1, p0, Landroid/support/v7/widget/i;->c:Landroid/support/v7/widget/H;

    invoke-virtual {v1, p2, p3}, Landroid/support/v7/widget/H;->a(Landroid/util/AttributeSet;I)V

    .line 88
    iget-object v1, p0, Landroid/support/v7/widget/i;->c:Landroid/support/v7/widget/H;

    invoke-virtual {v1}, Landroid/support/v7/widget/H;->a()V

    .line 89
    return-void
.end method


# virtual methods
.method protected drawableStateChanged()V
    .locals 1

    .line 170
    invoke-super {p0}, Landroid/widget/AutoCompleteTextView;->drawableStateChanged()V

    .line 171
    iget-object v0, p0, Landroid/support/v7/widget/i;->b:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 172
    invoke-virtual {v0}, Landroid/support/v7/widget/j;->a()V

    .line 174
    :cond_0
    iget-object v0, p0, Landroid/support/v7/widget/i;->c:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_1

    .line 175
    invoke-virtual {v0}, Landroid/support/v7/widget/H;->a()V

    .line 177
    :cond_1
    return-void
.end method

.method public getSupportBackgroundTintList()Landroid/content/res/ColorStateList;
    .locals 1

    .line 136
    iget-object v0, p0, Landroid/support/v7/widget/i;->b:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 137
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

    .line 164
    iget-object v0, p0, Landroid/support/v7/widget/i;->b:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 165
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

    .line 189
    invoke-super {p0, p1}, Landroid/widget/AutoCompleteTextView;->onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;

    move-result-object v0

    invoke-static {v0, p1, p0}, Landroid/support/v7/widget/q;->a(Landroid/view/inputmethod/InputConnection;Landroid/view/inputmethod/EditorInfo;Landroid/view/View;)Landroid/view/inputmethod/InputConnection;

    return-object v0
.end method

.method public setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "background"    # Landroid/graphics/drawable/Drawable;

    .line 106
    invoke-super {p0, p1}, Landroid/widget/AutoCompleteTextView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 107
    iget-object v0, p0, Landroid/support/v7/widget/i;->b:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 108
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/j;->a(Landroid/graphics/drawable/Drawable;)V

    .line 110
    :cond_0
    return-void
.end method

.method public setBackgroundResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 98
    invoke-super {p0, p1}, Landroid/widget/AutoCompleteTextView;->setBackgroundResource(I)V

    .line 99
    iget-object v0, p0, Landroid/support/v7/widget/i;->b:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 100
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/j;->a(I)V

    .line 102
    :cond_0
    return-void
.end method

.method public setCustomSelectionActionModeCallback(Landroid/view/ActionMode$Callback;)V
    .locals 1
    .param p1, "actionModeCallback"    # Landroid/view/ActionMode$Callback;

    .line 199
    nop

    .line 200
    invoke-static {p0, p1}, Landroid/support/v4/widget/m;->a(Landroid/widget/TextView;Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode$Callback;

    move-result-object v0

    .line 199
    invoke-super {p0, v0}, Landroid/widget/AutoCompleteTextView;->setCustomSelectionActionModeCallback(Landroid/view/ActionMode$Callback;)V

    .line 201
    return-void
.end method

.method public setDropDownBackgroundResource(I)V
    .locals 1
    .param p1, "resId"    # I

    .line 93
    invoke-virtual {p0}, Landroid/widget/AutoCompleteTextView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, p1}, La/b/d/b/a/a;->b(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/widget/AutoCompleteTextView;->setDropDownBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 94
    return-void
.end method

.method public setSupportBackgroundTintList(Landroid/content/res/ColorStateList;)V
    .locals 1
    .param p1, "tint"    # Landroid/content/res/ColorStateList;

    .line 121
    iget-object v0, p0, Landroid/support/v7/widget/i;->b:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 122
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/j;->b(Landroid/content/res/ColorStateList;)V

    .line 124
    :cond_0
    return-void
.end method

.method public setSupportBackgroundTintMode(Landroid/graphics/PorterDuff$Mode;)V
    .locals 1
    .param p1, "tintMode"    # Landroid/graphics/PorterDuff$Mode;

    .line 149
    iget-object v0, p0, Landroid/support/v7/widget/i;->b:Landroid/support/v7/widget/j;

    if-eqz v0, :cond_0

    .line 150
    invoke-virtual {v0, p1}, Landroid/support/v7/widget/j;->a(Landroid/graphics/PorterDuff$Mode;)V

    .line 152
    :cond_0
    return-void
.end method

.method public setTextAppearance(Landroid/content/Context;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resId"    # I

    .line 181
    invoke-super {p0, p1, p2}, Landroid/widget/AutoCompleteTextView;->setTextAppearance(Landroid/content/Context;I)V

    .line 182
    iget-object v0, p0, Landroid/support/v7/widget/i;->c:Landroid/support/v7/widget/H;

    if-eqz v0, :cond_0

    .line 183
    invoke-virtual {v0, p1, p2}, Landroid/support/v7/widget/H;->a(Landroid/content/Context;I)V

    .line 185
    :cond_0
    return-void
.end method
