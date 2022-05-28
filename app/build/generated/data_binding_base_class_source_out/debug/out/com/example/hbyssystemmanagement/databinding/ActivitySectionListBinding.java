// Generated by view binder compiler. Do not edit!
package com.example.hbyssystemmanagement.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.hbyssystemmanagement.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySectionListBinding implements ViewBinding {
  @NonNull
  private final SwipeRefreshLayout rootView;

  @NonNull
  public final RecyclerView recyclerSection;

  @NonNull
  public final EditText searchTextSection;

  @NonNull
  public final SwipeRefreshLayout swipeRefreshLayoutSection;

  private ActivitySectionListBinding(@NonNull SwipeRefreshLayout rootView,
      @NonNull RecyclerView recyclerSection, @NonNull EditText searchTextSection,
      @NonNull SwipeRefreshLayout swipeRefreshLayoutSection) {
    this.rootView = rootView;
    this.recyclerSection = recyclerSection;
    this.searchTextSection = searchTextSection;
    this.swipeRefreshLayoutSection = swipeRefreshLayoutSection;
  }

  @Override
  @NonNull
  public SwipeRefreshLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySectionListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySectionListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_section_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySectionListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.recycler_section;
      RecyclerView recyclerSection = ViewBindings.findChildViewById(rootView, id);
      if (recyclerSection == null) {
        break missingId;
      }

      id = R.id.searchTextSection;
      EditText searchTextSection = ViewBindings.findChildViewById(rootView, id);
      if (searchTextSection == null) {
        break missingId;
      }

      SwipeRefreshLayout swipeRefreshLayoutSection = (SwipeRefreshLayout) rootView;

      return new ActivitySectionListBinding((SwipeRefreshLayout) rootView, recyclerSection,
          searchTextSection, swipeRefreshLayoutSection);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
