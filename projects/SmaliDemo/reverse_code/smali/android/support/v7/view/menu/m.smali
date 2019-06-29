.class Landroid/support/v7/view/menu/m;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/content/DialogInterface$OnKeyListener;
.implements Landroid/content/DialogInterface$OnClickListener;
.implements Landroid/content/DialogInterface$OnDismissListener;
.implements Landroid/support/v7/view/menu/v$a;


# instance fields
.field private a:Landroid/support/v7/view/menu/l;

.field private b:Landroid/support/v7/app/l;

.field c:Landroid/support/v7/view/menu/j;

.field private d:Landroid/support/v7/view/menu/v$a;


# direct methods
.method public constructor <init>(Landroid/support/v7/view/menu/l;)V
    .locals 0
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;

    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    iput-object p1, p0, Landroid/support/v7/view/menu/m;->a:Landroid/support/v7/view/menu/l;

    .line 44
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .line 139
    iget-object v0, p0, Landroid/support/v7/view/menu/m;->b:Landroid/support/v7/app/l;

    if-eqz v0, :cond_0

    .line 140
    invoke-virtual {v0}, Landroid/app/Dialog;->dismiss()V

    .line 142
    :cond_0
    return-void
.end method

.method public a(Landroid/os/IBinder;)V
    .locals 6
    .param p1, "windowToken"    # Landroid/os/IBinder;

    .line 53
    iget-object v0, p0, Landroid/support/v7/view/menu/m;->a:Landroid/support/v7/view/menu/l;

    .line 56
    .local v0, "menu":Landroid/support/v7/view/menu/l;
    new-instance v1, Landroid/support/v7/app/l$a;

    invoke-virtual {v0}, Landroid/support/v7/view/menu/l;->e()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/support/v7/app/l$a;-><init>(Landroid/content/Context;)V

    .line 58
    .local v1, "builder":Landroid/support/v7/app/l$a;
    new-instance v2, Landroid/support/v7/view/menu/j;

    invoke-virtual {v1}, Landroid/support/v7/app/l$a;->b()Landroid/content/Context;

    move-result-object v3

    sget v4, La/b/d/a/g;->abc_list_menu_item_layout:I

    invoke-direct {v2, v3, v4}, Landroid/support/v7/view/menu/j;-><init>(Landroid/content/Context;I)V

    iput-object v2, p0, Landroid/support/v7/view/menu/m;->c:Landroid/support/v7/view/menu/j;

    .line 61
    iget-object v2, p0, Landroid/support/v7/view/menu/m;->c:Landroid/support/v7/view/menu/j;

    invoke-virtual {v2, p0}, Landroid/support/v7/view/menu/j;->a(Landroid/support/v7/view/menu/v$a;)V

    .line 62
    iget-object v2, p0, Landroid/support/v7/view/menu/m;->a:Landroid/support/v7/view/menu/l;

    iget-object v3, p0, Landroid/support/v7/view/menu/m;->c:Landroid/support/v7/view/menu/j;

    invoke-virtual {v2, v3}, Landroid/support/v7/view/menu/l;->a(Landroid/support/v7/view/menu/v;)V

    .line 63
    iget-object v2, p0, Landroid/support/v7/view/menu/m;->c:Landroid/support/v7/view/menu/j;

    invoke-virtual {v2}, Landroid/support/v7/view/menu/j;->b()Landroid/widget/ListAdapter;

    move-result-object v2

    invoke-virtual {v1, v2, p0}, Landroid/support/v7/app/l$a;->a(Landroid/widget/ListAdapter;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/l$a;

    .line 66
    invoke-virtual {v0}, Landroid/support/v7/view/menu/l;->i()Landroid/view/View;

    move-result-object v2

    .line 67
    .local v2, "headerView":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 69
    invoke-virtual {v1, v2}, Landroid/support/v7/app/l$a;->a(Landroid/view/View;)Landroid/support/v7/app/l$a;

    goto :goto_0

    .line 72
    :cond_0
    invoke-virtual {v0}, Landroid/support/v7/view/menu/l;->g()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/support/v7/app/l$a;->a(Landroid/graphics/drawable/Drawable;)Landroid/support/v7/app/l$a;

    invoke-virtual {v0}, Landroid/support/v7/view/menu/l;->h()Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/support/v7/app/l$a;->a(Ljava/lang/CharSequence;)Landroid/support/v7/app/l$a;

    .line 76
    :goto_0
    invoke-virtual {v1, p0}, Landroid/support/v7/app/l$a;->a(Landroid/content/DialogInterface$OnKeyListener;)Landroid/support/v7/app/l$a;

    .line 79
    invoke-virtual {v1}, Landroid/support/v7/app/l$a;->a()Landroid/support/v7/app/l;

    move-result-object v3

    iput-object v3, p0, Landroid/support/v7/view/menu/m;->b:Landroid/support/v7/app/l;

    .line 80
    iget-object v3, p0, Landroid/support/v7/view/menu/m;->b:Landroid/support/v7/app/l;

    invoke-virtual {v3, p0}, Landroid/app/Dialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 82
    iget-object v3, p0, Landroid/support/v7/view/menu/m;->b:Landroid/support/v7/app/l;

    invoke-virtual {v3}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v3

    .line 83
    .local v3, "lp":Landroid/view/WindowManager$LayoutParams;
    const/16 v4, 0x3eb

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->type:I

    .line 84
    if-eqz p1, :cond_1

    .line 85
    iput-object p1, v3, Landroid/view/WindowManager$LayoutParams;->token:Landroid/os/IBinder;

    .line 87
    :cond_1
    iget v4, v3, Landroid/view/WindowManager$LayoutParams;->flags:I

    const/high16 v5, 0x20000

    or-int/2addr v4, v5

    iput v4, v3, Landroid/view/WindowManager$LayoutParams;->flags:I

    .line 89
    iget-object v4, p0, Landroid/support/v7/view/menu/m;->b:Landroid/support/v7/app/l;

    invoke-virtual {v4}, Landroid/app/Dialog;->show()V

    .line 90
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/l;Z)V
    .locals 1
    .param p1, "menu"    # Landroid/support/v7/view/menu/l;
    .param p2, "allMenusAreClosing"    # Z

    .line 151
    if-nez p2, :cond_0

    iget-object v0, p0, Landroid/support/v7/view/menu/m;->a:Landroid/support/v7/view/menu/l;

    if-ne p1, v0, :cond_1

    .line 152
    :cond_0
    invoke-virtual {p0}, Landroid/support/v7/view/menu/m;->a()V

    .line 154
    :cond_1
    iget-object v0, p0, Landroid/support/v7/view/menu/m;->d:Landroid/support/v7/view/menu/v$a;

    if-eqz v0, :cond_2

    .line 155
    invoke-interface {v0, p1, p2}, Landroid/support/v7/view/menu/v$a;->a(Landroid/support/v7/view/menu/l;Z)V

    .line 157
    :cond_2
    return-void
