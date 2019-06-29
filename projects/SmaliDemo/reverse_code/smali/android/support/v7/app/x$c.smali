.class Landroid/support/v7/app/x$c;
.super La/b/d/d/j;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v7/app/x;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "c"
.end annotation


# instance fields
.field final synthetic b:Landroid/support/v7/app/x;


# direct methods
.method constructor <init>(Landroid/support/v7/app/x;Landroid/view/Window$Callback;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/app/x;
    .param p2, "callback"    # Landroid/view/Window$Callback;

    .line 2526
    iput-object p1, p0, Landroid/support/v7/app/x$c;->b:Landroid/support/v7/app/x;

    .line 2527
    invoke-direct {p0, p2}, La/b/d/d/j;-><init>(Landroid/view/Window$Callback;)V

    .line 2528
    return-void
.end method


# virtual methods
.method final a(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;
    .locals 3
    .param p1, "callback"    # Landroid/view/ActionMode$Callback;

    .line 2620
    new-instance v0, La/b/d/d/f$a;

    iget-object v1, p0, Landroid/support/v7/app/x$c;->b:Landroid/support/v7/app/x;

    iget-object v1, v1, Landroid/support/v7/app/x;->e:Landroid/content/Context;

    invoke-direct {v0, v1, p1}, La/b/d/d/f$a;-><init>(Landroid/content/Context;Landroid/view/ActionMode$Callback;)V

    .line 2624
    .local v0, "callbackWrapper":La/b/d/d/f$a;
    iget-object v1, p0, Landroid/support/v7/app/x$c;->b:Landroid/support/v7/app/x;

    .line 2625
    invoke-virtual {v1, v0}, Landroid/support/v7/app/x;->a(La/b/d/d/b$a;)La/b/d/d/b;

    move-result-object v1

    .line 2627
    .local v1, "supportActionMode":La/b/d/d/b;
    if-eqz v1, :cond_0

    .line 2629
    invoke-virtual {v0, v1}, La/b/d/d/f$a;->b(La/b/d/d/b;)Landroid/view/ActionMode;

    move-result-object v2

    return-object v2

    .line 2631
    :cond_0
    const/4 v2, 0x0

    return-object v2
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/KeyEvent;

    .line 2532
    iget-object v0, p0, Landroid/support/v7/app/x$c;->b:Landroid/support/v7/app/x;

    invoke-virtual {v0, p1}, Landroid/support/v7/app/x;->a(Landroid/view/KeyEvent;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 2533
    invoke-super {p0, p1}, La/b/d/d/j;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method

.method public dispatchKeyShortcutEvent(Landroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/KeyEvent;

    .line 2538
    invoke-super {p0, p1}, La/b/d/d/j;->dispatchKeyShortcutEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Landroid/support/v7/app/x$c;->b:Landroid/support/v7/app/x;

    .line 2539
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v1

    invoke-virtual {v0, v1, p1}, Landroid/support/v7/app/x;->b(ILandroid/view/KeyEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    const/4 v0, 0x1

    :goto_1
    return v0
.end method

.method public onContentChanged()V
    .locals 0

    .line 2556
    return-void
.end method

.method public onCreatePanelMenu(ILandroid/view/Menu;)Z
    .locals 1
    .param p1, "featureId"    # I
    .param p2, "menu"    # Landroid/view/Menu;

    .line 2544
    if-nez p1, :cond_0

    instance-of v0, p2, Landroid/support/v7/view/menu/l;

    if-nez v0, :cond_0

    .line 2547
    const/4 v0, 0x0

    return v0

    .line 2549
    :cond_0
    invoke-super {p0, p1, p2}, La/b/d/d/j;->onCreatePanelMenu(ILandroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public onMenuOpened(ILandroid/view/Menu;)Z
    .locals 1
    .param p1, "featureId"    # I
    .param p2, "menu"    # Landroid/view/Menu;

    .line 2587
    invoke-super {p0, p1, p2}, La/b/d/d/j;->onMenuOpened(ILandroid/view/Menu;)Z

    .line 2588
    iget-object v0, p0, Landroid/support/v7/app/x$c;->b:Landroid/support/v7/app/x;

    invoke-virtual {v0, p1}, Landroid/support/v7/app/x;->g(I)V

    .line 2589
    const/4 v0, 0x1

    return v0
.end method

.method public onPanelClosed(ILandroid/view/Menu;)V
    .locals 1
    .param p1, "featureId"    # I
    .param p2, "menu"    # Landroid/view/Menu;

    .line 2594
    invoke-super {p0, p1, p2}, La/b/d/d/j;->onPanelClosed(ILandroid/view/Menu;)V

    .line 2595
    iget-object v0, p0, Landroid/support/v7/app/x$c;->b:Landroid/support/v7/app/x;

    invoke-virtual {v0, p1}, Landroid/support/v7/app/x;->h(I)V

    .line 2596
    return-void
.end method

.method public onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z
    .locals 3
    .param p1, "featureId"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "menu"    # Landroid/view/Menu;

    .line 2560
    instance-of v0, p3, Landroid/support/v7/view/menu/l;

    if-eqz v0, :cond_0

    move-object v0, p3

    check-cast v0, Landroid/support/v7/view/menu/l;

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 2562
    .local v0, "mb":Landroid/support/v7/view/menu/l;
    :goto_0
    const/4 v1, 0x0

    if-nez p1, :cond_1

    if-nez v0, :cond_1

    .line 2565
    return v1

    .line 2572
    :cond_1
    if-eqz v0, :cond_2

    .line 2573
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/support/v7/view/menu/l;->c(Z)V

    .line 2576
    :cond_2
    invoke-super {p0, p1, p2, p3}, La/b/d/d/j;->onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z

    move-result v2

    .line 2578
    .local v2, "handled":Z
    if-eqz v0, :cond_3

    .line 2579
    invoke-virtual {v0, v1}, Landroid/support/v7/view/menu/l;->c(Z)V

    .line 2582
    :cond_3
    return v2
.end method

.method public onProvideKeyboardShortcuts(Ljava/util/List;Landroid/view/Menu;I)V
    .locals 3
    .param p2, "menu"    # Landroid/view/Menu;
    .param p3, "deviceId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroid/view/KeyboardShortcutGroup;",
            ">;",
            "Landroid/view/Menu;",
            "I)V"
        }
    .end annotation

    .line 2653
    .local p1, "data":Ljava/util/List;, "Ljava/util/List<Landroid/view/KeyboardShortcutGroup;>;"
    iget-object v0, p0, Landroid/support/v7/app/x$c;->b:Landroid/support/v7/app/x;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/app/x;->a(IZ)Landroid/support/v7/app/x$f;

    move-result-object v0

    .line 2654
    .local v0, "panel":Landroid/support/v7/app/x$f;
    if-eqz v0, :cond_0

    iget-object v1, v0, Landroid/support/v7/app/x$f;->j:Landroid/support/v7/view/menu/l;

    if-eqz v1, :cond_0

    .line 2657
    invoke-super {p0, p1, v1, p3}, La/b/d/d/j;->onProvideKeyboardShortcuts(Ljava/util/List;Landroid/view/Menu;I)V

    goto :goto_0

    .line 2660
    :cond_0
    invoke-super {p0, p1, p2, p3}, La/b/d/d/j;->onProvideKeyboardShortcuts(Ljava/util/List;Landroid/view/Menu;I)V

    .line 2662
    :goto_0
    return-void
.end method

.method public onWindowStartingActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;
    .locals 2
    .param p1, "callback"    # Landroid/view/ActionMode$Callback;

    .line 2601
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x17

    if-lt v0, v1, :cond_0

    .line 2603
    const/4 v0, 0x0

    return-object v0

    .line 2606
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/x$c;->b:Landroid/support/v7/app/x;

    invoke-virtual {v0}, Landroid/support/v7/app/x;->p()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2607
    invoke-virtual {p0, p1}, Landroid/support/v7/app/x$c;->a(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;

    move-result-object v0

    return-object v0

    .line 2610
    :cond_1
    invoke-super {p0, p1}, La/b/d/d/j;->onWindowStartingActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;

    move-result-object v0

    return-object v0
.end method

.method public onWindowStartingActionMode(Landroid/view/ActionMode$Callback;I)Landroid/view/ActionMode;
    .locals 1
    .param p1, "callback"    # Landroid/view/ActionMode$Callback;
    .param p2, "type"    # I

    .line 2638
    iget-object v0, p0, Landroid/support/v7/app/x$c;->b:Landroid/support/v7/app/x;

    invoke-virtual {v0}, Landroid/support/v7/app/x;->p()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2639
    if-eqz p2, :cond_0

    goto :goto_0

    .line 2642
    :cond_0
    invoke-virtual {p0, p1}, Landroid/support/v7/app/x$c;->a(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;

    move-result-object v0

    return-object v0

    .line 2646
    :cond_1
    :goto_0
    invoke-super {p0, p1, p2}, La/b/d/d/j;->onWindowStartingActionMode(Landroid/view/ActionMode$Callback;I)Landroid/view/ActionMode;

    move-result-object v0

    return-object v0
.end method
