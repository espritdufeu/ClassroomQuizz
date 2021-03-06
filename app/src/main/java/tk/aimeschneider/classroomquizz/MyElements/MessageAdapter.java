package tk.aimeschneider.classroomquizz.MyElements;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import tk.aimeschneider.classroomquizz.ModelOnly.Message;
import tk.aimeschneider.classroomquizz.R;

/**
 * Created by Back Packer
 * Date : 09/07/15
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {

    private ArrayList<Message> messages;

    private static final int RIGHT = 0, LEFT = 1;


    public MessageAdapter(ArrayList<Message> messages) {
        this.messages = messages;
    }


    /**
     *  On utilise cette méthode pour pouvoir afficher après la "bonne" vue
     *  Si c'est notre message alors cela sera "RIGHT"
     *  et si ce sont les messages des autres alors "LEFT"
     */
    @Override
    public int getItemViewType(int position) {

        if(messages.get(position).isMe())
            return RIGHT;
        else
            return LEFT;

    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;

        switch (viewType) {

            case RIGHT:

                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_message_right, parent,false);

                break;

            case LEFT:

                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_message_left, parent,false);

                break;
        }

        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.bind(message);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