.end method

.method public a(Landroid/support/v7/view/menu/l;)Z
    .locals 1
    .param p1, "subMenu"    # Landroid/support/v7/view/menu/l;

    .line 161
    iget-object v0, p0, Landroid/support/v7/view/menu/m;->d:Landroid/support/v7/view/menu/v$a;

    if-eqz v0, :cond_0

    .line 162
    invoke-interface {v0, p1}, Landroid/support/v7/view/menu/v$a;->a(Landroid/support/v7/view/menu/l;)Z

    move-result v0

    return v0

    .line 164
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .line 169
    iget-object v0, p0, Landroid/support/v7/view/menu/m;->a:Landroid/support/v7/view/menu/l;

    iget-object v1, p0, Landroid/support/v7/view/menu/m;->c:Landroid/support/v7/view/menu/j;

    invoke-virtual {v1}, Landroid/support/v7/view/menu/j;->b()Landroid/widget/ListAdapter;

    move-result-object v1

    invoke-interface {v1, p2}, Landroid/widget/ListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v7/view/menu/p;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/view/menu/l;->a(Landroid/view/MenuItem;I)Z

    .line 170
    return-void
.end method

.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .line 146
    iget-object v0, p0, Landroid/support/v7/view/menu/m;->c:Landroid/support/v7/view/menu/j;

    iget-object v1, p0, Landroid/support/v7/view/menu/m;->a:Landroid/support/v7/view/menu/l;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/support/v7/view/menu/j;->a(Landroid/support/v7/view/menu/l;Z)V

    .line 147
    return-void
