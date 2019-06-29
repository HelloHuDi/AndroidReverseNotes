.class public Landroid/support/v7/view/menu/a;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements La/b/c/c/a/b;


# instance fields
.field private final a:I

.field private final b:I

.field private final c:I

.field private final d:I

.field private e:Ljava/lang/CharSequence;

.field private f:Ljava/lang/CharSequence;

.field private g:Landroid/content/Intent;

.field private h:C

.field private i:I

.field private j:C

.field private k:I

.field private l:Landroid/graphics/drawable/Drawable;

.field private m:I

.field private n:Landroid/content/Context;

.field private o:Landroid/view/MenuItem$OnMenuItemClickListener;

.field private p:Ljava/lang/CharSequence;

.field private q:Ljava/lang/CharSequence;

.field private r:Landroid/content/res/ColorStateList;

.field private s:Landroid/graphics/PorterDuff$Mode;

.field private t:Z

.field private u:Z

.field private v:I


# direct methods
.method public constructor <init>(Landroid/content/Context;IIIILjava/lang/CharSequence;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "group"    # I
    .param p3, "id"    # I
    .param p4, "categoryOrder"    # I
    .param p5, "ordering"    # I
    .param p6, "title"    # Ljava/lang/CharSequence;

    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    const/16 v0, 0x1000

    iput v0, p0, Landroid/support/v7/view/menu/a;->i:I

    .line 56
    iput v0, p0, Landroid/support/v7/view/menu/a;->k:I

    .line 59
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v7/view/menu/a;->m:I

    .line 68
    const/4 v1, 0x0

    iput-object v1, p0, Landroid/support/v7/view/menu/a;->r:Landroid/content/res/ColorStateList;

    .line 69
    iput-object v1, p0, Landroid/support/v7/view/menu/a;->s:Landroid/graphics/PorterDuff$Mode;

    .line 70
    iput-boolean v0, p0, Landroid/support/v7/view/menu/a;->t:Z

    .line 71
    iput-boolean v0, p0, Landroid/support/v7/view/menu/a;->u:Z

    .line 75
    const/16 v0, 0x10

    iput v0, p0, Landroid/support/v7/view/menu/a;->v:I

    .line 84
    iput-object p1, p0, Landroid/support/v7/view/menu/a;->n:Landroid/content/Context;

    .line 85
    iput p3, p0, Landroid/support/v7/view/menu/a;->a:I

    .line 86
    iput p2, p0, Landroid/support/v7/view/menu/a;->b:I

    .line 87
    iput p4, p0, Landroid/support/v7/view/menu/a;->c:I

    .line 88
    iput p5, p0, Landroid/support/v7/view/menu/a;->d:I

    .line 89
    iput-object p6, p0, Landroid/support/v7/view/menu/a;->e:Ljava/lang/CharSequence;

    .line 90
    return-void
.end method

.method private b()V
    .locals 2

    .line 434
    iget-object v0, p0, Landroid/support/v7/view/menu/a;->l:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_2

    iget-boolean v0, p0, Landroid/support/v7/view/menu/a;->t:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Landroid/support/v7/view/menu/a;->u:Z

    if-eqz v0, :cond_2

    .line 435
    :cond_0
    iget-object v0, p0, Landroid/support/v7/view/menu/a;->l:Landroid/graphics/drawable/Drawable;

    invoke-static {v0}, Landroid/support/v4/graphics/drawable/a;->g(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/view/menu/a;->l:Landroid/graphics/drawable/Drawable;

    .line 436
    iget-object v0, p0, Landroid/support/v7/view/menu/a;->l:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/view/menu/a;->l:Landroid/graphics/drawable/Drawable;

    .line 438
    iget-boolean v0, p0, Landroid/support/v7/view/menu/a;->t:Z

    if-eqz v0, :cond_1

    .line 439
    iget-object v0, p0, Landroid/support/v7/view/menu/a;->l:Landroid/graphics/drawable/Drawable;

    iget-object v1, p0, Landroid/support/v7/view/menu/a;->r:Landroid/content/res/ColorStateList;

    invoke-static {v0, v1}, Landroid/support/v4/graphics/drawable/a;->a(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V

    .line 442
    :cond_1
    iget-boolean v0, p0, Landroid/support/v7/view/menu/a;->u:Z

    if-eqz v0, :cond_2

    .line 443
    iget-object v0, p0, Landroid/support/v7/view/menu/a;->l:Landroid/graphics/drawable/Drawable;

    iget-object v1, p0, Landroid/support/v7/view/menu/a;->s:Landroid/graphics/PorterDuff$Mode;

    invoke-static {v0, v1}, Landroid/support/v4/graphics/drawable/a;->a(Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V

    .line 446
    :cond_2
    return-void
.end method


# virtual methods
.method public a(La/b/c/g/e;)La/b/c/c/a/b;
    .locals 1
    .param p1, "actionProvider"    # La/b/c/g/e;

    .line 352
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public a()La/b/c/g/e;
    .locals 1

    .line 347
    const/4 v0, 0x0

    return-object v0
.end method

.method public collapseActionView()Z
    .locals 1

    .line 368
    const/4 v0, 0x0

    return v0
.end method

.method public expandActionView()Z
    .locals 1

    .line 363
    const/4 v0, 0x0

    return v0
.end method

.method public getActionProvider()Landroid/view/ActionProvider;
    .locals 1

    .line 337
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public getActionView()Landroid/view/View;
    .locals 1

    .line 327
    const/4 v0, 0x0

    return-object v0
.end method

.method public getAlphabeticModifiers()I
    .locals 1

    .line 99
    iget v0, p0, Landroid/support/v7/view/menu/a;->k:I

    return v0
.end method

.method public getAlphabeticShortcut()C
    .locals 1

    .line 94
    iget-char v0, p0, Landroid/support/v7/view/menu/a;->j:C

    return v0
.end method

.method public getContentDescription()Ljava/lang/CharSequence;
    .locals 1

    .line 389
    iget-object v0, p0, Landroid/support/v7/view/menu/a;->p:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public getGroupId()I
    .locals 1

    .line 104
    iget v0, p0, Landroid/support/v7/view/menu/a;->b:I

    return v0
.end method

.method public getIcon()Landroid/graphics/drawable/Drawable;
    .locals 1

    .line 109
    iget-object v0, p0, Landroid/support/v7/view/menu/a;->l:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getIconTintList()Landroid/content/res/ColorStateList;
    .locals 1

    .line 415
    iget-object v0, p0, Landroid/support/v7/view/menu/a;->r:Landroid/content/res/ColorStateList;

    return-object v0
.end method

.method public getIconTintMode()Landroid/graphics/PorterDuff$Mode;
    .locals 1

    .line 430
    iget-object v0, p0, Landroid/support/v7/view/menu/a;->s:Landroid/graphics/PorterDuff$Mode;

    return-object v0
.end method

.method public getIntent()Landroid/content/Intent;
    .locals 1

    .line 114
    iget-object v0, p0, Landroid/support/v7/view/menu/a;->g:Landroid/content/Intent;

    return-object v0
.end method

.method public getItemId()I
    .locals 1

    .line 119
    iget v0, p0, Landroid/support/v7/view/menu/a;->a:I

    return v0
.end method

.method public getMenuInfo()Landroid/view/ContextMenu$ContextMenuInfo;
    .locals 1

    .line 124
    const/4 v0, 0x0

    return-object v0
.end method

.method public getNumericModifiers()I
    .locals 1

    .line 134
    iget v0, p0, Landroid/support/v7/view/menu/a;->i:I

    return v0
.end method

.method public getNumericShortcut()C
    .locals 1

    .line 129
    iget-char v0, p0, Landroid/support/v7/view/menu/a;->h:C

    return v0
.end method

.method public getOrder()I
    .locals 1

    .line 139
    iget v0, p0, Landroid/support/v7/view/menu/a;->d:I

    return v0
.end method

.method public getSubMenu()Landroid/view/SubMenu;
    .locals 1

    .line 144
    const/4 v0, 0x0

    return-object v0
.end method

.method public getTitle()Ljava/lang/CharSequence;
    .locals 1

    .line 149
    iget-object v0, p0, Landroid/support/v7/view/menu/a;->e:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public getTitleCondensed()Ljava/lang/CharSequence;
    .locals 1

    .line 154
    iget-object v0, p0, Landroid/support/v7/view/menu/a;->f:Ljava/lang/CharSequence;

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    iget-object v0, p0, Landroid/support/v7/view/menu/a;->e:Ljava/lang/CharSequence;

    :goto_0
    return-object v0
.end method

.method public getTooltipText()Ljava/lang/CharSequence;
    .locals 1

    .line 400
    iget-object v0, p0, Landroid/support/v7/view/menu/a;->q:Ljava/lang/CharSequence;

    return-object v0
.end method

.method public hasSubMenu()Z
    .locals 1

    .line 159
    const/4 v0, 0x0

    return v0
.end method

.method public isActionViewExpanded()Z
    .locals 1

    .line 373
    const/4 v0, 0x0

    return v0
.end method

.method public isCheckable()Z
    .locals 2

    .line 164
    iget v0, p0, Landroid/support/v7/view/menu/a;->v:I

    const/4 v1, 0x1

    and-int/2addr v0, v1

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    return v1
.end method

.method public isChecked()Z
    .locals 1

    .line 169
    iget v0, p0, Landroid/support/v7/view/menu/a;->v:I

    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public isEnabled()Z
    .locals 1

    .line 174
    iget v0, p0, Landroid/support/v7/view/menu/a;->v:I

    and-int/lit8 v0, v0, 0x10

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public isVisible()Z
    .locals 1

    .line 179
    iget v0, p0, Landroid/support/v7/view/menu/a;->v:I

    and-int/lit8 v0, v0, 0x8

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public setActionProvider(Landroid/view/ActionProvider;)Landroid/view/MenuItem;
    .locals 1
    .param p1, "actionProvider"    # Landroid/view/ActionProvider;

    .line 332
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public setActionView(I)La/b/c/c/a/b;
    .locals 1
    .param p1, "resId"    # I

    .line 342
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public setActionView(Landroid/view/View;)La/b/c/c/a/b;
    .locals 1
    .param p1, "actionView"    # Landroid/view/View;

    .line 322
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public bridge synthetic setActionView(I)Landroid/view/MenuItem;
    .locals 0

    .line 42
    invoke-virtual {p0, p1}, Landroid/support/v7/view/menu/a;->setActionView(I)La/b/c/c/a/b;

    .end local p0    # "this":Landroid/support/v7/view/menu/a;
    const/4 p1, 0x0

    throw p1
.end method

.method public bridge synthetic setActionView(Landroid/view/View;)Landroid/view/MenuItem;
    .locals 0

    .line 42
    invoke-virtual {p0, p1}, Landroid/support/v7/view/menu/a;->setActionView(Landroid/view/View;)La/b/c/c/a/b;

    .end local p0    # "this":Landroid/support/v7/view/menu/a;
    const/4 p1, 0x0

    throw p1
.end method

.method public setAlphabeticShortcut(C)Landroid/view/MenuItem;
    .locals 1
    .param p1, "alphaChar"    # C

    .line 184
    invoke-static {p1}, Ljava/lang/Character;->toLowerCase(C)C

    move-result v0

    iput-char v0, p0, Landroid/support/v7/view/menu/a;->j:C

    .line 185
    return-object p0
.end method

.method public setAlphabeticShortcut(CI)Landroid/view/MenuItem;
    .locals 1
    .param p1, "alphaChar"    # C
    .param p2, "alphaModifiers"    # I

    .line 190
    invoke-static {p1}, Ljava/lang/Character;->toLowerCase(C)C

    move-result v0

    iput-char v0, p0, Landroid/support/v7/view/menu/a;->j:C

    .line 191
    invoke-static {p2}, Landroid/view/KeyEvent;->normalizeMetaState(I)I

    move-result v0

    iput v0, p0, Landroid/support/v7/view/menu/a;->k:I

    .line 192
    return-object p0
.end method

.method public setCheckable(Z)Landroid/view/MenuItem;
    .locals 1
    .param p1, "checkable"    # Z

    .line 197
    iget v0, p0, Landroid/support/v7/view/menu/a;->v:I

    and-int/lit8 v0, v0, -0x2

    or-int/2addr v0, p1

    iput v0, p0, Landroid/support/v7/view/menu/a;->v:I

    .line 198
    return-object p0
.end method

.method public setChecked(Z)Landroid/view/MenuItem;
    .locals 2
    .param p1, "checked"    # Z

    .line 208
    iget v0, p0, Landroid/support/v7/view/menu/a;->v:I

    and-int/lit8 v0, v0, -0x3

    if-eqz p1, :cond_0

    const/4 v1, 0x2

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    or-int/2addr v0, v1

    iput v0, p0, Landroid/support/v7/view/menu/a;->v:I

    .line 209
    return-object p0
.end method

.method public setContentDescription(Ljava/lang/CharSequence;)La/b/c/c/a/b;
    .locals 0
    .param p1, "contentDescription"    # Ljava/lang/CharSequence;

    .line 383
    iput-object p1, p0, Landroid/support/v7/view/menu/a;->p:Ljava/lang/CharSequence;

    .line 384
    return-object p0
.end method

.method public bridge synthetic setContentDescription(Ljava/lang/CharSequence;)Landroid/view/MenuItem;
    .locals 0

    .line 42
    invoke-virtual {p0, p1}, Landroid/support/v7/view/menu/a;->setContentDescription(Ljava/lang/CharSequence;)La/b/c/c/a/b;

    return-object p0
.end method

.method public setEnabled(Z)Landroid/view/MenuItem;
    .locals 2
    .param p1, "enabled"    # Z

    .line 214
    iget v0, p0, Landroid/support/v7/view/menu/a;->v:I

    and-int/lit8 v0, v0, -0x11

    if-eqz p1, :cond_0

    const/16 v1, 0x10

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    or-int/2addr v0, v1

    iput v0, p0, Landroid/support/v7/view/menu/a;->v:I

    .line 215
    return-object p0
.end method

.method public setIcon(I)Landroid/view/MenuItem;
    .locals 1
    .param p1, "iconRes"    # I

    .line 229
    iput p1, p0, Landroid/support/v7/view/menu/a;->m:I

    .line 230
    iget-object v0, p0, Landroid/support/v7/view/menu/a;->n:Landroid/content/Context;

    invoke-static {v0, p1}, La/b/c/a/a;->b(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/view/menu/a;->l:Landroid/graphics/drawable/Drawable;

    .line 232
    invoke-direct {p0}, Landroid/support/v7/view/menu/a;->b()V

    .line 233
    return-object p0
.end method

.method public setIcon(Landroid/graphics/drawable/Drawable;)Landroid/view/MenuItem;
    .locals 1
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .line 220
    iput-object p1, p0, Landroid/support/v7/view/menu/a;->l:Landroid/graphics/drawable/Drawable;

    .line 221
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v7/view/menu/a;->m:I

    .line 223
    invoke-direct {p0}, Landroid/support/v7/view/menu/a;->b()V

    .line 224
    return-object p0
.end method

.method public setIconTintList(Landroid/content/res/ColorStateList;)Landroid/view/MenuItem;
    .locals 1
    .param p1, "iconTintList"    # Landroid/content/res/ColorStateList;

    .line 405
    iput-object p1, p0, Landroid/support/v7/view/menu/a;->r:Landroid/content/res/ColorStateList;

    .line 406
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/view/menu/a;->t:Z

    .line 408
    invoke-direct {p0}, Landroid/support/v7/view/menu/a;->b()V

    .line 410
    return-object p0
.end method

.method public setIconTintMode(Landroid/graphics/PorterDuff$Mode;)Landroid/view/MenuItem;
    .locals 1
    .param p1, "iconTintMode"    # Landroid/graphics/PorterDuff$Mode;

    .line 420
    iput-object p1, p0, Landroid/support/v7/view/menu/a;->s:Landroid/graphics/PorterDuff$Mode;

    .line 421
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/view/menu/a;->u:Z

    .line 423
    invoke-direct {p0}, Landroid/support/v7/view/menu/a;->b()V

    .line 425
    return-object p0
.end method

.method public setIntent(Landroid/content/Intent;)Landroid/view/MenuItem;
    .locals 0
    .param p1, "intent"    # Landroid/content/Intent;

    .line 238
    iput-object p1, p0, Landroid/support/v7/view/menu/a;->g:Landroid/content/Intent;

    .line 239
    return-object p0
.end method

.method public setNumericShortcut(C)Landroid/view/MenuItem;
    .locals 0
    .param p1, "numericChar"    # C

    .line 244
    iput-char p1, p0, Landroid/support/v7/view/menu/a;->h:C

    .line 245
    return-object p0
.end method

.method public setNumericShortcut(CI)Landroid/view/MenuItem;
    .locals 1
    .param p1, "numericChar"    # C
    .param p2, "numericModifiers"    # I

    .line 250
    iput-char p1, p0, Landroid/support/v7/view/menu/a;->h:C

    .line 251
    invoke-static {p2}, Landroid/view/KeyEvent;->normalizeMetaState(I)I

    move-result v0

    iput v0, p0, Landroid/support/v7/view/menu/a;->i:I

    .line 252
    return-object p0
.end method

.method public setOnActionExpandListener(Landroid/view/MenuItem$OnActionExpandListener;)Landroid/view/MenuItem;
    .locals 1
    .param p1, "listener"    # Landroid/view/MenuItem$OnActionExpandListener;

    .line 378
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;
    .locals 0
    .param p1, "menuItemClickListener"    # Landroid/view/MenuItem$OnMenuItemClickListener;

    .line 257
    iput-object p1, p0, Landroid/support/v7/view/menu/a;->o:Landroid/view/MenuItem$OnMenuItemClickListener;

    .line 258
    return-object p0
.end method

.method public setShortcut(CC)Landroid/view/MenuItem;
    .locals 1
    .param p1, "numericChar"    # C
    .param p2, "alphaChar"    # C

    .line 263
    iput-char p1, p0, Landroid/support/v7/view/menu/a;->h:C

    .line 264
    invoke-static {p2}, Ljava/lang/Character;->toLowerCase(C)C

    move-result v0

    iput-char v0, p0, Landroid/support/v7/view/menu/a;->j:C

    .line 265
    return-object p0
.end method

.method public setShortcut(CCII)Landroid/view/MenuItem;
    .locals 1
    .param p1, "numericChar"    # C
    .param p2, "alphaChar"    # C
    .param p3, "numericModifiers"    # I
    .param p4, "alphaModifiers"    # I

    .line 271
    iput-char p1, p0, Landroid/support/v7/view/menu/a;->h:C

    .line 272
    invoke-static {p3}, Landroid/view/KeyEvent;->normalizeMetaState(I)I

    move-result v0

    iput v0, p0, Landroid/support/v7/view/menu/a;->i:I

    .line 273
    invoke-static {p2}, Ljava/lang/Character;->toLowerCase(C)C

    move-result v0

    iput-char v0, p0, Landroid/support/v7/view/menu/a;->j:C

    .line 274
    invoke-static {p4}, Landroid/view/KeyEvent;->normalizeMetaState(I)I

    move-result v0

    iput v0, p0, Landroid/support/v7/view/menu/a;->k:I

    .line 275
    return-object p0
.end method

.method public setShowAsAction(I)V
    .locals 0
    .param p1, "show"    # I

    .line 318
    return-void
.end method

.method public setShowAsActionFlags(I)La/b/c/c/a/b;
    .locals 0
    .param p1, "actionEnum"    # I

    .line 357
    invoke-virtual {p0, p1}, Landroid/support/v7/view/menu/a;->setShowAsAction(I)V

    .line 358
    return-object p0
.end method

.method public bridge synthetic setShowAsActionFlags(I)Landroid/view/MenuItem;
    .locals 0

    .line 42
    invoke-virtual {p0, p1}, Landroid/support/v7/view/menu/a;->setShowAsActionFlags(I)La/b/c/c/a/b;

    return-object p0
.end method

.method public setTitle(I)Landroid/view/MenuItem;
    .locals 1
    .param p1, "title"    # I

    .line 286
    iget-object v0, p0, Landroid/support/v7/view/menu/a;->n:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/view/menu/a;->e:Ljava/lang/CharSequence;

    .line 287
    return-object p0
.end method

.method public setTitle(Ljava/lang/CharSequence;)Landroid/view/MenuItem;
    .locals 0
    .param p1, "title"    # Ljava/lang/CharSequence;

    .line 280
    iput-object p1, p0, Landroid/support/v7/view/menu/a;->e:Ljava/lang/CharSequence;

    .line 281
    return-object p0
.end method

.method public setTitleCondensed(Ljava/lang/CharSequence;)Landroid/view/MenuItem;
    .locals 0
    .param p1, "title"    # Ljava/lang/CharSequence;

    .line 292
    iput-object p1, p0, Landroid/support/v7/view/menu/a;->f:Ljava/lang/CharSequence;

    .line 293
    return-object p0
.end method

.method public setTooltipText(Ljava/lang/CharSequence;)La/b/c/c/a/b;
    .locals 0
    .param p1, "tooltipText"    # Ljava/lang/CharSequence;

    .line 394
    iput-object p1, p0, Landroid/support/v7/view/menu/a;->q:Ljava/lang/CharSequence;

    .line 395
    return-object p0
.end method

.method public bridge synthetic setTooltipText(Ljava/lang/CharSequence;)Landroid/view/MenuItem;
    .locals 0

    .line 42
    invoke-virtual {p0, p1}, Landroid/support/v7/view/menu/a;->setTooltipText(Ljava/lang/CharSequence;)La/b/c/c/a/b;

    return-object p0
.end method

.method public setVisible(Z)Landroid/view/MenuItem;
    .locals 2
    .param p1, "visible"    # Z

    .line 298
    iget v0, p0, Landroid/support/v7/view/menu/a;->v:I

    const/16 v1, 0x8

    and-int/2addr v0, v1

    if-eqz p1, :cond_0

    const/4 v1, 0x0

    :cond_0
    or-int/2addr v0, v1

    iput v0, p0, Landroid/support/v7/view/menu/a;->v:I

    .line 299
    return-object p0
.end method
