package com.example.muntugo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

    public class AnnouncementAdapter extends RecyclerView.Adapter<AnnouncementAdapter.AnnouncementViewHolder> {

        private List<String> announcements;

        public AnnouncementAdapter(List<String> announcements) {
            this.announcements = announcements;
        }

        @NonNull
        @Override
        public AnnouncementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            return new AnnouncementViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AnnouncementViewHolder holder, int position) {
            holder.bind(announcements.get(position));
        }

        @Override
        public int getItemCount() {
            return announcements.size();
        }

        static class AnnouncementViewHolder extends RecyclerView.ViewHolder {
            private TextView textView;

            public AnnouncementViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = (TextView) itemView;
            }

            public void bind(String announcement) {
                textView.setText(announcement);
            }
        }
    }

