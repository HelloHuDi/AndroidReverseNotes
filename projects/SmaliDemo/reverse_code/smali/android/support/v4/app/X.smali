.class public Landroid/support/v4/app/X;
.super Landroid/app/Activity;
.source ""

# interfaces
.implements Landroid/arch/lifecycle/f;
.implements La/b/c/g/g$a;


# instance fields
.field private a:La/b/c/f/m;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "La/b/c/f/m<",
            "Ljava/lang/Class<",
            "+",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private b:Landroid/arch/lifecycle/h;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 46
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 53
    new-instance v0, La/b/c/f/m;

    invoke-direct {v0}, La/b/c/f/m;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/X;->a:La/b/c/f/m;

    .line 56
    new-instance v0, Landroid/arch/lifecycle/h;

    invoke-direct {v0, p0}, Landroid/arch/lifecycle/h;-><init>(Landroid/arch/lifecycle/f;)V

    iput-object v0, p0, Landroid/support/v4/app/X;->b:Landroid/arch/lifecycle/h;

    .line 132
    return-void
.end method


# virtual methods
.method public a()Landroid/arch/lifecycle/d;
    .locals 1

    .line 99
    iget-object v0, p0, Landroid/support/v4/app/X;->b:Landroid/arch/lifecycle/h;

    return-object v0
.end method

.method public a(Landroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/KeyEvent;

    .line 108
    invoke-super {p0, p1}, Landroid/app/Activity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/KeyEvent;

    .line 122
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 123
    .local v0, "decor":Landroid/view/View;
    if-eqz v0, :cond_0

    invoke-static {v0, p1}, La/b/c/g/g;->a(Landroid/view/View;Landroid/view/KeyEvent;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 124
    const/4 v1, 0x1

    return v1

    .line 126
    :cond_0
    invoke-static {p0, v0, p0, p1}, La/b/c/g/g;->a(La/b/c/g/g$a;Landroid/view/View;Landroid/view/Window$Callback;Landroid/view/KeyEvent;)Z

    move-result v1

    return v1
.end method

.method public dispatchKeyShortcutEvent(Landroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/KeyEvent;

    .line 113
    invoke-virtual {p0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 114
    .local v0, "decor":Landroid/view/View;
    if-eqz v0, :cond_0

    invoke-static {v0, p1}, La/b/c/g/g;->a(Landroid/view/View;Landroid/view/KeyEvent;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 115
    const/4 v1, 0x1

    return v1

    .line 117
    :cond_0
    invoke-super {p0, p1}, Landroid/app/Activity;->dispatchKeyShortcutEvent(Landroid/view/KeyEvent;)Z

    move-result v1

    return v1
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 75
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 76
    invoke-static {p0}, Landroid/arch/lifecycle/p;->a(Landroid/app/Activity;)V

    .line 77
    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .line 82
    iget-object v0, p0, Landroid/support/v4/app/X;->b:Landroid/arch/lifecycle/h;

    sget-object v1, Landroid/arch/lifecycle/d$b;->c:Landroid/arch/lifecycle/d$b;

    invoke-virtual {v0, v1}, Landroid/arch/lifecycle/h;->a(Landroid/arch/lifecycle/d$b;)V

    .line 83
    invoke-super {p0, p1}, Landroid/app/Activity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 84
    return-void
.end method
