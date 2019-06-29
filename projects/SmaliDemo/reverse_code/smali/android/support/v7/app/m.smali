.class public Landroid/support/v7/app/m;
.super Landroid/support/v4/app/k;
.source ""

# interfaces
.implements Landroid/support/v7/app/n;
.implements Landroid/support/v4/app/Y$a;
.implements Landroid/support/v7/app/b;


# instance fields
.field private m:Landroid/support/v7/app/o;

.field private n:I

.field private o:Landroid/content/res/Resources;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 62
    invoke-direct {p0}, Landroid/support/v4/app/k;-><init>()V

    .line 66
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v7/app/m;->n:I

    return-void
.end method

.method private a(ILandroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "keycode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .line 552
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x1a

    if-ge v0, v1, :cond_0

    invoke-virtual {p2}, Landroid/view/KeyEvent;->isCtrlPressed()Z

    move-result v0

    if-nez v0, :cond_0

    .line 553
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getMetaState()I

    move-result v0

    invoke-static {v0}, Landroid/view/KeyEvent;->metaStateHasNoModifiers(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 554
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v0

    if-nez v0, :cond_0

    .line 555
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v0

    invoke-static {v0}, Landroid/view/KeyEvent;->isModifierKey(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 556
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    .line 557
    .local v0, "currentWindow":Landroid/view/Window;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 558
    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    .line 559
    .local v1, "decorView":Landroid/view/View;
    invoke-virtual {v1, p2}, Landroid/view/View;->dispatchKeyShortcutEvent(Landroid/view/KeyEvent;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 560
    const/4 v2, 0x1

    return v2

    .line 564
    .end local v0    # "currentWindow":Landroid/view/Window;
    .end local v1    # "decorView":Landroid/view/View;
    :cond_0
    const/4 v0, 0x0

    return v0
.end method


# virtual methods
.method public a(La/b/d/d/b$a;)La/b/d/d/b;
    .locals 1
    .param p1, "callback"    # La/b/d/d/b$a;

    .line 282
    const/4 v0, 0x0

    return-object v0
.end method

.method public a(La/b/d/d/b;)V
    .locals 0
    .param p1, "mode"    # La/b/d/d/b;

    .line 268
    return-void
.end method

.method public a(Landroid/content/Intent;)V
    .locals 0
    .param p1, "upIntent"    # Landroid/content/Intent;

    .line 464
    invoke-static {p0, p1}, Landroid/support/v4/app/T;->a(Landroid/app/Activity;Landroid/content/Intent;)V

    .line 465
    return-void
.end method

.method public a(Landroid/support/v4/app/Y;)V
    .locals 0
    .param p1, "builder"    # Landroid/support/v4/app/Y;

    .line 348
    invoke-virtual {p1, p0}, Landroid/support/v4/app/Y;->a(Landroid/app/Activity;)Landroid/support/v4/app/Y;

    .line 349
    return-void
.end method

.method public addContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "params"    # Landroid/view/ViewGroup$LayoutParams;

    .line 155
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Landroid/support/v7/app/o;->a(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 156
    return-void
.end method

.method public b(La/b/d/d/b;)V
    .locals 0
    .param p1, "mode"    # La/b/d/d/b;

    .line 257
    return-void
.end method

.method public b(Landroid/support/v4/app/Y;)V
    .locals 0
    .param p1, "builder"    # Landroid/support/v4/app/Y;

    .line 367
    return-void
.end method

.method public b(Landroid/content/Intent;)Z
    .locals 1
    .param p1, "targetIntent"    # Landroid/content/Intent;

    .line 448
    invoke-static {p0, p1}, Landroid/support/v4/app/T;->b(Landroid/app/Activity;Landroid/content/Intent;)Z

    move-result v0

    return v0
.end method

.method public c()Landroid/content/Intent;
    .locals 1

    .line 431
    invoke-static {p0}, Landroid/support/v4/app/T;->a(Landroid/app/Activity;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public closeOptionsMenu()V
    .locals 3

    .line 586
    invoke-virtual {p0}, Landroid/support/v7/app/m;->i()Landroid/support/v7/app/a;

    move-result-object v0

    .line 587
    .local v0, "actionBar":Landroid/support/v7/app/a;
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/Window;->hasFeature(I)Z

    move-result v1

    if-eqz v1, :cond_1

    if-eqz v0, :cond_0

    .line 588
    invoke-virtual {v0}, Landroid/support/v7/app/a;->e()Z

    move-result v1

    if-nez v1, :cond_1

    .line 589
    :cond_0
    invoke-super {p0}, Landroid/app/Activity;->closeOptionsMenu()V

    .line 591
    :cond_1
    return-void
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/KeyEvent;

    .line 529
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v0

    .line 530
    .local v0, "keyCode":I
    invoke-virtual {p0}, Landroid/support/v7/app/m;->i()Landroid/support/v7/app/a;

    move-result-object v1

    .line 531
    .local v1, "actionBar":Landroid/support/v7/app/a;
    const/16 v2, 0x52

    if-ne v0, v2, :cond_0

    if-eqz v1, :cond_0

    .line 532
    invoke-virtual {v1, p1}, Landroid/support/v7/app/a;->a(Landroid/view/KeyEvent;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 533
    const/4 v2, 0x1

    return v2

    .line 535
    :cond_0
    invoke-super {p0, p1}, Landroid/support/v4/app/X;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v2

    return v2
.end method

.method public findViewById(I)Landroid/view/View;
    .locals 1
    .param p1, "id"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Landroid/view/View;",
            ">(I)TT;"
        }
    .end annotation

    .line 191
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/support/v7/app/o;->a(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public g()V
    .locals 1

    .line 240
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/app/o;->f()V

    .line 241
    return-void
.end method

.method public getMenuInflater()Landroid/view/MenuInflater;
    .locals 1

    .line 135
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/app/o;->c()Landroid/view/MenuInflater;

    move-result-object v0

    return-object v0
.end method

.method public getResources()Landroid/content/res/Resources;
    .locals 2

    .line 540
    iget-object v0, p0, Landroid/support/v7/app/m;->o:Landroid/content/res/Resources;

    if-nez v0, :cond_0

    invoke-static {}, Landroid/support/v7/widget/Ga;->b()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 541
    new-instance v0, Landroid/support/v7/widget/Ga;

    invoke-super {p0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Landroid/support/v7/widget/Ga;-><init>(Landroid/content/Context;Landroid/content/res/Resources;)V

    iput-object v0, p0, Landroid/support/v7/app/m;->o:Landroid/content/res/Resources;

    .line 543
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/m;->o:Landroid/content/res/Resources;

    if-nez v0, :cond_1

    invoke-super {p0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    :cond_1
    return-object v0
.end method

.method public h()Landroid/support/v7/app/o;
    .locals 1

    .line 519
    iget-object v0, p0, Landroid/support/v7/app/m;->m:Landroid/support/v7/app/o;

    if-nez v0, :cond_0

    .line 520
    invoke-static {p0, p0}, Landroid/support/v7/app/o;->a(Landroid/app/Activity;Landroid/support/v7/app/n;)Landroid/support/v7/app/o;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/app/m;->m:Landroid/support/v7/app/o;

    .line 522
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/m;->m:Landroid/support/v7/app/o;

    return-object v0
.end method

.method public i()Landroid/support/v7/app/a;
    .locals 1

    .line 110
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/app/o;->d()Landroid/support/v7/app/a;

    move-result-object v0

    return-object v0
.end method

.method public invalidateOptionsMenu()V
    .locals 1

    .line 245
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/app/o;->f()V

    .line 246
    return-void
.end method

.method public j()V
    .locals 0
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 478
    return-void
.end method

.method public k()Z
    .locals 3

    .line 393
    invoke-virtual {p0}, Landroid/support/v7/app/m;->c()Landroid/content/Intent;

    move-result-object v0

    .line 395
    .local v0, "upIntent":Landroid/content/Intent;
    if-eqz v0, :cond_1

    .line 396
    invoke-virtual {p0, v0}, Landroid/support/v7/app/m;->b(Landroid/content/Intent;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 397
    invoke-static {p0}, Landroid/support/v4/app/Y;->a(Landroid/content/Context;)Landroid/support/v4/app/Y;

    move-result-object v1

    .line 398
    .local v1, "b":Landroid/support/v4/app/Y;
    invoke-virtual {p0, v1}, Landroid/support/v7/app/m;->a(Landroid/support/v4/app/Y;)V

    .line 399
    invoke-virtual {p0, v1}, Landroid/support/v7/app/m;->b(Landroid/support/v4/app/Y;)V

    .line 400
    invoke-virtual {v1}, Landroid/support/v4/app/Y;->a()V

    .line 403
    :try_start_0
    invoke-static {p0}, Landroid/support/v4/app/a;->a(Landroid/app/Activity;)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 408
    goto :goto_0

    .line 404
    :catch_0
    move-exception v2

    .line 407
    .local v2, "e":Ljava/lang/IllegalStateException;
    invoke-virtual {p0}, Landroid/app/Activity;->finish()V

    .line 409
    .end local v1    # "b":Landroid/support/v4/app/Y;
    .end local v2    # "e":Ljava/lang/IllegalStateException;
    :goto_0
    goto :goto_1

    .line 412
    :cond_0
    invoke-virtual {p0, v0}, Landroid/support/v7/app/m;->a(Landroid/content/Intent;)V

    .line 414
    :goto_1
    const/4 v1, 0x1

    return v1

    .line 416
    :cond_1
    const/4 v1, 0x0

    return v1
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 2
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .line 160
    invoke-super {p0, p1}, Landroid/support/v4/app/k;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 161
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/support/v7/app/o;->a(Landroid/content/res/Configuration;)V

    .line 162
    iget-object v0, p0, Landroid/support/v7/app/m;->o:Landroid/content/res/Resources;

    if-eqz v0, :cond_0

    .line 165
    invoke-super {p0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    .line 166
    .local v0, "newMetrics":Landroid/util/DisplayMetrics;
    iget-object v1, p0, Landroid/support/v7/app/m;->o:Landroid/content/res/Resources;

    invoke-virtual {v1, p1, v0}, Landroid/content/res/Resources;->updateConfiguration(Landroid/content/res/Configuration;Landroid/util/DisplayMetrics;)V

    .line 168
    .end local v0    # "newMetrics":Landroid/util/DisplayMetrics;
    :cond_0
    return-void
.end method

.method public onContentChanged()V
    .locals 0

    .line 470
    invoke-virtual {p0}, Landroid/support/v7/app/m;->j()V

    .line 471
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 71
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    .line 72
    .local v0, "delegate":Landroid/support/v7/app/o;
    invoke-virtual {v0}, Landroid/support/v7/app/o;->e()V

    .line 73
    invoke-virtual {v0, p1}, Landroid/support/v7/app/o;->a(Landroid/os/Bundle;)V

    .line 74
    invoke-virtual {v0}, Landroid/support/v7/app/o;->a()Z

    move-result v1

    if-eqz v1, :cond_1

    iget v1, p0, Landroid/support/v7/app/m;->n:I

    if-eqz v1, :cond_1

    .line 79
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x17

    if-lt v2, v3, :cond_0

    .line 80
    invoke-virtual {p0}, Landroid/app/Activity;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v1

    iget v2, p0, Landroid/support/v7/app/m;->n:I

    const/4 v3, 0x0

    invoke-virtual {p0, v1, v2, v3}, Landroid/app/Activity;->onApplyThemeResource(Landroid/content/res/Resources$Theme;IZ)V

    goto :goto_0

    .line 82
    :cond_0
    invoke-virtual {p0, v1}, Landroid/support/v7/app/m;->setTheme(I)V

    .line 85
    :cond_1
    :goto_0
    invoke-super {p0, p1}, Landroid/support/v4/app/k;->onCreate(Landroid/os/Bundle;)V

    .line 86
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .line 210
    invoke-super {p0}, Landroid/support/v4/app/k;->onDestroy()V

    .line 211
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/app/o;->g()V

    .line 212
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .line 569
    invoke-direct {p0, p1, p2}, Landroid/support/v7/app/m;->a(ILandroid/view/KeyEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 570
    const/4 v0, 0x1

    return v0

    .line 572
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public final onMenuItemSelected(ILandroid/view/MenuItem;)Z
    .locals 3
    .param p1, "featureId"    # I
    .param p2, "item"    # Landroid/view/MenuItem;

    .line 196
    invoke-super {p0, p1, p2}, Landroid/support/v4/app/k;->onMenuItemSelected(ILandroid/view/MenuItem;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 197
    const/4 v0, 0x1

    return v0

    .line 200
    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/app/m;->i()Landroid/support/v7/app/a;

    move-result-object v0

    .line 201
    .local v0, "ab":Landroid/support/v7/app/a;
    invoke-interface {p2}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    const v2, 0x102002c

    if-ne v1, v2, :cond_1

    if-eqz v0, :cond_1

    .line 202
    invoke-virtual {v0}, Landroid/support/v7/app/a;->g()I

    move-result v1

    and-int/lit8 v1, v1, 0x4

    if-eqz v1, :cond_1

    .line 203
    invoke-virtual {p0}, Landroid/support/v7/app/m;->k()Z

    move-result v1

    return v1

    .line 205
    :cond_1
    const/4 v1, 0x0

    return v1
.end method

.method public onMenuOpened(ILandroid/view/Menu;)Z
    .locals 1
    .param p1, "featureId"    # I
    .param p2, "menu"    # Landroid/view/Menu;

    .line 494
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onMenuOpened(ILandroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public onPanelClosed(ILandroid/view/Menu;)V
    .locals 0
    .param p1, "featureId"    # I
    .param p2, "menu"    # Landroid/view/Menu;

    .line 505
    invoke-super {p0, p1, p2}, Landroid/support/v4/app/k;->onPanelClosed(ILandroid/view/Menu;)V

    .line 506
    return-void
.end method

.method protected onPostCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 97
    invoke-super {p0, p1}, Landroid/app/Activity;->onPostCreate(Landroid/os/Bundle;)V

    .line 98
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/support/v7/app/o;->b(Landroid/os/Bundle;)V

    .line 99
    return-void
.end method

.method protected onPostResume()V
    .locals 1

    .line 172
    invoke-super {p0}, Landroid/support/v4/app/k;->onPostResume()V

    .line 173
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/app/o;->h()V

    .line 174
    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .line 510
    invoke-super {p0, p1}, Landroid/support/v4/app/k;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 511
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/support/v7/app/o;->c(Landroid/os/Bundle;)V

    .line 512
    return-void
.end method

.method protected onStart()V
    .locals 1

    .line 178
    invoke-super {p0}, Landroid/support/v4/app/k;->onStart()V

    .line 179
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/app/o;->i()V

    .line 180
    return-void
.end method

.method protected onStop()V
    .locals 1

    .line 184
    invoke-super {p0}, Landroid/support/v4/app/k;->onStop()V

    .line 185
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/app/o;->j()V

    .line 186
    return-void
.end method

.method protected onTitleChanged(Ljava/lang/CharSequence;I)V
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;
    .param p2, "color"    # I

    .line 216
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onTitleChanged(Ljava/lang/CharSequence;I)V

    .line 217
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/support/v7/app/o;->a(Ljava/lang/CharSequence;)V

    .line 218
    return-void
.end method

.method public openOptionsMenu()V
    .locals 3

    .line 577
    invoke-virtual {p0}, Landroid/support/v7/app/m;->i()Landroid/support/v7/app/a;

    move-result-object v0

    .line 578
    .local v0, "actionBar":Landroid/support/v7/app/a;
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/Window;->hasFeature(I)Z

    move-result v1

    if-eqz v1, :cond_1

    if-eqz v0, :cond_0

    .line 579
    invoke-virtual {v0}, Landroid/support/v7/app/a;->k()Z

    move-result v1

    if-nez v1, :cond_1

    .line 580
    :cond_0
    invoke-super {p0}, Landroid/app/Activity;->openOptionsMenu()V

    .line 582
    :cond_1
    return-void
.end method

.method public setContentView(I)V
    .locals 1
    .param p1, "layoutResID"    # I

    .line 140
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/support/v7/app/o;->c(I)V

    .line 141
    return-void
.end method

.method public setContentView(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .line 145
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/support/v7/app/o;->a(Landroid/view/View;)V

    .line 146
    return-void
.end method

.method public setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "params"    # Landroid/view/ViewGroup$LayoutParams;

    .line 150
    invoke-virtual {p0}, Landroid/support/v7/app/m;->h()Landroid/support/v7/app/o;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Landroid/support/v7/app/o;->b(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 151
    return-void
.end method

.method public setTheme(I)V
    .locals 0
    .param p1, "resid"    # I

    .line 90
    invoke-super {p0, p1}, Landroid/app/Activity;->setTheme(I)V

    .line 92
    iput p1, p0, Landroid/support/v7/app/m;->n:I

    .line 93
    return-void
.end method