.end method

.method public onKey(Landroid/content/DialogInterface;ILandroid/view/KeyEvent;)Z
    .locals 5
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .line 94
    const/16 v0, 0x52

    if-eq p2, v0, :cond_0

    const/4 v0, 0x4

    if-ne p2, v0, :cond_3

    .line 95
    :cond_0
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v0

    const/4 v1, 0x1

    if-nez v0, :cond_1

    .line 96
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v0

    if-nez v0, :cond_1

    .line 97
    iget-object v0, p0, Landroid/support/v7/view/menu/m;->b:Landroid/support/v7/app/l;

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    .line 98
    .local v0, "win":Landroid/view/Window;
    if-eqz v0, :cond_2

    .line 99
    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v2

    .line 100
    .local v2, "decor":Landroid/view/View;
    if-eqz v2, :cond_2

    .line 101
    invoke-virtual {v2}, Landroid/view/View;->getKeyDispatcherState()Landroid/view/KeyEvent$DispatcherState;

    move-result-object v3

    .line 102
    .local v3, "ds":Landroid/view/KeyEvent$DispatcherState;
    if-eqz v3, :cond_2

    .line 103
    invoke-virtual {v3, p3, p0}, Landroid/view/KeyEvent$DispatcherState;->startTracking(Landroid/view/KeyEvent;Ljava/lang/Object;)V

    .line 104
    return v1

    .line 108
    .end local v0    # "win":Landroid/view/Window;
    .end local v2    # "decor":Landroid/view/View;
    .end local v3    # "ds":Landroid/view/KeyEvent$DispatcherState;
    :cond_1
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v0

    if-ne v0, v1, :cond_2

    invoke-virtual {p3}, Landroid/view/KeyEvent;->isCanceled()Z

    move-result v0

    if-nez v0, :cond_2

    .line 109
    iget-object v0, p0, Landroid/support/v7/view/menu/m;->b:Landroid/support/v7/app/l;

    invoke-virtual {v0}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    .line 110
    .restart local v0    # "win":Landroid/view/Window;
    if-eqz v0, :cond_3

    .line 111
    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v2

    .line 112
    .restart local v2    # "decor":Landroid/view/View;
    if-eqz v2, :cond_3

    .line 113
    invoke-virtual {v2}, Landroid/view/View;->getKeyDispatcherState()Landroid/view/KeyEvent$DispatcherState;

    move-result-object v3

    .line 114
    .restart local v3    # "ds":Landroid/view/KeyEvent$DispatcherState;
    if-eqz v3, :cond_3

    invoke-virtual {v3, p3}, Landroid/view/KeyEvent$DispatcherState;->isTracking(Landroid/view/KeyEvent;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 115
    iget-object v4, p0, Landroid/support/v7/view/menu/m;->a:Landroid/support/v7/view/menu/l;

    invoke-virtual {v4, v1}, Landroid/support/v7/view/menu/l;->a(Z)V

    .line 116
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 117
    return v1

    .line 108
    .end local v0    # "win":Landroid/view/Window;
    .end local v2    # "decor":Landroid/view/View;
    .end local v3    # "ds":Landroid/view/KeyEvent$DispatcherState;
    :cond_2
    nop

    .line 125
    :cond_3
    iget-object v0, p0, Landroid/support/v7/view/menu/m;->a:Landroid/support/v7/view/menu/l;

    const/4 v1, 0x0

    invoke-virtual {v0, p2, p3, v1}, Landroid/support/v7/view/menu/l;->performShortcut(ILandroid/view/KeyEvent;I)Z

    move-result v0

    return v0
.end method
