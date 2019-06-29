.class final La/b/c/g/d$a;
.super Landroid/view/View$AccessibilityDelegate;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/c/g/d;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "a"
.end annotation


# instance fields
.field private final a:La/b/c/g/d;


# direct methods
.method constructor <init>(La/b/c/g/d;)V
    .locals 0
    .param p1, "compat"    # La/b/c/g/d;

    .line 52
    invoke-direct {p0}, Landroid/view/View$AccessibilityDelegate;-><init>()V

    .line 53
    iput-object p1, p0, La/b/c/g/d$a;->a:La/b/c/g/d;

    .line 54
    return-void
.end method


# virtual methods
.method public dispatchPopulateAccessibilityEvent(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)Z
    .locals 1
    .param p1, "host"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .line 59
    iget-object v0, p0, La/b/c/g/d$a;->a:La/b/c/g/d;

    invoke-virtual {v0, p1, p2}, La/b/c/g/d;->a(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)Z

    move-result v0

    return v0
.end method

.method public getAccessibilityNodeProvider(Landroid/view/View;)Landroid/view/accessibility/AccessibilityNodeProvider;
    .locals 2
    .param p1, "host"    # Landroid/view/View;

    .line 98
    iget-object v0, p0, La/b/c/g/d$a;->a:La/b/c/g/d;

    .line 99
    invoke-virtual {v0, p1}, La/b/c/g/d;->a(Landroid/view/View;)La/b/c/g/a/b;

    move-result-object v0

    .line 100
    .local v0, "provider":La/b/c/g/a/b;
    if-eqz v0, :cond_0

    .line 101
    invoke-virtual {v0}, La/b/c/g/a/b;->a()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/accessibility/AccessibilityNodeProvider;

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    return-object v1
.end method

.method public onInitializeAccessibilityEvent(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 1
    .param p1, "host"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .line 64
    iget-object v0, p0, La/b/c/g/d$a;->a:La/b/c/g/d;

    invoke-virtual {v0, p1, p2}, La/b/c/g/d;->b(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)V

    .line 65
    return-void
.end method

.method public onInitializeAccessibilityNodeInfo(Landroid/view/View;Landroid/view/accessibility/AccessibilityNodeInfo;)V
    .locals 2
    .param p1, "host"    # Landroid/view/View;
    .param p2, "info"    # Landroid/view/accessibility/AccessibilityNodeInfo;

    .line 70
    iget-object v0, p0, La/b/c/g/d$a;->a:La/b/c/g/d;

    .line 71
    invoke-static {p2}, La/b/c/g/a/a;->a(Landroid/view/accessibility/AccessibilityNodeInfo;)La/b/c/g/a/a;

    move-result-object v1

    .line 70
    invoke-virtual {v0, p1, v1}, La/b/c/g/d;->a(Landroid/view/View;La/b/c/g/a/a;)V

    .line 72
    return-void
.end method

.method public onPopulateAccessibilityEvent(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 1
    .param p1, "host"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .line 76
    iget-object v0, p0, La/b/c/g/d$a;->a:La/b/c/g/d;

    invoke-virtual {v0, p1, p2}, La/b/c/g/d;->c(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)V

    .line 77
    return-void
.end method

.method public onRequestSendAccessibilityEvent(Landroid/view/ViewGroup;Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)Z
    .locals 1
    .param p1, "host"    # Landroid/view/ViewGroup;
    .param p2, "child"    # Landroid/view/View;
    .param p3, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .line 82
    iget-object v0, p0, La/b/c/g/d$a;->a:La/b/c/g/d;

    invoke-virtual {v0, p1, p2, p3}, La/b/c/g/d;->a(Landroid/view/ViewGroup;Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)Z

    move-result v0

    return v0
.end method

.method public performAccessibilityAction(Landroid/view/View;ILandroid/os/Bundle;)Z
    .locals 1
    .param p1, "host"    # Landroid/view/View;
    .param p2, "action"    # I
    .param p3, "args"    # Landroid/os/Bundle;

    .line 106
    iget-object v0, p0, La/b/c/g/d$a;->a:La/b/c/g/d;

    invoke-virtual {v0, p1, p2, p3}, La/b/c/g/d;->a(Landroid/view/View;ILandroid/os/Bundle;)Z

    move-result v0

    return v0
.end method

.method public sendAccessibilityEvent(Landroid/view/View;I)V
    .locals 1
    .param p1, "host"    # Landroid/view/View;
    .param p2, "eventType"    # I

    .line 87
    iget-object v0, p0, La/b/c/g/d$a;->a:La/b/c/g/d;

    invoke-virtual {v0, p1, p2}, La/b/c/g/d;->a(Landroid/view/View;I)V

    .line 88
    return-void
.end method

.method public sendAccessibilityEventUnchecked(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)V
    .locals 1
    .param p1, "host"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .line 92
    iget-object v0, p0, La/b/c/g/d$a;->a:La/b/c/g/d;

    invoke-virtual {v0, p1, p2}, La/b/c/g/d;->d(Landroid/view/View;Landroid/view/accessibility/AccessibilityEvent;)V

    .line 93
    return-void
.end method
