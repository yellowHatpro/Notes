use std::io;

fn main() {
    println!("Hello, world!");
    let mut enterNum = String::new();
    let res = io::stdin()
        .read_line(&mut enterNum)
        .expect("Failed to read line");
    println!("{enterNum}");
    println!()
}
