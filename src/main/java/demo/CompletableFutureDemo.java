package demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author liuyangyang
 * @date 2018/12/4 14:08
 * description:  CompletableFuture Demo
 */

public class CompletableFutureDemo {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
//		CompletableFuture<String> future = new CompletableFuture<String>();
//		future.complete("Future's Result");
//		String result = future.get();
//		System.out.println(result);

//		CompletableFuture<String> future = CompletableFuture.supplyAsync(
//				() ->
//				{
//					System.out.println("Hello World!");
//					return "hihi";
//				}
//		);
//
//		System.out.println(future.get());
//		System.out.println("hello");


//		CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
//			try {
//				TimeUnit.SECONDS.sleep(10);
//			} catch (InterruptedException e) {
//				throw new IllegalStateException(e);
//			}
//			return "Rajeev";
//		});
//		System.out.println("1");
		// Attach a callback to the Future using thenApply()
//		while(!whatsYourNameFuture.isDone())
//		{
//			TimeUnit.SECONDS.sleep(1);
//			System.out.println("a");
//		}
//		CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
//			return "Hello " + name;
//		});
//		System.out.println(greetingFuture.get());
//		System.out.println("2");

		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			int i = 1 / 0;
			return 100;
		});
future.join();
//		future.get();
		System.out.println(future.get());
	}
}
