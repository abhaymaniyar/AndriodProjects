package com.hotwaxsystems.retrofit1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by abhay on 25/2/17.
 */
public class GitHubRepoAdapter extends ArrayAdapter<GitHubRepo> {
    public GitHubRepoAdapter(Activity context, List<GitHubRepo> repos) {
        super(context, 0, repos);
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_content_layout, viewGroup, false);
        }

        GitHubRepo currentGitHubRepo = getItem(position);

        TextView nameOfRepo = (TextView) view.findViewById(R.id.repo_name);
        nameOfRepo.setText(currentGitHubRepo.getName());
        return view;
    }

}
