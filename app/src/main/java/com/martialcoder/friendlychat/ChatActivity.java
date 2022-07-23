package com.martialcoder.friendlychat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DatabaseReference;
import de.hdodenhof.circleimageview.CircleImageView;


public class ChatActivity extends AppCompatActivity {

    private RecyclerView mMessageRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private ShimmerFrameLayout mShimmerViewContainer;
    private static final String TAG = "UserActivity";
    public static final String PRIVATE_MESSAGES_CHILD = "messages";
    private DatabaseReference mFirebaseDatabaseReferencePrivate;

    private FirebaseRecyclerAdapter<FriendlyMessage, MainActivity.MessageViewHolder> mFirebaseAdapter;

    public static class MessageViewHolder extends RecyclerView.ViewHolder {

        TextView messageTextView;
        ImageView messageImageView;
        TextView messengerTextView;
        CircleImageView messengerImageView;

        public MessageViewHolder(View v) {
            super(v);
            messageTextView = itemView.findViewById(R.id.messageTextView);
            messageImageView = itemView.findViewById(R.id.messageImageView);
            messengerTextView = itemView.findViewById(R.id.messengerTextView);
            messengerImageView = itemView.findViewById(R.id.messengerImageView);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mMessageRecyclerView = findViewById(R.id.messageRecyclerViewChat);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setStackFromEnd(true);
        mMessageRecyclerView.setLayoutManager(mLinearLayoutManager);

        DatabaseReference messagesRef = mFirebaseDatabaseReferencePrivate.child(PRIVATE_MESSAGES_CHILD);

        SnapshotParser<FriendlyMessage> parserPrivate = dataSnapshot -> {
            FriendlyMessage friendlyMessage = dataSnapshot.getValue(FriendlyMessage.class);
            if (friendlyMessage != null) {
                friendlyMessage.setId(dataSnapshot.getKey());
            }
            assert friendlyMessage != null;
            return friendlyMessage;
        };

        FirebaseRecyclerOptions<FriendlyMessage> options =
                new FirebaseRecyclerOptions.Builder<FriendlyMessage>()
                        .setQuery(messagesRef, parserPrivate)
                        .build();

    }
}
